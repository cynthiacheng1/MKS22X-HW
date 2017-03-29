import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Quick{

	public static int[] part(int[] data, int start, int e){
		System.out.println("org " + Arrays.toString(data));
		int randomIndex = ThreadLocalRandom.current().nextInt(start, e);
		int prev = start;
		int now = start+1;
		int end = e;
		int[] bounds = new int[2];
		int pivot = data[randomIndex];
		swap(data, start, randomIndex);
		System.out.println("pivot: " + pivot);
		while (now <= end){
			if (data[now] == pivot){
				now++;
			}
			else if (data[now] < pivot){
				swap(data, prev, now);
				prev++;
				now++;
			}
			else{
				swap(data, now, end);
				end--;
			}
		}
		System.out.println("updated " + Arrays.toString(data));
		bounds[0] = prev;
		bounds[1] = end;
		return bounds;
	}

	public static void swap(int[] data, int here, int there){
		int org = data[here];
		data[here] = data[there];
		data[there] = org;
	}

	public static int quickSelect(int[]data, int k){
		return quickSelectH(data,k,0,data.length-1);
	}

	public static int quickSelectH(int[]data, int k, int start, int end){
		int[] num = part(data,start,end);

		if (k>= num[0] && k <= num[1]){
			return data[k];
		}
		if (num[1] < k){
			return quickSelectH(data, k, num[1]+1, end);
		}
		return quickSelectH(data, k, start, num[0]-1);
	}

	public static void quicksort(int[] data){
		quicksortH(data,0,data.length-1);
	}

	public static void quicksortH(int[] data, int start, int end){
		if (start < end){
			int[] bounds = part(data,start,end);
			System.out.println("bounds " + Arrays.toString(bounds));
			quicksortH(data,start,bounds[0]-1);
			quicksortH(data,bounds[1]+1,end);
		}
	}

	public static void main(String[] args){
		int[] a = {2, 10, 15, 23, 0, 0, 5};
		//System.out.println(part(a,0,10));
		//part(a, 0, a.length-1);
		quicksort(a);
		System.out.println("final " + Arrays.toString(a));
		//System.out.println(java.util.Arrays.toString(a));
    }
}