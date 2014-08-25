package lombax5832.BL2_v2.common.item;

import java.util.List;

import lombax5832.BL2_v2.lib.ItemNames;
import lombax5832.BL2_v2.util.ItemGunUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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
		list.add(StatCollector.translateToLocal(this.getUnlocalizedName()));
		GunProperties atr = new GunProperties(stack);
		ItemGunUtils.addCreatorName(list, atr);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
		GunProperties atr = new GunProperties(stack);
        if (atr.creator == "" && entity instanceof EntityPlayer) {
            atr.creator = ((EntityPlayer) entity).getDisplayName();
        }
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
		}
	}
}
