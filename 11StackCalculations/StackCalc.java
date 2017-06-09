import java.util.*;

public class StackCalc{
	
	public static double operate(String op, double y, double x){
		if (op.equals("+")){
			return x + y;
		}
		else if (op.equals("-")){
			return x - y;
		}
		else if (op.equals("/")){
			return x / y;
		}
		else if (op.equals("*")){
			return x * y;
		}
		else {
			return x % y;
		}
	}
	public static double eval(String input){
		String[] info = input.split(" ");
		Stack<Double> vals = new Stack<Double>();
		for (int i = 0; i < info.length; i++) {
		    if (info[i].equals("+") || info[i].equals("-") || info[i].equals("*") || info[i].equals("/") || info[i].equals("%")) {
		    	System.out.println(Arrays.toString(vals.toArray()));
				vals.push(operate(info[i], vals.pop(), vals.pop()));
				System.out.println(Arrays.toString(vals.toArray()));

		    }
		    else {
				vals.push(Double.parseDouble(info[i]));
		    }
		}
		return vals.pop();
	}


}
