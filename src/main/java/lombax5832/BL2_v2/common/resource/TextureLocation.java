package lombax5832.BL2_v2.common.resource;

import java.util.ArrayList;

import lombax5832.BL2_v2.lib.Unlocalized;

import net.minecraft.util.ResourceLocation;

/**
 * Class used to store the locations of textures
 * 
 * @author lombax5832
 */
public class TextureLocation {
	
	private static ArrayList textures = new ArrayList();
	
	private static ArrayList textureNames = new ArrayList();
	
	private final static ResourceLocation defaultTexture = new ResourceLocation("bl2_v2:textures/models/guntextures/default.png");
	
	public final static ResourceLocation rarityBeaconTexture = new ResourceLocation("bl2_v2:textures/models/RarityBeacon.png");
	
	private final static String defaultTextureName = "Default Gun";
	
	/**
	 * @param path The gun texture path to be added
	 */
	public static void addResource(String path){
		textures.add(new ResourceLocation("bl2_v2:textures/models/guntextures/"+path+".png"));
		textureNames.add(Unlocalized.TEXTURE_PREFIX+path);
	}
	
	/**
	 * @param index The index to be returned
	 * @return Returns the ResourceLocation
	 */
	public static ResourceLocation getResource(int index){
		if(textures.size()>index&&textures.get(index)!=null&&textures.get(index) instanceof ResourceLocation)
			return (ResourceLocation) textures.get(index);
		return defaultTexture;
	}
	
	public static String getResourceName(int index){
		if(textureNames.size()>index&&textureNames.get(index)!=null&&textureNames.get(index) instanceof String)
			return (String) textureNames.get(index);
		return defaultTextureName;
	}
	
	/**
	 * @return Returns the number of items in the index beginning with 0
	 */
	public static int getLastIndex(){
		return textures.size()-1;
	}
}
