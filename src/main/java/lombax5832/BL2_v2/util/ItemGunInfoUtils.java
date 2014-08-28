package lombax5832.BL2_v2.util;

import java.util.List;

import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.resource.TextureLocation;
import lombax5832.BL2_v2.lib.Colors;
import lombax5832.BL2_v2.lib.Unlocalized;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 * Utility classes to reduce clutter in the main ItemGun class
 * 
 * @author lombax5832
 */
public class ItemGunInfoUtils {
	/**
	 * Adds the name of the first person to pick up the item to the description 
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static void addCreatorName(List list, GunProperties atr){
		if(atr.creator != "")
			list.add(StatCollector.translateToLocal(Unlocalized.STRING_CREATOR)+": "+atr.creator);
	}
	
	/**
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static void addAmmoInfo(List list, GunProperties atr){
		list.add(StatCollector.translateToLocal(Unlocalized.STRING_AMMO)+": "+atr.currentAmmo+"/"+atr.maxAmmo);
	}
	
	/**
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static void addFireRateInfo(List list, GunProperties atr){
		if(atr.fireRate>0&&!atr.isSemiAuto)
			list.add(StatCollector.translateToLocal(Unlocalized.STRING_RPM)+": "+20/atr.fireRate*60);
		else
			list.add(StatCollector.translateToLocal(Unlocalized.STRING_SEMI_AUTO));
	}
	
	/**
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static void addGunName(List list, GunProperties atr, ItemStack stack){
			StringBuilder gunName = new StringBuilder();
			if(atr.rarity>0)
				gunName.append(Colors.rarityColors[atr.rarity-1]);
			gunName.append(StatCollector.translateToLocal(stack.getUnlocalizedName()+".name"));
			String name = gunName.toString();
			list.add(name);
	}
	
	/**
	 * Adds the name of the camouflage to the description
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static void addCamoName(List list, GunProperties atr){
		list.add(StatCollector.translateToLocal(TextureLocation.getGunTextureResourceName(atr.camo))+" "+StatCollector.translateToLocal(Unlocalized.STRING_CAMO));
	}
	
	public static void addGunInfo(List list, GunProperties atr, ItemStack stack){
		addGunName(list, atr, stack);
		addAmmoInfo(list, atr);
		addFireRateInfo(list, atr);
		addCamoName(list, atr);
		addCreatorName(list, atr);
	}
}
