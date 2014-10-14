package lombax5832.BL2_v2.client.settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandlerBL2 {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(KeyBindingBL2.reload.isPressed()){
			System.out.println("R Pressed!");
		}
	}
}
