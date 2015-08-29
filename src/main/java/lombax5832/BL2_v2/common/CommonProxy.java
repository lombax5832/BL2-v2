package lombax5832.BL2_v2.common;

import lombax5832.BL2_v2.BL2;
import lombax5832.BL2_v2.common.entity.EntityBullet;
import lombax5832.BL2_v2.common.resource.TextureLocation;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Proxy class to do certain things on the server side
 * 
 * @author lombax5832
 */
public class CommonProxy {

	public boolean isClient() {
		return false;
	}

	public void registerItemRenderer() {}

	public void registerEntities(){
		EntityRegistry.registerModEntity(EntityBullet.class, "BL2EntityBullet", 0, BL2.instance, 80, 1, true);
	}
	
	public void addTextures(){
		TextureLocation.addGunTextureResource("winter");
		TextureLocation.addGunTextureResource("forest");
		TextureLocation.addGunTextureResource("desert");
		TextureLocation.addGunTextureResource("blueTiger");
		TextureLocation.addGunTextureResource("gold");
		TextureLocation.addGunTextureResource("rust");
		TextureLocation.addGunTextureResource("redTiger");
		
		TextureLocation.addRarityTextureResource("uncommon");
		TextureLocation.addRarityTextureResource("rare");
		TextureLocation.addRarityTextureResource("epic");
		TextureLocation.addRarityTextureResource("legendary");
	}

	public void addModels(){}

	public void registerRenderTickHandler() {}

	public void addKeyBindings() {}

	public void registerEntityRenderer() {}
	
}
