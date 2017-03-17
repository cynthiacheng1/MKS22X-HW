import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Quick{
	
	public static int part(int[] data, int start, int end){
		int randomIndex = ThreadLocalRandom.current().nextInt(start, end);
		int pivot = data[randomIndex];
		data[randomIndex] = data[start];
		data[start] = pivot;
		System.out.println("pivot: " + pivot);
		int now = start+1;
		int prev = start;
		System.out.println("now: " + now + " prev: " + prev);
		for (int i =start+1; i <= end; i++){
			if (data[i] < pivot){
				System.out.println("tru");
				int num = data[now];
				data[now] = data[i];
				data[i] = num;
				prev = now++;
			}
			System.out.println(Arrays.toString(data));
		}
		data[start] = data[prev];
		data[prev] = pivot;
		return prev;
	}

	public static int quickSelect(int[]data, int k){
		return quickSelectH(data,k,0,data.length-1);
	}

	public static int quickSelectH(int[]data, int k, int start, int end){
		int num = part(data,start,end);
		start = start;
		end = end;
		if (num < k){
			start = num;
			quickSelectH(data, k, start, end);
		}
		else if (num >k) {
			end = num;
			quickSelectH(data, k, start, end);
		}
		return 0;
	}

	public static void main(String[] args){
		Quick q = new Quick();
		int[] a = {2, 10, 15, 23, 0,  5};
		//System.out.println(part(a,0,10));
		System.out.println(part(a, 0, a.length-1));
		System.out.println(java.util.Arrays.toString(a));
    }
}