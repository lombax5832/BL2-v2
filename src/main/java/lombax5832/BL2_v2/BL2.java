package lombax5832.BL2_v2;

import lombax5832.BL2_v2.client.settings.KeyInputHandlerBL2;
import lombax5832.BL2_v2.common.CommonProxy;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.lib.Strings;
import lombax5832.BL2_v2.network.BL2FireGunMessage;
import lombax5832.BL2_v2.network.BL2ReloadMessage;
import lombax5832.BL2_v2.network.BL2RenderGunMessage;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Core class of BL2 v2!
 * 
 * @author lombax5832
 */
@Mod(modid = Strings.MOD_ID,name = Strings.MOD_NAME,version = Strings.MOD_VERSION)
public class BL2 {
	
	@SidedProxy(clientSide = "lombax5832.BL2_v2.client.ClientProxy", serverSide="lombax5832.BL2_v2.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static SimpleNetworkWrapper networkBL2;
	
	@Instance(Strings.MOD_ID)
	public static BL2 instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.initItems();
		proxy.addModels();
		networkBL2 = NetworkRegistry.INSTANCE.newSimpleChannel(Strings.MOD_ID);
		networkBL2.registerMessage(BL2ReloadMessage.Handler.class, BL2ReloadMessage.class, 0, Side.SERVER);
		networkBL2.registerMessage(BL2FireGunMessage.Handler.class, BL2FireGunMessage.class, 1, Side.SERVER);
		networkBL2.registerMessage(BL2RenderGunMessage.Handler.class, BL2RenderGunMessage.class, 2, Side.CLIENT);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.addTextures();
		proxy.registerItemRenderer();
		proxy.registerRenderTickHandler();
		proxy.addKeyBindings();
		FMLCommonHandler.instance().bus().register(new KeyInputHandlerBL2());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
