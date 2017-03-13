import java.io.*;
import java.util.*;    
public class USACO{

    private int[][] lake;
    private int r;
    private int c;
    private int e;
    private int n;

    public USACO(){
    }

    public int bronze(String filename){
	Scanner sc = null;
	try{
	    File f1 = new File(filename);
	    sc = new Scanner(f1);
	}
	catch(Exception e){
	    System.out.println("File not found");
	    System.exit(0);
	}

	Scanner Line1 = new Scanner(sc.nextLine());
	r = Integer.parseInt(Line1.next());
	c = Integer.parseInt(Line1.next());
	e = Integer.parseInt(Line1.next());
	n = Integer.parseInt(Line1.next());

	lake = new int[r][c];

	for(int x = 0; x < r ; x++){
	    Scanner nextLines = new Scanner(sc.nextLine());
	    for(int y = 0; y < c; y++){
		lake[x][y] = nextLines.nextInt();
	    }
	}

	while(sc.hasNextLine()){
	    Scanner lastLine = new Scanner(sc.nextLine());
	    int row = lastLine.nextInt() - 1;
	    int col = lastLine.nextInt() - 1;
	    int depth = lastLine.nextInt();
	    int height = stomp(row, col, depth);

	    for(int x = row; x < row + 3; x++){
		for(int y = col; y < col + 3; y++){
		    if(lake[x][y] > height){
			lake[x][y] = height;
		    }
		}
	    }
	}
	return volume(e);
}

        private int stomp(int row, int col, int depth){
	int tempRow = row;
	int tempCol = col;
	int temp = lake[row][col];
	for(int x = row; x < row + 3; x++){
	    for(int y = col; y < col + 3; y++){
		if (lake[x][y] > temp){
		    temp = lake[x][y];
		    tempRow = x;
		    tempCol = y;
		}
	    }
	}
	lake[tempRow][tempCol] -= depth;
        int ans = temp - depth;
       	return ans;

    }

    private int volume(int elevation){
	int total = 0;
	for(int x = 0; x < r; x++){
	    for(int y = 0; y < c; y++){
		if(lake[x][y] < e){
		    total += e - lake[x][y];
		}
	    }
	}
	return total * 72 * 72;
    }

    private int numRows;
    private int numCols;
    private int time;
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private int[][]pasture;
    private int[][]pasture2;

    public int silver(String filename){
	Scanner sc = null;
	try{
	    File f1 = new File(filename);
	    sc = new Scanner(f1);
	}
	catch(Exception e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	
	Scanner firstLine = new Scanner(sc.nextLine());
	numRows = Integer.parseInt(firstLine.next());
	numCols = Integer.parseInt(firstLine.next());
	time = Integer.parseInt(firstLine.next());

	pasture = new int[numRows][numCols];
	pasture2 = new int[numRows][numCols];

	for(int x = 0; x < numRows; x++){
	    String nextLines = sc.next();
	    for(int y = 0; y < numCols; y++){
		if(nextLines.charAt(y) == '*'){
		    pasture[x][y] = -1;
		    pasture2[x][y] = -1;
		}
		else{
		    pasture[x][y] = 0;
		    pasture2[x][y] = 0;
		}
	    }
	}

	startRow = sc.nextInt() - 1;
	startCol = sc.nextInt() - 1;
	endRow = sc.nextInt() - 1;
	endCol = sc.nextInt() - 1;

	return numberOfPaths();
    }

    private void updatePastures(){
	for(int x = 0; x < numRows; x++){
	    for(int y = 0; y < numCols; y++){
		pasture[x][y] = pasture2[x][y];
	    }
	}
    }

    private int numberOfPaths(){
	pasture[startRow][startCol] = 1;
	for(int z = 0; z < time; z++){
	    for (int x = 0; x < numRows; x++){
		for(int y = 0; y < numCols; y++){
		    int total = 0;
		    if(x + 1 < numRows && pasture[x + 1][y]!= -1){
			total += pasture[x + 1][y];
		    }
		    if(x - 1 >= 0 && pasture[x - 1][y]!= -1){
			total += pasture[x - 1][y];
		    }		    
		    if(y + 1 < numCols && pasture[x][y + 1]!= -1){
			total += pasture[x][y + 1];
		    }
		    if(y - 1 >= 0 && pasture[x][y - 1]!= -1){
			total += pasture[x][y - 1];
		    }
		    if(pasture[x][y]!=-1){
			pasture2[x][y] = total;
		    }
		}
	    }
	    updatePastures();
	}
	return pasture[endRow][endCol];
    }
			   			   
}
		
	
