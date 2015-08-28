package lombax5832.BL2_v2.common.item;

import java.util.List;

import lombax5832.BL2_v2.lib.ItemNames;
import lombax5832.BL2_v2.util.ItemGunInfoUtils;
import lombax5832.BL2_v2.util.ItemGunUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

/**
 * Gun class
 * 
 * @author lombax5832
 */
public class ItemGun extends ItemBL2{
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List list, boolean par4) {
		list.clear();
		GunProperties atr = new GunProperties(stack);
		ItemGunInfoUtils.addGunInfo(list, atr, stack);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
		
		GunProperties atr = new GunProperties(stack);
		
		if(atr.currentAmmo == 0&&!atr.reloading){
        	atr.reloading = true;
        	atr.reloadTicker = 0;
        }
		
		if(((EntityPlayer) entity).getHeldItem() != null && ((EntityPlayer) entity).getHeldItem() == stack){
	        
			if(atr.reloading){
				if(atr.reloadTicker<atr.reloadTotal){
					atr.reloadTicker++;
				}else{
					atr.currentAmmo=atr.maxAmmo;
					atr.reloading=false;
				}
			}
			
	        if(ItemGunUtils.canShoot(atr, (EntityPlayer) entity)){
	        	ItemGunUtils.gunShoot(atr, (EntityPlayer) entity);
	        }
	        
	        ItemGunUtils.handleShotLastTick(atr, (EntityPlayer) entity);
			
//			((EntityPlayer) entity).setItemInUse(stack, this.getMaxItemUseDuration(stack));
			
	        
		}
		
		ItemGunUtils.updateCreatorName(atr, (EntityPlayer) entity);
		
		atr.save(stack);
        
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer entity) {
		GunProperties atr = new GunProperties(stack);
		atr.isShooting = true;
		if(atr.currentAmmo>0)
			atr.rightClickTicker = 0;
		atr.save(stack);
		return stack;
	}
	
	//Used to improve aesthetics of how the player holds the gun
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.bow;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack){
        return 10;
    }
	
	@Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
    {
		return true;
    }
	
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	return true;
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
    	return true;
    }

    public static void reload(ItemStack stack){
    	GunProperties atr = new GunProperties(stack);
    	atr.reloading = true;
    	atr.reloadTicker = 0;
    	atr.save(stack);
    }
	
	/**
	 * Subclass used to store NBT data in the item
	 * 
	 * @author lombax5832
	 */
	public static class GunProperties {
		
		public ItemStack stack;
		
		public String creator = "";
		
		public boolean isShooting = false;
		public boolean shotLastTick = false;
		public boolean isSemiAuto = false;
		
		public int camo = 0;
		
		public int rarity = 0;
		
		public int gunType = 0;
		
		public int currentAmmo = 0;
		public int maxAmmo = 0;
		
		public int fireTicker = 0;
		public int fireRate = 0;
		
		public int reloadTicker = 20;
		public int reloadTotal = 20;
		public boolean reloading = false;
		
		public int shotLastTickTicker = 0;
		
		public int rightClickTicker = 10;
		
		public float recoilCushion = 0;
	
		public GunProperties(ItemStack stack){
			this.stack = stack;
			load(stack);
		}
		
		/**
		 * Saves NBTTagCompound for the passed ItemStack
		 * 
		 * @param stack ItemStack to save properties for
		 */
		public void save(ItemStack stack) {
	        boolean newTag = false;
	        NBTTagCompound tag = stack.getTagCompound();
	        if (tag == null) {
	            tag = new NBTTagCompound();
	            newTag = true;
	        }
	        
	        //Where NBT data is saved
	        tag.setString("creator", creator);
	        
	        tag.setBoolean("isShooting", isShooting);
	        tag.setBoolean("shotLastTick", shotLastTick);
	        tag.setBoolean("isSemiAuto", isSemiAuto);
	        
	        tag.setInteger("camo", camo);
	        
	        tag.setInteger("rarity", rarity);
	        
	        tag.setInteger("gunType", gunType);
	        
	        tag.setInteger("currentAmmo", currentAmmo);
	        tag.setInteger("maxAmmo", maxAmmo);
	        
	        tag.setInteger("fireTicker", fireTicker);
	        tag.setInteger("fireRate", fireRate);
	        
	        tag.setInteger("reloadTicker", reloadTicker);
	        tag.setInteger("reloadTotal", reloadTotal);
	        tag.setBoolean("reloading", reloading);
	        
	        tag.setInteger("shotLastTickTicker", shotLastTickTicker);
	        
	        tag.setInteger("rightClickTicker", rightClickTicker);
	        
	        tag.setFloat("recoilCushion", recoilCushion);
	        
	        if (newTag) {
	            stack.setTagCompound(tag);
	        }
		}
		
		/**
		 * Loads NBTTagCompound for the passed ItemStack
		 * 
		 * @param stack ItemStack to get properties for
		 */
		public void load(ItemStack stack) {
            NBTTagCompound tag = stack.getTagCompound();

            if (tag == null)
                return;

            //Where NBT data is loaded
            creator = tag.getString("creator");
            
            isShooting = tag.getBoolean("isShooting");
            shotLastTick = tag.getBoolean("shotLastTick");
            isSemiAuto = tag.getBoolean("isSemiAuto");
            
            camo = tag.getInteger("camo");
            
            rarity = tag.getInteger("rarity");
            
            gunType = tag.getInteger("gunType");
            
            currentAmmo = tag.getInteger("currentAmmo");
            maxAmmo = tag.getInteger("maxAmmo");
            
            fireTicker = tag.getInteger("fireTicker");
            fireRate = tag.getInteger("fireRate");
            
            reloadTicker = tag.getInteger("reloadTicker");
            reloadTotal = tag.getInteger("reloadTotal");
            reloading = tag.getBoolean("reloading");
            
            shotLastTickTicker = tag.getInteger("shotLastTickTicker");
            
            rightClickTicker = tag.getInteger("rightClickTicker");
            
            recoilCushion = tag.getFloat("recoilCushion");
		}
	}
}
