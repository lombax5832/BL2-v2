package lombax5832.BL2_v2.util;

import lombax5832.BL2_v2.BL2;
import lombax5832.BL2_v2.common.entity.EntityBullet;
import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.network.BL2FireGunMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Utility classes to reduce clutter in the main ItemGun class
 * 
 * @author lombax5832
 */
public class ItemGunUtils {
	
	static World world;
	
	/**
	 * @param atr GunProperties object to get data from
	 * @return Returns if the gun can shoot or not
	 */
	public static boolean canShoot(GunProperties atr, EntityPlayer entity){
		if(isRightClicking(atr,entity)&&atr.currentAmmo>0&&!atr.reloading)
			return true;
		return false;
	}
	
	/**
	 * Handles most of the logic for shooting the gun
	 * 
	 * @param atr GunProperties object to get data from
	 * @param entity EntityPlayer to get data from
	 */
	public static void gunShoot(GunProperties atr, EntityPlayer entity){
		atr.fireTicker++;
		if(atr.isSemiAuto&&!atr.shotLastTick){
			fireGun(atr, entity);
		}else if(!atr.isSemiAuto&&atr.fireTicker>=atr.fireRate){
			fireGun(atr, entity);
			atr.fireTicker = 0;
		}
	}
	
	/**
	 * Actually handles the firing of the gun
	 * 
	 * @param atr GunProperties object to get data from
	 * @param entity EntityPlayer to get data from
	 */
	public static void fireGun(GunProperties atr, EntityPlayer entity){
		world = entity.worldObj;
		atr.currentAmmo--;
//		world.spawnEntityInWorld(new EntityBullet(world,entity));
		entity.rotationPitch -= 2F;
		atr.recoilCushion += 2F;
		if(world.isRemote)
			BL2.networkBL2.sendToServer(new BL2FireGunMessage(entity.getEntityId()));
//		atr.shotLastTickTicker = 0;
	}
	
	/**
	 * Handles whether or not the gun was fired last tick or not
	 * 
	 * @param atr GunProperties object to get data from
	 * @param entity EntityPlayer to get data from
	 */
	public static void handleShotLastTick(GunProperties atr, EntityPlayer entity){
		
		if(isRightClicking(atr, entity)){
			atr.shotLastTickTicker = 0;
		}
		
		if(atr.shotLastTickTicker<5){
			atr.shotLastTickTicker++;
		}
		
		if(atr.shotLastTickTicker==5){
			atr.shotLastTick = false;
			handleRecoilCushion(atr,entity);
		}else{
			atr.shotLastTick = true;
			atr.isShooting = false;
		}
	}
	
	/**
	 * Returns whether or not the mouse was held down in the last 5 ticks
	 * 
	 * @param atr GunProperties object to get data from
	 * @param entity EntityPlayer to get data from
	 * @return Returns if the mouse was held down in the last 5 ticks
	 */
	public static boolean isRightClicking(GunProperties atr, EntityPlayer entity){
		if(atr.rightClickTicker<5){
			atr.rightClickTicker++;
			return true;
		}
		return false;
	}
	
	/**
	 * Handles the recoil cushion for that tick
	 * 
	 * @param atr GunProperties object to get data from
	 * @param entity EntityPlayer to get data from
	 */
	public static void handleRecoilCushion(GunProperties atr, EntityPlayer entity){
		if(atr.recoilCushion>0.1F){
			float CushionBy = atr.recoilCushion/3;
			entity.rotationPitch += CushionBy;
			atr.recoilCushion -= CushionBy;
		}else
			atr.recoilCushion = 0;
	}
	
	/**
	 * Adds the playername to the gun if they are the first person to pick it up
	 * 
	 * @param atr GunProperties object to get data from
	 * @param entity EntityPlayer to get data from
	 */
	public static void updateCreatorName(GunProperties atr, EntityPlayer entity){
		if (atr.creator == "" && entity instanceof EntityPlayer) {
            atr.creator = ((EntityPlayer) entity).getDisplayName();
        }
	}
}
