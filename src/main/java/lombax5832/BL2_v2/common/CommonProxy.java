package lombax5832.BL2_v2.common;

import lombax5832.BL2_v2.client.model.ModelStorageProperties;
import lombax5832.BL2_v2.common.resource.ModelLocation;
import lombax5832.BL2_v2.common.resource.TextureLocation;

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
	
}
