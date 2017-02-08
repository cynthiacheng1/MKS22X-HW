public class Recursion{ 
 public static String name(){
 	return "Cheng,Cynthia";
 }
 public static double sqrt(double n){
 	if (n <0){
 		throw new IllegalArgumentException();
 	}
 	else {
 		return newGuess(n,1);
 	}
 } 

 public static double newGuess(double n, double guess){
 	double betterGuess = (n/guess + guess)/2;
 	if ( (Math.abs((betterGuess*betterGuess) - n)) < .0001){
 		return Math.round(betterGuess * 10.0) / 10.0;
 	}
 	else{
 		return newGuess(n, betterGuess);
 	}
 }

 public static void main(String args[]){
 	System.out.println(sqrt(100));
 }

}