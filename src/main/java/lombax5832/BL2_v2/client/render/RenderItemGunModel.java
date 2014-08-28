package lombax5832.BL2_v2.client.render;

import lombax5832.BL2_v2.BL2;
import lombax5832.BL2_v2.client.model.ModelStorage;
import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.resource.TextureLocation;
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
	
	
	
	public RenderItemGunModel() {
		this.minecraft = Minecraft.getMinecraft();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		switch(type){
			case ENTITY:{
				renderCylinder(minecraft, stack, 0,0F,1F,0F,-0.5F,0F,.5F);
				renderRarityBeacon(minecraft, stack, 0,0F,0F,0F,0F,0F,0F);
				break;
			}
			case EQUIPPED:{
				renderCylinder(minecraft, stack, 110,-1,1,0,1F,1F,1F);
				break;
			}
			case EQUIPPED_FIRST_PERSON:{
				renderCylinder(minecraft, stack, 15F,1F,1F,2F,0.53F,0F,1F);
				break;
			}
			case INVENTORY:{
				renderCylinder(minecraft, stack, 135F,0F,1F,0F,0.5F,-1F,-0.5F);
				break;
			}
			default:
				break;
		}
	}
	
	public void renderCylinder(Minecraft minecraft, ItemStack stack, float angle, float xRot,float yRot, float zRot, float xPos, float yPos, float zPos){
		GunProperties atr = new GunProperties(stack);
		TextureManager render = minecraft.renderEngine;
		render.bindTexture(TextureLocation.getGunTextureResource(atr.camo));
		GL11.glPushMatrix();
		GL11.glTranslatef(xPos, yPos, zPos);
		GL11.glRotatef(angle, xRot, yRot, zRot);
		ModelStorage.getModel(0).renderAll();
		GL11.glPopMatrix();
	}
	
	public void renderRarityBeacon(Minecraft minecraft, ItemStack stack, float angle, float xRot,float yRot, float zRot, float xPos, float yPos, float zPos){
		GunProperties atr = new GunProperties(stack);
		if(atr.rarity>0){
			TextureManager render = minecraft.renderEngine;
			render.bindTexture(TextureLocation.getRarityTextureResource(atr.rarity-1));
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glColor4f(1F, 1F, 1F, 0.8F);
			GL11.glTranslatef(xPos, yPos, zPos);
			GL11.glRotatef(angle, xRot, yRot, zRot);
			GL11.glScalef(1.5F, 2F, 1.5F);
			ModelStorage.rarityBeaconModel.renderAll();
			GL11.glPopMatrix();
			GL11.glDisable(GL11.GL_BLEND);
		}
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
