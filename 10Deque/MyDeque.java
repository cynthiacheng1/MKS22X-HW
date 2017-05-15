import java.util.NoSuchElementException;
 
public class MyDeque{
	String[] deque;
	int front, back, size;

	public MyDeque(){
		deque = new String[10];
		front = 5;
		back = 4;
		size = 0;
	}

	public void resize(){
		String[] newDeque = new String[deque.length*2];
		for (int i =0; i < deque.length; i++){
			newDeque[i] = deque[front%(deque.length)];
			front++;
		}
		front = 0;
		back = deque.length-1;
		deque = newDeque;
	}

	public void addFirst(String e){
		if (e.equals(null)){
			throw new NullPointerException();
		}
		if (size == deque.length){
			resize();
		}
		if (front == 0){
			front = deque.length -1;
		}
		else{
			front--;
		}
		deque[front] = e;
		size++;
	}
	public void addLast(String e){
		if (e.equals(null)){
			throw new NullPointerException(); 
		}
		if (size == deque.length){
			resize();
		}
		if (back == deque.length){
			back = 0;
		}
		else{
			back++;
		}
		deque[back] = e;
		size++;
	}

	public String removeFirst(){
		int orgFirstIndex;
		if (size ==0){
			throw new NoSuchElementException();
		}
		if (front == deque.length-1){
			front = 0;
			orgFirstIndex = deque.length-1;
		}
		else{
			front++;
			orgFirstIndex = front-1;
		}
		size--;
		return deque[orgFirstIndex];
	}
	public String removeLast(){
		int orgLastIndex;
		if (size ==0){
			throw new NoSuchElementException();
		}
		if (back == 0){
			back = deque.length-1;
			orgLastIndex = 0;
		}
		else{
			back--;
			orgLastIndex = back+1;
		}
		size--;
		return deque[orgLastIndex];
	}

	public String getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return deque[front];
    }

    public String getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return deque[back];
    }


}
