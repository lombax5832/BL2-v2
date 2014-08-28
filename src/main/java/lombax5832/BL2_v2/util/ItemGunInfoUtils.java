package lombax5832.BL2_v2.util;

import java.util.List;
import java.util.Properties;

import net.minecraft.util.StatCollector;

import cpw.mods.fml.common.registry.LanguageRegistry;

import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.resource.TextureLocation;
import lombax5832.BL2_v2.lib.Unlocalized;

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
	 * Adds the name of the camouflage to the description
	 * @param list List to add string to
	 * @param atr GunProperties object to get data from
	 */
	public static void addCamoName(List list, GunProperties atr){
		list.add(StatCollector.translateToLocal(TextureLocation.getResourceName(atr.camo))+" "+StatCollector.translateToLocal(Unlocalized.STRING_CAMO));
	}
	
	public static void addGunInfo(List list, GunProperties atr){
		addAmmoInfo(list, atr);
		addFireRateInfo(list, atr);
		addCamoName(list, atr);
		addCreatorName(list, atr);
	}
}
