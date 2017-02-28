public class Recursion{ 
 public static String name(){
    return "Cheng,Cynthia";
 }
 public static double sqrt(double n){
    if (n <0){
        throw new IllegalArgumentException();
    }
    if (n < 2){
        return n;
    }
    else {
        return newGuess(n,1);
    }
 } 

 public static double newGuess(double n, double guess){
    double betterGuess = (n/guess + guess)/2;
    if ( (Math.abs((betterGuess*betterGuess) - n)) < .00000000001){
        return betterGuess;
    }
    else{
        return newGuess(n, betterGuess);
    }
 }
public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//very generous %error accepted
  }
  public static void main(String[]args){
    double[] input = {1.0,2.0,4.0,7.0,10.0,100.0,1024.0,-1.0,0.0};
    int score = 0;
    for(double in : input){
      try{
        if(closeEnough(Recursion.sqrt(in),Math.sqrt(in))){
          score++;
          //System.out.println("PASS test "+in+" "+Recursion.sqrt(in));
        }
        else{
          System.out.println("Fail test "+in+" "+Recursion.sqrt(in)+" vs "+Math.sqrt(in));
        }
      }catch(IllegalArgumentException n){
        if(in == -1){
          score++;
        }
      }catch(Exception e){
        System.out.println("Some exception in test case:"+in);
      }
    }
    System.out.println(score+";out of: "+input.length+";"+Recursion.name());
  }

}