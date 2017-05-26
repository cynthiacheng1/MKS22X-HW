import java.util.*;

public class FrontierStack implements Frontier{
    private Stack<Location> front;
    private int size;

    public FrontierStack(){
	   front = new Stack<Location>();
    }

    public void add(Location loc){
    	front.push(loc);
    	size++;
    }

    public Location next(){
    	size--;
    	return front.pop();
    }

    public int size(){
	   return size;
    }

    public boolean hasNext(){
	   return size > 0;
    }
}