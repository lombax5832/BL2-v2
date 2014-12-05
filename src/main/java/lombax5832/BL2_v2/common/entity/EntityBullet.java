package lombax5832.BL2_v2.common.entity;

import lombax5832.BL2_v2.BL2;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable{

	public EntityBullet(World world) {
		super(world);
	}
	
	public EntityBullet(World world, EntityLivingBase entityLivingBase){
		super(world,entityLivingBase);
	}
	
	public EntityBullet(World world, double posX, double posY, double posZ){
		super(world,posX,posY,posZ);
	}

	protected float getGravityVelocity(){
		return 0;
	}
	
	public void onUpdate(){
		super.onUpdate();

	}
	
	@Override
	protected void onImpact(MovingObjectPosition mop) {
		setDead();
		switch(mop.typeOfHit){
		case BLOCK: worldObj.setBlockToAir(mop.blockX,mop.blockY,mop.blockZ);
			break;
		case ENTITY: 
			break;
		default:
			break;
			
		}
		
	}

}
