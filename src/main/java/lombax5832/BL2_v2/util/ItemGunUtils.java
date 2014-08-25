package lombax5832.BL2_v2.util;

import java.util.List;
import java.util.Properties;

import net.minecraft.util.StatCollector;

import cpw.mods.fml.common.registry.LanguageRegistry;

import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.lib.Unlocalized;

/**
 * Utility classes to reduce clutter in the main ItemGun class
 * 
 * @author lombax5832
 */
public class ItemGunUtils {
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
}
