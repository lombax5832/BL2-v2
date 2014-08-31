package lombax5832.BL2_v2.common.resource;

import java.util.ArrayList;

import lombax5832.BL2_v2.client.model.ModelStorage;

import net.minecraft.util.ResourceLocation;

/**
 * Class used to store the locations of models
 * 
 * @author lombax5832
 */
public class ModelLocation {
	
	private static ArrayList gunModels = new ArrayList();
	
	private static ResourceLocation defaultModel = new ResourceLocation("bl2_v2:models/gunmodels/pistol.obj");
	
	public static ResourceLocation rarityBeaconModel = new ResourceLocation("bl2_v2:models/RarityBeacon.obj");
	
	public static ResourceLocation rarityBorderModel = new ResourceLocation("bl2_v2:models/GunInventoryBorder.obj");
	
	public static void addGunModelResource(String path){
		ResourceLocation toAdd = new ResourceLocation("bl2_v2:models/gunmodels/"+path);
		gunModels.add(toAdd);
		ModelStorage.addModel(toAdd);
	}
	
	public static ResourceLocation getGunModelResource(int index){
		if(gunModels.size()>index&&gunModels.get(index)!=null&&gunModels.get(index) instanceof ResourceLocation)
			return (ResourceLocation) gunModels.get(index);
		return defaultModel;
	}
}
