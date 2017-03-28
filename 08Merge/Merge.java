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
		if (right.length ==1){}
		else{
			mergesort(right);
		}
		merge(left,right,array);
	}

	public static void merge(int[]a,int[]b,int[]destination){
		int aIndex = 0;
		int bIndex = 0;
		for (int i =0; i < destination.length; i++){
			if (a[aIndex] <= b[bIndex]){
				destination[i] = a[aIndex];
				aIndex++;
			}
			else{
				destination[i] = b[bIndex];
				bIndex++;
			}
		}
	}

	
}