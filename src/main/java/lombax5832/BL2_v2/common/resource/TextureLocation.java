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
	
	private static ArrayList gunTextures = new ArrayList();	
	private static ArrayList gunTextureNames = new ArrayList();
	
	private static ArrayList rarityTextures = new ArrayList();
	private static ArrayList rarityTextureNames = new ArrayList();
	
	private final static ResourceLocation defaultTexture = new ResourceLocation("bl2_v2:textures/models/guntextures/default.png");
	
	public final static ResourceLocation rarityBeaconTexture = new ResourceLocation("bl2_v2:textures/models/RarityBeacon.png");
	
	private final static String defaultTextureName = "Default Gun";
	
	/**
	 * @param path The gun texture path to be added
	 */
	public static void addGunTextureResource(String path){
		gunTextures.add(new ResourceLocation("bl2_v2:textures/models/guntextures/"+path+".png"));
		gunTextureNames.add(Unlocalized.TEXTURE_PREFIX+path);
	}
	
	/**
	 * @param path The gun texture path to be added
	 */
	public static void addRarityTextureResource(String path){
		rarityTextures.add(new ResourceLocation("bl2_v2:textures/models/raritytextures/"+path+".png"));
		rarityTextureNames.add(Unlocalized.TEXTURE_PREFIX+path);
	}
	
	/**
	 * @param index The index to be returned
	 * @return Returns the ResourceLocation
	 */
	public static ResourceLocation getGunTextureResource(int index){
		if(gunTextures.size()>index&&gunTextures.get(index)!=null&&gunTextures.get(index) instanceof ResourceLocation)
			return (ResourceLocation) gunTextures.get(index);
		return defaultTexture;
	}
	
	/**
	 * @param index The index to be returned
	 * @return Returns the ResourceLocation
	 */
	public static ResourceLocation getRarityTextureResource(int index){
		if(rarityTextures.size()>index&&rarityTextures.get(index)!=null&&rarityTextures.get(index) instanceof ResourceLocation)
			return (ResourceLocation) rarityTextures.get(index);
		return defaultTexture;
	}
	
	/**
	 * @param index The index to be returned
	 * @return Returns the name corresponding with the ResourceLocation
	 */
	public static String getGunTextureResourceName(int index){
		if(gunTextureNames.size()>index&&gunTextureNames.get(index)!=null&&gunTextureNames.get(index) instanceof String)
			return (String) gunTextureNames.get(index);
		return defaultTextureName;
	}
	
	/**
	 * @param index The index to be returned
	 * @return Returns the name corresponding with the ResourceLocation
	 */
	public static String getRarityTextureResourceName(int index){
		if(rarityTextureNames.size()>index&&rarityTextureNames.get(index)!=null&&rarityTextureNames.get(index) instanceof String)
			return (String) rarityTextureNames.get(index);
		return defaultTextureName;
	}
	
	/**
	 * @return Returns the number of items in the index beginning with 0
	 */
	public static int getLastGunTextureIndex(){
		return gunTextures.size()-1;
	}
	
	/**
	 * @return Returns the number of items in the index beginning with 0
	 */
	public static int getLastRarityTextureIndex(){
		return rarityTextures.size()-1;
	}
}
