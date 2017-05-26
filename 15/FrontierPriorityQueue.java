import java.util.*;

public class FrontierPriorityQueue implements Frontier{

	public MyPriorityQueue locations = new MyPriorityQueue();

	public void add(Location x){
		locations.add(x);
	}

	public Location next(){
		return locations.remove();
	}

	public boolean hasNext(){
		return locations.size() != 0;
	}

}