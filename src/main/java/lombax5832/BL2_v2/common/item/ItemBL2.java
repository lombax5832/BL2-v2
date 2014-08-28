package lombax5832.BL2_v2.common.item;

import lombax5832.BL2_v2.creativetab.CreativeTabBL2;
import net.minecraft.item.Item;

public class ItemBL2 extends Item{
	public ItemBL2(){
		this.setCreativeTab(CreativeTabBL2.tabBL2);
	}
	
	@Override
	public String getUnlocalizedName(){
		return super.getUnlocalizedName()+".name";
	}
}
