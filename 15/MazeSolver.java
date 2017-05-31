public class MazeSolver{
    public Maze board;
    public Frontier frontier;
    public boolean a;
    
    public MazeSolver(String filename, boolean animated){
		board = new Maze(filename);
		a = animated;
    }

    public void solve(){
    	solve(0);
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
		Location l = board.getStart()
		frontier.add(l);
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
		    
		    if(board.get(r, c) == ' '){
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
    
    
    public String toString(){
    	return board.toString();
    }

}