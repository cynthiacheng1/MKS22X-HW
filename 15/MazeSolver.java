public class MazeSolver{
    public Maze board;
    public Frontier frontier;
    public boolean a;

    public MazeSolver(String filename){
    	this(filename,false);
    }
    
    public MazeSolver(String filename, boolean animate){
		board = new Maze(filename);
		a = animate;
    }

    public void solve(){
    	solve(1);
    }

    public void solve(int way){
		if(way == 0) {
			frontier = new FrontierStack();
		}
		if(way == 1) {
			frontier = new FrontierQueue();
		}
		if(way == 2) {
			frontier = new FrontierPriorityQueue();
		}
		if(way == 3){
		    frontier = new FrontierPriorityQueue();
		    board.getStart().setAStar(true);
		}

		frontier.add(board.getStart());
		boolean done = false;
		
		while(frontier.hasNext() && !done){
		    if(a) {
		    	System.out.println(board.toString(50));
		    }
		    Location next = frontier.next();

		    if(next.getDistToGoal() == 0){
				done = true;
				makePath(next);
		    }
		    else {
		    	process(next);
		    }
		}
    }

    public void process(Location l){
		board.set(l.getRow(), l.getCol(), '.');
		
		for(int i = 1; i <= 4; i++){
		    int r = l.getRow() + (i%2) * (2-i);
		    int c = l.getCol() + ((i+1)%2) * (i-3);
		    
		    if(isValid(r, c)){
				frontier.add(new Location(r, c, l, Location.dist(board.getStart(), r, c), Location.dist(board.getEnd(), r, c), l.getAStar()));
		    }
		}
    }

    public void makePath(Location l){
		while(l != null){
		    board.set(l.getRow(), l.getCol(), '@');
		    if(a) System.out.println(board.toString(50));
		    l = l.getPrevious();
		}
    }
    
    public boolean isValid(int r, int c){
		return board.get(r, c) == ' ';
    }
    
    public String toString(){
    	return board.toString();
    }

    public static void main(String[] args){
		MazeSolver m = new MazeSolver(args[0], true);
		m.solve(Integer.parseInt(args[1]));
    }
}