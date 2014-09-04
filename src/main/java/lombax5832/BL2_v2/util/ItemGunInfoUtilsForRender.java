package lombax5832.BL2_v2.util;

import java.util.List;

import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.resource.ModelLocation;
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
public class ItemGunInfoUtilsForRender {
	/**
	 * Adds the name of the first person to pick up the item to the description 
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static String addCreatorName(GunProperties atr){
		if(atr.creator != "")
			return StatCollector.translateToLocal(Unlocalized.STRING_CREATOR)+": "+atr.creator;
		return null;
	}
	
	/**
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static String addAmmoInfo(GunProperties atr){
		return StatCollector.translateToLocal(Unlocalized.STRING_MAXAMMO)+": "+atr.maxAmmo;
	}
	
	/**
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static String addFireRateInfo(GunProperties atr){
		if(atr.fireRate>0&&!atr.isSemiAuto)
			return StatCollector.translateToLocal(Unlocalized.STRING_RPM)+": "+(int)(20F/atr.fireRate*60F);
		else
			return StatCollector.translateToLocal(Unlocalized.STRING_SEMI_AUTO);
	}
	
	/**
	 * 
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static String addGunName(GunProperties atr, ItemStack stack){
			StringBuilder gunName = new StringBuilder();
			if(atr.rarity>0)
				gunName.append(Colors.rarityColors[atr.rarity-1]);
			gunName.append(StatCollector.translateToLocal(ModelLocation.getGunModelName(atr.gunType)+".name"));
			String name = gunName.toString();
			return name;
	}
	
	/**
	 * Adds the name of the camouflage to the description
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 * @return 
	 */
	public static String addCamoName(GunProperties atr){
		return StatCollector.translateToLocal(TextureLocation.getGunTextureResourceName(atr.camo))+" "+StatCollector.translateToLocal(Unlocalized.STRING_CAMO);
	}
	
	public static void addGunInfo(List list, GunProperties atr, ItemStack stack){
		addInfoToList(list, addGunName(atr, stack));
		addInfoToList(list, addAmmoInfo(atr));
		addInfoToList(list, addFireRateInfo(atr));
		addInfoToList(list, addCamoName(atr));
	}
	
	public static void addInfoToList(List list, Object object){
		if(object!=null)
			list.add(object);
	}
}
