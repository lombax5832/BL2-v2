package lombax5832.BL2_v2.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import lombax5832.BL2_v2.client.render.RenderItemGunModel;
import lombax5832.BL2_v2.client.resource.ModelLocation;
import lombax5832.BL2_v2.client.resource.TextureLocation;
import lombax5832.BL2_v2.common.CommonProxy;
import lombax5832.BL2_v2.common.item.ModItems;

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
		ModelLocation.addResource("pistol.obj");
	}
	
}
