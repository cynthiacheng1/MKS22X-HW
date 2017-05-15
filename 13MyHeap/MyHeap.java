import java.util.*;

public class MyHeap{
	String[] heap;
	int minOrMax;
	int size;
	
	public MyHeap(){
	}

	public MyHeap(boolean containin){
		if (containin){
			minOrMax = -1;
		}
		else{
			minOrMax = 1;
		}
		heap = new String[10];
		size =0;
	}

	public void add(String s){
		if (size == heap.length-1){
			resize();
		}
		heap[size +1] = s;
		pushUp(size+1);
		size++;
	}

	private void pushUp(int index){
		while (index >= 2){
			int parent = index/2;
			if (minOrMax* heap[parent].compareTo(heap[index]) > 0){
				String temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
			}
			index --;
		}
	}

	public String remove(){ //removes top node
		String top = heap[1];
		heap[1] = heap[size];
		heap[size] = null;
		pushDown();
		size--;
		return top;
	}
	private void pushDown(){
		int index = 1;
		while (index < size && heap[index * 2] != null && heap[index * 2 + 1] != null) {
	    	if (minOrMax * heap[index].compareTo(heap[index * 2]) > 0) {
				String temp = heap[index];
				heap[index] = heap[index * 2];
				heap[index * 2] = temp;
	    	}
	    	if (minOrMax * heap[index].compareTo(heap[index * 2 + 1]) > 0) {
				String temp = heap[index];
				heap[index] = heap[index * 2+1];
				heap[index * 2+1] = temp;
	    	}
	    index++;
		}
	}

	public String peek() {
		return heap[1];
    }

    public void resize() {
        String[] newHeap = new String[size * 2];
		for (int i = 0; i < heap.length; i++) {
	    	newHeap[i] = heap[i];
		}
		heap = newHeap;
    }


}