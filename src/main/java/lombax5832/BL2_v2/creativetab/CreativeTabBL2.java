package lombax5832.BL2_v2.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.lib.Strings;

/**
 * Class that adds the creative mode tab for this mod
 * 
 * @author lombax5832
 */
public class CreativeTabBL2 extends CreativeTabs{
	
	public static final CreativeTabs tabBL2 = new CreativeTabBL2(Strings.MOD_ID);
	
	public CreativeTabBL2(String label){
		super(label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ModItems.itemGun;
	}
}
