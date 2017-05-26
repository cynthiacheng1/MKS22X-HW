import java.util.*;

public class MyPriorityQueue{
    private ArrayList<Location> queue;
    private int order;
    private int size;
    
    public MyPriorityQueue(){
		queue = new ArrayList<Location>();
		size = 0;
    }

    private void swap(int a, int b){
		Location temp = queue.get(b);
		queue.set(b, queue.get(a));
		queue.set(a, temp);
    }

    public void add(Location loc){
		queue.add(loc);
		size++;
		pushUp();
		pushDown();
    }


    public int size(){
		return size;
    }

    public Location remove(){
    	Location last = queue.get(size-1);
		Location old = queue.set(1, last);
		size--;
		pushDown();
		pushUp();
		return old;
    }

    public Location peek(){
		return queue.get(1);
    }

    private void pushUp(){
	int current = size;
		while(current > 1 && order * queue.get(current/2).compareTo(queue.get(current)) > 0){
		    swap(current, current/2);
		    current = current/2;
		}
    }

    private void pushDown(){
		int current = 1;
		if(size == 2 && queue.get(1).compareTo(queue.get(2)) * order < 0){
		    swap(1, 2);
		    return;
		}
		while(current * 2 + 1 <= size){
		    if(queue.get(current*2).compareTo(queue.get(current*2+1))*order > 0){
				if(queue.get(current).compareTo(queue.get(current*2))*order < 0){
				    swap(current, current*2);
				    current = current * 2;
				}else if(queue.get(current).compareTo(queue.get(current*2+1)) * order < 0){
				    swap(current, current*2+1);
				    current = current*2+1;
				}else{
				    return;
				}
			}
			else{
				if(queue.get(current).compareTo(queue.get(current*2+1)) * order < 0){
				    swap(current, current*2+1);
				    current = current*2+1;
				}else if(queue.get(current).compareTo(queue.get(current*2)) * order < 0){
				    swap(current, current*2);
				    current = current * 2;
				}else{
				    return;
				}
		    }
		}
    }


}