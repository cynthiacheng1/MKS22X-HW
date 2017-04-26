public class MyDeque{
	int front=0;
	int back=0;
	String[] deque = new String[10];

	public void addFirst(String element){
		//if element is null then throw new Nullpointer excpetion
		if (back+1 == front || (front == 0 && back == deque.length)){
			resize();
		}
		if (front ==0){
			front = deque.length;
		}
		front--;
		deque[front] = element;
	}

	public void addLast(String element){
		if (back+1 == front || (front == 0 && back == deque.length)){
			resize();
		}
		if (back == deque.length){
			back = -1;
		}
		back++;
		deque[back] = element;
	}

	public String printDeque(){
		String ans ="[";
		for (int i=0; i < deque.length; i++){
			ans += deque[i] +",";
		}
		return ans.substring(0,ans.length) +"]";
	}

	public void resize(){
		String[] newDeque = new String[deque.length*2];
		for (int i =0; i < deque.length; i++){
			newDeque[i] = deque[front%(deque.length)];
			front++;
		}
		front = 0
		back = deque.length-1;
		deque = newDeque;
	}
}