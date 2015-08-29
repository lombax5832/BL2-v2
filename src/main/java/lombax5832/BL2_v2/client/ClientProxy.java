package lombax5832.BL2_v2.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import lombax5832.BL2_v2.client.model.ModelStorageProperties;
import lombax5832.BL2_v2.client.render.RenderBullet;
import lombax5832.BL2_v2.client.render.RenderItemGunModel;
import lombax5832.BL2_v2.client.settings.KeyBindingBL2;
import lombax5832.BL2_v2.common.CommonProxy;
import lombax5832.BL2_v2.common.entity.EntityBullet;
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
	public void registerEntityRenderer(){
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}
	
	@Override
	public void addModels(){
		ModelLocation.addGunModelResource("pistol",	new ModelStorageProperties(-0.5F,0F,0.5F, 0F, 0F, 1F, 0F, 1F, 1F, 1F), 
				new ModelStorageProperties(1F,1F,1F,110F,-1F,1F,0F, 1F, 1F, 1F), 
				new ModelStorageProperties(.53F,0F,1F,15F,1F,1F,2F, 1F, 1F, 1F), 
				new ModelStorageProperties(.5F,-1F,-.5F,135F,0F,1F,0F, 1F, 1F, 1F));
		
		ModelLocation.addGunModelResource("assaultRifle",	new ModelStorageProperties(-1F,0F,1F, 0F, 0F, 1F, 0F, .75F, .75F, .75F), 
				new ModelStorageProperties(1F,1F,1F,110F,-1F,1F,0F, 1F, 1F, 1F), 
				new ModelStorageProperties(.53F,0F,1.5F,15F,2F,1F,3F, 1F, 1F, 1F), 
				new ModelStorageProperties(.9F,-1F,-.5F,135F,0F,1F,0F, 0.65F, 1F, 1F));
	}
	
	@Override
	public void addKeyBindings(){
		KeyBindingBL2.init();
	}
	
	@Override
	public void registerRenderTickHandler(){
		MinecraftForge.EVENT_BUS.register(new BL2PlayerGUI());
	}
	
}
