package lombax5832.BL2_v2.client.model;
/**
 * Allows models to store rotation and translation values
 * 
 * @author lombax5832
 */
public class ModelStorageProperties{
	public float xPos,yPos,zPos,angle,xRot,yRot,zRot,xScale,yScale,zScale;
	
	public ModelStorageProperties(float xPos, float yPos,
			float zPos, float angle, float xRot, float yRot, float zRot, float xScale, float yScale, float zScale){
		this.xPos = xPos;
		this.yPos = yPos;
		this.zPos = zPos;
		this.angle = angle;
		this.xRot = xRot;
		this.yRot = yRot;
		this.zRot = zRot;
		this.xScale = xScale;
		this.yScale = yScale;
		this.zScale = zScale;
	}
}