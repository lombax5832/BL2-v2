package lombax5832.BL2_v2.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lombax5832.BL2_v2.lib.ItemNames;
import lombax5832.BL2_v2.lib.Strings;
import net.minecraft.item.Item;

/**
 * Class where items are located
 * 
 * @author lombax5832
 */
public class ModItems {
	
	public static Item itemGun;
	
	public static Item itemTemp;
	
	/**
	 * Where Items are initialized
	 */
	public static void initItems(){
		itemGun = new ItemGun().setTextureName(Strings.MOD_ID+":"+"pistol").setUnlocalizedName(ItemNames.GUN_DEFAULT_NAME);
		GameRegistry.registerItem(itemGun, ItemNames.GUN_DEFAULT_NAME);
		
		itemTemp = new ItemTemp().setTextureName(Strings.MOD_ID+":"+"temp").setUnlocalizedName(ItemNames.ITEM_TEMP_NAME);
		GameRegistry.registerItem(itemTemp, ItemNames.ITEM_TEMP_NAME);
	}
}
