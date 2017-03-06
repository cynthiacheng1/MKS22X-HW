import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    int startC;
    int startR;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
      animate = false;
      File file = new File(filename);
      try {
        String text ="";
        int numOfLines =0;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
          numOfLines++;
          text += sc.nextLine();
        }
        sc.close();
        maze = new char[numOfLines][text.length() / numOfLines];
        int counter = 0;
        for(int i = 0; i < maze.length; i++){
          for(int j = 0; j < maze[0].length; j++){
            maze[i][j] = text.charAt(counter);
            counter++;
          }
        }
        findES();
      } 
        catch (FileNotFoundException e) {
            System.out.println("File not found, check for typos");
            System.exit(1);
        }
    }

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

        //COMPLETE CONSTRUCTOR
    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean findES(){
      boolean s = false;
      boolean e = false;
      for (int col =0; col < maze.length; col++){
        for (int row=0; row < maze.length; row++){
          if (maze[row][col] == 'S'){
            startC = col;
            startR = row;
            s = true;
          }
          if (maze[row][col] == 'E'){
            e = true;
          }
        }
      }
      return (e&&s);
    }

    public boolean solve(){
            int startr=-1,startc=-1;
            //Initialize starting row and startint col with the location of the S. 
            maze[startR][startC] = ' ';//erase the S, and start solving!
            return solve(startR,startC);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
        if (maze[row][col] == 'E'){
          return true;
        }
        if (maze[row][col] == ' '){
          maze[row][col] = '@';
          if ( solve(row+1, col) || solve(row, col+1) ||solve(row-1, col)|| solve(row, col-1)){
            return true;
          }
          maze[row][col] = '.';
        }
        return false; 
    }

      public String toString(){
      String ans = "";
      for(int i = 0; i < maze.length; i++){
        for(int j = 0; j < maze[0].length; j++){
          ans += maze[i][j];
        }
        ans += "\n";
      }
      return ans;
  }


}
