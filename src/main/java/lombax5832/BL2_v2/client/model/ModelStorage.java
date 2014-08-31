package lombax5832.BL2_v2.client.model;

import java.util.ArrayList;

import lombax5832.BL2_v2.common.resource.ModelLocation;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Class used to store models
 * 
 * @author lombax5832
 */
public class ModelStorage {
	
	public static IModelCustom rarityBeaconModel = AdvancedModelLoader.loadModel(ModelLocation.rarityBeaconModel);
	
	public static IModelCustom rarityBorderModel = AdvancedModelLoader.loadModel(ModelLocation.rarityBorderModel);
	
	static ArrayList models = new ArrayList();
	
	public static void addModel(ResourceLocation location){
		models.add(AdvancedModelLoader.loadModel(location));
	}
	
	public static IModelCustom getModel(int index){
		if(models.size()>index&&models.get(index)!=null&&models.get(index) instanceof IModelCustom)
			return (IModelCustom) models.get(index);
		return null;
	}
	
}
