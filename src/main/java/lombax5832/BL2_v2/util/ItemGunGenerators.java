package lombax5832.BL2_v2.util;

import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.common.resource.TextureLocation;
import net.minecraft.item.ItemStack;

/**
 * Class used to help randomly generate ItemGuns in order to reduce clutter in the ItemGun class
 * 
 * @author lombax5832
 */
public class ItemGunGenerators {
	
	public static ItemStack genRandomGun(){
		ItemStack stack = new ItemStack(ModItems.itemGun);
		GunProperties atr = new GunProperties(stack);
		
		atr.camo = RandomRange.randomRange(0, TextureLocation.getLastIndex());
		atr.isSemiAuto = RandomRange.randomBoolean(50);
		atr.maxAmmo = RandomRange.randomRange(10, 31);
		atr.fireRate = RandomRange.randomRange(2, 10);
//		atr.fireRate = 1;
		atr.shotLastTickTicker = 5;
		atr.fireTicker = atr.fireRate;
		atr.currentAmmo = atr.maxAmmo;
		
		atr.save(stack);
		return stack;
	}
}
