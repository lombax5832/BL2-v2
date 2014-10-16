package lombax5832.BL2_v2.client.settings;

import lombax5832.BL2_v2.BL2;
import lombax5832.BL2_v2.common.item.ItemGun;
import lombax5832.BL2_v2.network.BL2Message;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandlerBL2 {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(KeyBindingBL2.reload.isPressed()){
			if(Minecraft.getMinecraft().thePlayer != null){
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				if(player.getItemInUse()!=null && player.getItemInUse().getItem() instanceof ItemGun){
					BL2.networkBL2.sendToServer(new BL2Message(1,player.getEntityId()));
					System.out.println("Gun in Hand!");
				}
			}
		}
	}
}
