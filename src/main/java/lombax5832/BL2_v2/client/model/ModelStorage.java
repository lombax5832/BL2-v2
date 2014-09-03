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
	
	public static ArrayList modelPropertiesEntityList = new ArrayList();
	public static ArrayList modelPropertiesEquippedList = new ArrayList();
	public static ArrayList modelPropertiesEquippedFPList = new ArrayList();
	public static ArrayList modelPropertiesInventoryList = new ArrayList();
	
	public static void addModel(ResourceLocation location, ModelStorageProperties modelPropertiesEntity, ModelStorageProperties modelPropertiesEquipped, ModelStorageProperties modelPropertiesEquippedFP, ModelStorageProperties modelPropertiesInventory){
		models.add(AdvancedModelLoader.loadModel(location));
		modelPropertiesEntityList.add(modelPropertiesEntity);
		modelPropertiesEquippedList.add(modelPropertiesEquipped);
		modelPropertiesEquippedFPList.add(modelPropertiesEquippedFP);
		modelPropertiesInventoryList.add(modelPropertiesInventory);
	}
	
	public static IModelCustom getModel(int index){
		if(models.size()>index&&models.get(index)!=null&&models.get(index) instanceof IModelCustom)
			return (IModelCustom) models.get(index);
		return null;
	}
	
	/**
	 * Allows models to store rotation and translation values
	 * 
	 * @author lombax5832
	 */
	public static class ModelStorageProperties{
		public static float xPos,yPos,zPos,angle,xRot,yRot,zRot;
		
		public ModelStorageProperties(float xPos, float yPos,
				float zPos, float angle, float xRot, float yRot, float zRot){
			this.xPos = xPos;
			this.yPos = yPos;
			this.zPos = xPos;
			this.angle = angle;
			this.xRot = xRot;
			this.yRot = yRot;
			this.zRot = zRot;
		}
	}
	
}
