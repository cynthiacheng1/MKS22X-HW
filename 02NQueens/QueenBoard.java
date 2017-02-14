public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
        if (size < 1){
            throw new IndexOutOfBoundsException("Index " +size + " is out of bounds! Please enter a board size greater than 0!");
        }
        board = new int[size][size];
        solutionCount = -1;
        for (int i =0; i < board.length; i ++){
            for (int j =0; j <board.length; j++){
                board[i][j] = 0;
            }
        }
    }

    public void solve(){ 
        solveH(0);
    }

    private boolean solveH(int col){
        if (col == board.length){
            return true;
        }
        for (int i =0; i < board.length; i ++){
            if (addQueen(i,col)){
                addQueen(i,col);
                if (solveH(col+1)){
                    //System.out.println("works");
                    //System.out.println(print2D(board));
                    return true;
                }
                else{
                    //System.out.println("revert");
                    removeQueen(i,col);
                    //System.out.println(print2D(board));
                }
            }
        }
        return false;
    }


    private boolean addQueen(int row, int col){
        if(board[row][col] == 0){
            board[row][col] = -1;
            for(int i = 1 ; i+col < board.length; i++){
                board[row][col+i]+=1;
                if(row-i>=0){
                    board[row-i][col+i]+=1;
                } 
                if(row+i<board.length){
                    board[row+i][col+i]+=1;
                }  
            }
            return true;
        }
        return false;
    }
    
    private void removeQueen(int row,int col){
        board[row][col] = 0;
        for(int i = 1 ; i+col < board.length; i++){
            board[row][col+i]-=1;
            if(row-i>=0){
                board[row-i][col+i]-=1;
            } 
            if(row+i<board.length){
                board[row+i][col+i]-=1;
            }  
        }
    }


    public int getSolutionCount(){
        return solutionCount;
    }

    public void countSolutions(){
        solutionCount = 0;
        for(int row = 0; row < board.length; row++){
            for(int col=0; col< board.length; col++){
                board[row][col]= 0;
            }
        }
        solutionsEach(0);
    }

    private void solutionsEach(int col){
        if (col == board.length){
            solutionCount++;
        }
        else{
            for(int row=0; row < board.length; row++){
                if (addQueen(row, col)){          
                    solutionsEach(col+1);
                    removeQueen(row, col);
                }
            }
        }
    }

    
    public String toString(){
        String ans = " ";
        for (int i=0; i < board.length; i++){
            ans += "\n [";
            for (int j=0; j < board[0].length; j++){
                if (board[i][j] == -1){
                    ans += "Q ";
                }
                else{
                    ans += "_ ";
                } 
                //ans += board[i][j]+ " ";
            }
            ans = ans.substring(0,ans.length()-1) + "]";
        }
        return ans + "\n";
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
        QueenBoard b = new QueenBoard(10);
        b.solve();
        System.out.println(b);
        b.countSolutions();
        System.out.println(Integer.toString(b.getSolutionCount()));

    }

}