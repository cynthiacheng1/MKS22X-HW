public class RunningMedian{
	public MyHeap max;
	public MyHeap min;

	public RunningMedian(){
		min = new MyHeap(false);
		max = new MyHeap(true);
	}

	public void add (int num){
		if (max.size() == 0 && min.size() ==0){
			min.add(num);
		}
		else if (num < getMedian()){
			min.add(num);
		}
		else{
			max.add(num);
		}
		if ((Math.abs(min.size() - max.size()) >= 2)){
			if (min.size() > max.size()){
				max.add(min.remove());
			}
			else{
				min.add(max.remove());
			}
		}
	}

	public double getMedian(){
		if (min.size() == max.size()){
			return (min.peek() + max.peek())/ 2.0;
		}
		else if (min.size() > max.size()){
			return min.peek();
		}
		else{
			return max.peek();
		}
	}
}