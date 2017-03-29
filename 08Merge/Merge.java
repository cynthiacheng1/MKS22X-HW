import java.util.*;
public class Merge{

	public static void mergesort(int[] array){

		if (array.length <= 1){
			return;
		}
		int[] left = new int[array.length/2];
		for (int i =0; i < left.length; i++){
			left[i] = array[i];
		}
		int[] right = new int[array.length - (array.length/2)];
		for (int i = 0; i <right.length; i++){
			right[i] = array[i+array.length/2];
		}
		mergesort(left);
		mergesort(right);
		merge(left,right,array);
	}

	public static void merge(int[]a,int[]b,int[]destination){
		int aIndex = 0;
		int bIndex = 0;

		while (aIndex <a.length && bIndex<b.length){
			//System.out.println(aIndex);
			//System.out.println(bIndex);
			if (a[aIndex] >= b[bIndex]){
				destination[aIndex+bIndex] = b[bIndex];
				bIndex++;
			}
			else{
				//System.out.println(aIndex);
				//System.out.println(bIndex);
				destination[aIndex+bIndex] = a[aIndex];
				aIndex++;
				//System.out.println(aIndex);
				//System.out.println(bIndex);
			}
		}
		if (aIndex == a.length){
			while (bIndex < b.length){
				//System.out.println(aIndex);
				//System.out.println(bIndex);
				destination[aIndex+bIndex] = b[bIndex];
				bIndex++;
			}
		}
		else{
			while (aIndex < a.length){
				//System.out.println("WENT THRU");
				destination[aIndex+bIndex] = a[aIndex];
				aIndex++;
			}
		}

	}

	// public static void main(String[]a){
	// 	int[]y = {3,6,9,12,35};
	// 	int[]x = {0,2,3,5,6};
	// 	int[]z = new int[10];
	// 	merge(x,y,z);
	// 	System.out.println(Arrays.toString(z));
	// 	int[]b = {3,5,7,8,3,2,24,7658,24,1346,7865};
	// 	mergesort(b);
	// 	System.out.println(Arrays.toString(b));
	// }

	
}