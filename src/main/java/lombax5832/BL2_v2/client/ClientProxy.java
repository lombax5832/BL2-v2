package lombax5832.BL2_v2.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import lombax5832.BL2_v2.client.model.ModelStorage.ModelStorageProperties;
import lombax5832.BL2_v2.client.render.RenderItemGunModel;
import lombax5832.BL2_v2.common.CommonProxy;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.common.resource.ModelLocation;
import lombax5832.BL2_v2.common.resource.TextureLocation;

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
		ModelLocation.addGunModelResource("pistol.obj", 
				new ModelStorageProperties(-0.5F,0F,-.5F, 0, 0, 1F, 0), 
				new ModelStorageProperties(1F,1F,1F,110,-1,1,0), 
				new ModelStorageProperties(.53F,0,1F,15,1,1,2), 
				new ModelStorageProperties(.5F,-1,-.5F,135,0,1,0));
	}
	
	@Override
	public void registerRenderTickHandler(){
		MinecraftForge.EVENT_BUS.register(new BL2PlayerGUI());
	}
	
}
