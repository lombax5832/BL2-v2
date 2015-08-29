package lombax5832.BL2_v2.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends RenderEntity{
	
	ResourceLocation modelTexture = new ResourceLocation("");
	
	public RenderBullet()
    {
        super();
    }	
	
	@Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return modelTexture;
    }
}
