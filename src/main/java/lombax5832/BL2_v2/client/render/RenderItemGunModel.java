package lombax5832.BL2_v2.client.render;

import lombax5832.BL2_v2.BL2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class RenderItemGunModel implements IItemRenderer{

	private Minecraft minecraft;
	
	private ResourceLocation textureCylinderResource = new ResourceLocation("bl2_v2:textures/models/pistol.png");
	private ResourceLocation modelCylinderResource = new ResourceLocation("bl2_v2:models/test.obj");
	private IModelCustom modelCylinder;
	
	public RenderItemGunModel() {
		this.minecraft = Minecraft.getMinecraft();
		modelCylinder = AdvancedModelLoader.loadModel(modelCylinderResource);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
			case ENTITY:{
				renderCylinder(minecraft,0,0F,1F,0F,0F,0F,0F);
				break;
			}
			case EQUIPPED:{
				renderCylinder(minecraft,110,-1,1,0,1F,1F,1F);
				break;
			}
			case EQUIPPED_FIRST_PERSON:{
				renderCylinder(minecraft,15F,1F,1F,2F,0.53F,0F,1F);
				break;
			}
			case INVENTORY:{
				renderCylinder(minecraft,135F,0F,1F,0F,0.5F,-1F,-0.5F);
				break;
			}
			default:
				break;
		}
	}
	
	public void renderCylinder(Minecraft minecraft,float angle, float xRot,float yRot, float zRot, float xPos, float yPos, float zPos){
		GL11.glPushMatrix();
		TextureManager render = minecraft.renderEngine;
		GL11.glTranslatef(xPos, yPos, zPos);
		GL11.glRotatef(angle, xRot, yRot, zRot);
		render.bindTexture(textureCylinderResource);
		modelCylinder.renderAll();
		GL11.glPopMatrix();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
			case INVENTORY:{
				return true;
			}
			case ENTITY:{
				return true;
			}
			case EQUIPPED_FIRST_PERSON:{
				return true;
			}
			case EQUIPPED:{
				return true;
			}
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		switch(type){
			case INVENTORY:{
				return true;
			}
			case ENTITY:{
				return true;
			}
			case EQUIPPED_FIRST_PERSON:{
				return true;
			}
			case EQUIPPED:{
				return true;
			}
			default:
				return false;		
		}
	}
}