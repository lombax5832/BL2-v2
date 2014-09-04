package lombax5832.BL2_v2.common.resource;

import java.util.ArrayList;

import lombax5832.BL2_v2.client.model.ModelStorage;
import lombax5832.BL2_v2.client.model.ModelStorageProperties;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.lib.Unlocalized;
import net.minecraft.util.ResourceLocation;

/**
 * Class used to store the locations and names of models
 * 
 * @author lombax5832
 */
public class ModelLocation {
	
	private static ArrayList gunModels = new ArrayList();
	private static ArrayList gunModelsNames = new ArrayList();
	
	private static ResourceLocation defaultModel = new ResourceLocation("bl2_v2:models/gunmodels/pistol.obj");
	
	public static ResourceLocation rarityBeaconModel = new ResourceLocation("bl2_v2:models/RarityBeacon.obj");
	
	public static ResourceLocation rarityBorderModel = new ResourceLocation("bl2_v2:models/GunInventoryBorder.obj");
	
	public static void addGunModelResource(String path, ModelStorageProperties modelEntity, ModelStorageProperties modelEquipped, ModelStorageProperties modelEquippedFP, ModelStorageProperties modelInventory){
		ResourceLocation toAdd = new ResourceLocation("bl2_v2:models/gunmodels/"+path+".obj");
		gunModels.add(toAdd);
		gunModelsNames.add(Unlocalized.MODEL_PREFIX+path);
		ModelStorage.addModel(toAdd,modelEntity,modelEquipped,modelEquippedFP,modelInventory);
	}
	
	public static ResourceLocation getGunModelResource(int index){
		if(gunModels.size()>index&&gunModels.get(index)!=null&&gunModels.get(index) instanceof ResourceLocation)
			return (ResourceLocation) gunModels.get(index);
		return defaultModel;
	}
	
	public static String getGunModelName(int index){
		if(gunModelsNames.size()>index&&gunModelsNames.get(index)!=null&&gunModelsNames.get(index) instanceof String){
			return (String) gunModelsNames.get(index);
		}
		return ModItems.itemGun.getUnlocalizedName();
	}
}
