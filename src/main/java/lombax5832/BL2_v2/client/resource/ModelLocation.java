package lombax5832.BL2_v2.client.resource;

import java.util.ArrayList;

import lombax5832.BL2_v2.client.model.ModelStorage;

import net.minecraft.util.ResourceLocation;

/**
 * Class used to store the locations of models
 * 
 * @author lombax5832
 */
public class ModelLocation {
	
	static ArrayList models = new ArrayList();
	
	static ResourceLocation defaultModel = new ResourceLocation("bl2_v2:models/gunmodels/pistol.obj");
	
	public static void addResource(String path){
		ResourceLocation toAdd = new ResourceLocation("bl2_v2:models/gunmodels/"+path);
		models.add(toAdd);
		ModelStorage.addModel(toAdd);
	}
	
	public static ResourceLocation getResource(int index){
		if(models.size()>index&&models.get(index)!=null&&models.get(index) instanceof ResourceLocation)
			return (ResourceLocation) models.get(index);
		return defaultModel;
	}
}
