package lombax5832.BL2_v2.common;

import lombax5832.BL2_v2.client.resource.TextureLocation;

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
		TextureLocation.addResource("winter");
		TextureLocation.addResource("forest");
		TextureLocation.addResource("desert");
		TextureLocation.addResource("blueTiger");
		TextureLocation.addResource("gold");
		TextureLocation.addResource("rust");
	}

	public void addModels() {}
	
}
