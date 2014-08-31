package lombax5832.BL2_v2.util;

import java.util.List;

public class ItemGunInfoComparisonLogic {
	public static int compareValues(int item1, int item2){
		if(item1>item2)
			return 0;
		else if(item1<item2)
			return 1;
		else
			return 2;
	}
}
