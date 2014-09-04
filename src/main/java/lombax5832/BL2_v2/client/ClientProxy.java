package lombax5832.BL2_v2.client;

import lombax5832.BL2_v2.client.model.ModelStorageProperties;
import lombax5832.BL2_v2.client.render.RenderItemGunModel;
import lombax5832.BL2_v2.common.CommonProxy;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.common.resource.ModelLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

/**
 * Proxy class to do certain things on the client side
 * 
 * @author lombax5832
 */
public class ClientProxy extends CommonProxy{

	@Override
	public boolean isClient(){
		return true;
	}
	
	@Override
	public void registerItemRenderer(){
		MinecraftForgeClient.registerItemRenderer(ModItems.itemGun, new RenderItemGunModel());
	}
	
	@Override
	public void addModels(){
		ModelLocation.addGunModelResource("pistol",	new ModelStorageProperties(-0.5F,0F,0.5F, 0F, 0F, 1F, 0F), new ModelStorageProperties(1F,1F,1F,110F,-1F,1F,0F), new ModelStorageProperties(.53F,0F,1F,15F,1F,1F,2F), new ModelStorageProperties(.5F,-1F,-.5F,135F,0F,1F,0F));
	}
	
	@Override
	public void registerRenderTickHandler(){
		MinecraftForge.EVENT_BUS.register(new BL2PlayerGUI());
	}
	
}
