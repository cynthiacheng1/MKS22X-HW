import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Quick{

	public static int part(int[] data, int start, int e){
		System.out.println("org " + Arrays.toString(data));
		int randomIndex = ThreadLocalRandom.current().nextInt(start, e);
		int prev = start;
		int now = start+1;
		int end = e;
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
		return prev;
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
		//System.out.println(java.util.Arrays.toString(a));
    }
}