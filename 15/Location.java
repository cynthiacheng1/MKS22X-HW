public class Location implements Comparable<Location>{
	private int row, col; 
	private int distanceToGoal;
	private int distanceToStart;
	private Location previous;
	private boolean aStar;

	public Location(int r, int c, Location prev, int distToStrt, int distToGol, boolean aStr){
		row = r;
		col = c;
		previous = prev;
		distanceToStart = distToStrt;
		distanceToGoal = distToGol;
		aStar = aStr;
	}

	public int compareTo(Location other){
		if(aStar){
			return distanceToGoal+distanceToStart - (other.getDistToGoal() + other.getDistToStart());
		}
		return distanceToGoal - other.getDistToGoal();
	}
    public static int dist(Location loc, int r, int c){
		return Math.abs(loc.getRow() - r) + Math.abs(loc.getCol() - c);
    }

    public int getRow(){
    	return row;
    }

    public int getCol(){
    	return col;
    }

    public int getDistToGoal(){
    	return distanceToGoal;
    }

    public int getDistToStart(){
    	return distanceToStart;
    }

    public Location getPrevious(){
    	return previous;
    }
    
    public boolean getAStar(){
    	return aStar;
    }

    public void setAStar(boolean a){
    	aStar = a;
    }
}