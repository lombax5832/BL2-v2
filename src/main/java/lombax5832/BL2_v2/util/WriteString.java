package lombax5832.BL2_v2.util;

import net.minecraft.client.gui.FontRenderer;

import org.lwjgl.opengl.GL11;

public class WriteString {
	public static void shadowString(FontRenderer fr, String string, int h, int w, int color){
		GL11.glPushMatrix();
		GL11.glTranslatef(4, 4, 0);
//		fr.drawStringWithShadow(string, h, w, color);
		fr.drawString(string, h, w, color);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}
}
