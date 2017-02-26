public class KnightBoard{
	int[][] board;
	int rows;
	int cols;

	public KnightBoard(int startingRows, int startingCols){
		board = new int[startingRows][startingCols];
		rows = startingRows;
		cols = startingCols;
		for(int row=0;row<board[0].length;row++){
	    	for(int col=0;col<board.length;col++){
				board[col][row]=0;
	    }
	}
	}

	public void solve(){
		solveH(0,0,1);
	}

	private boolean validMove(int row, int col){
		return (row < board.length && row > -1 && col < board[0].length && col > -1);
    }

	public boolean solveH(int row, int col, int level){
		if (level > (rows*cols)){
			return true;
		}
		if (validMove(row,col)){
			//System.out.println("validMove " + row +" "+ col);
			if(board[row][col] == 0){
				board[row][col] = level;
				//System.out.println(level);
				//System.out.println(print2D(board));
				if (solveH(row+1,col+2,level+1) ||
					solveH(row+1,col-2,level+1) ||
					solveH(row-1,col+2,level+1) ||
					solveH(row-1,col-2,level+1) ||
					solveH(row+2,col+1,level+1) ||
					solveH(row+2,col-1,level+1) ||
					solveH(row-2,col+1,level+1) ||
					solveH(row-2,col-1,level+1)){
					//System.out.println(level);
						return true;
					}
				board[row][col] = 0;
			}
		}
		return false;
	}

	public String toString(){
		String ans = "";
		for (int i = 0; i < board.length; i ++){
		    ans += "\n";
		    for (int j = 0; j < board[0].length; j ++){
			if (board[i][j] < 10)
			    ans += " " + board[i][j] + " ";
			else
			    ans += "" + board[i][j] + " ";
		    }
		}
		return ans+"\n";
    }

    public static String print2D(int[][] array){
        String ans = "[";
        for (int i=0; i < array.length; i++){
            ans += "\n [";
            for (int j=0; j < array[0].length; j++){
                ans += array[i][j] +",";
            }
            ans = ans.substring(0,ans.length()-1) + "]";
        }
        return ans + "]";
    }

    public static void main(String args[]){
    	KnightBoard test = new KnightBoard(8,8);
    	test.solve();
    	System.out.println(test);
    }

}