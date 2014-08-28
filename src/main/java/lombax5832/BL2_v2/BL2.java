package lombax5832.BL2_v2;

import lombax5832.BL2_v2.common.CommonProxy;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Core class of BL2 v2!
 * 
 * @author lombax5832
 */
@Mod(modid = Strings.MOD_ID,name = Strings.MOD_NAME,version = Strings.MOD_VERSION)
public class BL2 {
	
	@SidedProxy(clientSide = "lombax5832.BL2_v2.client.ClientProxy", serverSide="lombax5832.BL2_v2.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Strings.MOD_ID)
	public static BL2 instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.initItems();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.addTextures();
		proxy.addModels();
		proxy.registerItemRenderer();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
