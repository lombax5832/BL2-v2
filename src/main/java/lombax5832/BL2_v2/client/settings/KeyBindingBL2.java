package lombax5832.BL2_v2.client.settings;

import lombax5832.BL2_v2.lib.Strings;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindingBL2 {

	public static KeyBinding reload;

	public static void init(){
		reload = new KeyBinding("key.reload",Keyboard.KEY_R,"key.categories."+Strings.MOD_ID);
		
		ClientRegistry.registerKeyBinding(reload);
	}
	
}
