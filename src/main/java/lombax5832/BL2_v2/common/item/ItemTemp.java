package lombax5832.BL2_v2.common.item;

import lombax5832.BL2_v2.util.ItemGunGenerators;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Temporary item used for debugging the random generator
 * 
 * @author lombax5832
 */
public class ItemTemp extends ItemBL2{
	
	public ItemTemp(){
		super();
		maxStackSize = 1;
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer entity) {
		for(int i=0;i<100;i++)
			entity.dropPlayerItemWithRandomChoice(ItemGunGenerators.genRandomGun(), false);
		stack.stackSize--;
		return stack;
	}
}
