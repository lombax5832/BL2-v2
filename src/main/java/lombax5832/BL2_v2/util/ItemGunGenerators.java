package lombax5832.BL2_v2.util;

import lombax5832.BL2_v2.client.resource.TextureLocation;
import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.item.ModItems;
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
		atr.save(stack);
		return stack;
	}
}
