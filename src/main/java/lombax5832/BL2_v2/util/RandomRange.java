package lombax5832.BL2_v2.util;

public class RandomRange {
	public static int randomRange(int min, int max){
		return (min + (int)(Math.random() * ((max - min) + 1)));
	}
	public static double randomRange(double min, double max){
		return (min + (Math.random() * ((max - min) + 1)));
	}
	public static boolean randomBoolean(int chance){
		float g = (float) Math.random() * 100;
			if(g<chance)
				return true;
		return false;
	}
}
