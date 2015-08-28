package lombax5832.BL2_v2.client;

import java.util.ArrayList;
import java.util.List;

import lombax5832.BL2_v2.common.item.ItemGun.GunProperties;
import lombax5832.BL2_v2.common.item.ModItems;
import lombax5832.BL2_v2.util.ItemGunInfoComparisonLogic;
import lombax5832.BL2_v2.util.ItemGunInfoUtilsForRender;
import lombax5832.BL2_v2.util.WriteString;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BL2PlayerGUI extends Gui{
	
	private Minecraft mc;
	
	private final static ResourceLocation gunPropertiesTopTexture = new ResourceLocation("bl2_v2:textures/gui/gunPropertiesTop.png");
	private final static ResourceLocation gunPropertiesCenterTexture = new ResourceLocation("bl2_v2:textures/gui/gunPropertiesCenter.png");
	private final static ResourceLocation gunPropertiesBottomTexture = new ResourceLocation("bl2_v2:textures/gui/gunPropertiesBottom.png");
	
	private final static ResourceLocation gunPropertiesAmmoBorderTexture = new ResourceLocation("bl2_v2:textures/gui/gunPropertiesAmmoBorder.png");
	private final static ResourceLocation gunPropertiesAmmoFillingTexture = new ResourceLocation("bl2_v2:textures/gui/gunPropertiesAmmoFilling.png");
	
	private final static ResourceLocation[] gunPropertiesArrows = {new ResourceLocation("bl2_v2:textures/gui/arrowRedDown.png"),new ResourceLocation("bl2_v2:textures/gui/arrowGreenUp.png"), new ResourceLocation("bl2_v2:textures/gui/arrowEqualSign.png")};

	private FontRenderer fr;
	
	private ScaledResolution res;
	
	private int height,width;
	
	private Entity pointedEntity;

	private static ArrayList info = new ArrayList();
	
	public BL2PlayerGUI(){
		this.mc = Minecraft.getMinecraft();
	}
	
	@SubscribeEvent()
	public void  onRenderExperienceBar(RenderGameOverlayEvent event){
		this.fr = mc.fontRenderer;
		this.res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		this.height = res.getScaledHeight();
		this.width	= res.getScaledWidth();
		
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
			return;
		
		EntityPlayer player = mc.thePlayer;
		
		ItemStack itemGun = getMouseOver(player);
		if (itemGun!=null){
			renderLookAtBox(itemGun, 10, (height/3)-20);
			renderLookAtGunInfo(itemGun, 10, (height/3)-14);
			
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ModItems.itemGun){
				ItemStack stackInHand = player.getHeldItem();
				renderLookAtGunComparisonInfo(itemGun, stackInHand, 10, (height/3)-14);
			}
		}
		
		if(player.getHeldItem() != null && player.getHeldItem().getItem() == ModItems.itemGun){
			GunProperties atr = new GunProperties(player.getHeldItem());
			renderGunAmmo(width/2+16,height-60,atr.maxAmmo,atr.currentAmmo,atr.reloadTotal,atr.reloadTicker,atr.reloading);
		}
	}
	
	public void renderLookAtGunInfo(ItemStack stack, int oX, int oY){
		info.clear();
		GunProperties atr = new GunProperties(stack);
		ItemGunInfoUtilsForRender.addGunInfo(info, atr, stack);
		for(int i=0;i<info.size();i++){
			WriteString.shadowString(fr, (String) info.get(i), oX+8, oY+(9*i), 0xFFFFFF);
		}
	}
	
	public void renderLookAtGunComparisonInfo(ItemStack stackOnGround, ItemStack stackInHand, int oX, int oY){
		GunProperties atrGround = new GunProperties(stackOnGround);
		GunProperties atrHand = new GunProperties(stackInHand);
		
		renderArrow(oX+5,oY+14,ItemGunInfoComparisonLogic.compareValues(atrHand.maxAmmo, atrGround.maxAmmo));
		
		if(!atrHand.isSemiAuto&&!atrGround.isSemiAuto)
			renderArrow(oX+5,oY+23,ItemGunInfoComparisonLogic.compareValues(20-atrHand.fireRate, 20-atrGround.fireRate));
		
		renderArrow(oX+5,oY+32,ItemGunInfoComparisonLogic.compareValues(atrGround.reloadTotal, atrHand.reloadTotal));
	}
	
	public void renderLookAtBox(ItemStack stack, int oX, int oY){
		float width = (getLongestListLength()+15)/66F;
		float height = (info.size()*9)/9;
		
		renderLookAtGunTop((int) (oX),(int) (oY), width);
		renderLookAtGunCenter((int) (oX),(int) (oY+9), width, height);
		renderLookAtGunBottom((int) (oX),(int) (oY+9+(info.size()*9)), width);
	}
	
	public void renderArrow(int xPos, int yPos, int type){
		if(type==0||type==1||type==2){
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			
			GL11.glPushMatrix();
			GL11.glTranslatef(xPos, yPos, 0);
			GL11.glShadeModel(GL11.GL_SMOOTH);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glScalef(1F/5, 1F/5, 1F);
			this.mc.getTextureManager().bindTexture(gunPropertiesArrows[type]);
			this.drawTexturedModalRect(0, 0, 0, 0, 20, 25);
			
			GL11.glShadeModel(GL11.GL_FLAT);
			GL11.glPopMatrix();
		}
	}
	
	public void renderLookAtGunTop(int xPos, int yPos, float scaleWidth){
		float scale = 1.7F;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(xPos, yPos, 0);
		GL11.glScalef(scaleWidth, 1.0F, 1.0F);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.mc.getTextureManager().bindTexture(gunPropertiesTopTexture);
		this.drawTexturedModalRect(0, 0, 0, 0, 66, 9);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glPopMatrix();
	}
	
	public void renderLookAtGunCenter(int xPos, int yPos, float scaleWidth, float ScaleHeight){
		float scale = 1.7F;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(xPos, yPos, 0);
		GL11.glScalef(scaleWidth, ScaleHeight, 1.0F);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.mc.getTextureManager().bindTexture(gunPropertiesCenterTexture);
		this.drawTexturedModalRect(0, 0, 0, 0, 66, 9);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glPopMatrix();
	}

	public void renderLookAtGunBottom(int xPos, int yPos, float scaleWidth){
		float scale = 1.7F;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(xPos, yPos, 0);
		GL11.glScalef(scaleWidth, 1.0F, 1.0F);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.mc.getTextureManager().bindTexture(gunPropertiesBottomTexture);
		this.drawTexturedModalRect(0, 0, 0, 0, 66, 9);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glPopMatrix();
	}
	
	public void renderGunAmmo(int xPos, int yPos, int maxAmmo, int currentAmmo, int reloadMax, int reloadTicker, boolean reloading){
		
		String ammoString = "";
		int ammoBarVal = 0;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(xPos, yPos, 0);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
		this.mc.getTextureManager().bindTexture(gunPropertiesAmmoFillingTexture);
		
		
		if(!reloading){
			ammoBarVal = (int) ((float)((float)currentAmmo/(float)maxAmmo)*66F);
			ammoString = currentAmmo+"/"+maxAmmo;
		}else{
			ammoBarVal = (int) ((float)((float)reloadTicker/(float)reloadMax)*66F);
			ammoString = (float)Math.round((((float)(reloadMax-reloadTicker)/(float)reloadMax)*reloadMax/20) * 10) / 10+" secs";
		}
		
		this.drawTexturedModalRect(0, 0, 0, 0, ammoBarVal, 18);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(gunPropertiesAmmoBorderTexture);
		this.drawTexturedModalRect(0, 0, 0, 0, 66, 18);
		
		GL11.glTranslatef(-xPos, -yPos, 0);
		WriteString.shadowString(fr, ammoString, width/2 - fr.getStringWidth(ammoString)/2 + 45, yPos+1, 0xFFFFFF);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glPopMatrix();
	}
	
	public int getLongestListLength(){
		
		int longestInfoLength = 0;
		
		for(int i=0;i<info.size();i++){
			if(fr.getStringWidth(info.get(i).toString())>longestInfoLength){
				longestInfoLength = fr.getStringWidth(info.get(i).toString());
			}
		}
		
		return longestInfoLength;
	}
	
	public ItemStack getMouseOver(EntityPlayer player)
    {
		Entity entity = null;
		MovingObjectPosition mop = player.rayTrace(4, 1.0F);
		if(mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK){
			Double range = 1.0D;
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(mop.blockX - range, mop.blockY - range, mop.blockZ - range, mop.blockX + range, mop.blockY + 0.5D + range, mop.blockZ + range);
			List entityItems = mc.theWorld.getEntitiesWithinAABB(EntityItem.class, aabb);
			for(int i=0;i<entityItems.size();i++){
				System.out.println("working");
				if(entityItems.get(i)!=null){
					EntityItem item = (EntityItem) entityItems.get(i);
					if(item.getEntityItem().getItem()==ModItems.itemGun){
						return item.getEntityItem();
					}
				}
			}
		}
		return null;
    }
}