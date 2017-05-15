public class ExpressionTree{

	public double evaluate(){
		if (isValue()){
			return getValue();
		}
		return perform(getOp(), getLeft().evaluate(), getRight().evaluate());
	}
	private double perform(char o, double l, double r){
      if (o=='+'){
	  	return l+r;
      }
      else if (o=='/'){
	  	return l/r;
      }
      else if (o=='-'){
	  	return l-r;
      }
      else if (o=='*'){
	  	return l*r;
      }
      return 0;
  }

	public String toString(){
		if (isValue()){
			return getValue() + "";
		}
		return "( " +getLeft() +" " + getOp() + " " + getRight() + " )";
	}

	 /*return the expression as a postfix notation string without parenthesis*/
  /* The sample tree would be: "3 2 10 * +"     */
  	public String toStringPostfix(){
    	if (isValue()){
    		return getValue() + "";
    	}
    	return getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOp();
  }
  
  /*return the expression as a prefix notation string without parenthesis*/
  /* The sample tree would be: "+ 3 * 2 10"     */
  
	public String toStringPrefix(){
	    /*you are to write this method*/
	  	if (isValue()){
	    	return getValue() + "";
	    }
	    return "" + getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
	}
  
  
  private char op;
  private double value;
  private ExpressionTree left,right;
  
  /*TreeNodes are immutable, so no issues with linking them across multiple
  *  expressions. The can be constructed with a value, or operator and 2
  * sub-ExpressionTrees*/
	public ExpressionTree(double value){
	    this.value = value;
	    op = '~';
	}
	public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
	    this.op = op;
	    left = l;
	    right = r;
	}
	
	public char getOp(){
	    return op;
	}
	  
	  /* accessor method for Value, precondition is that isValue() is true.*/
	  private double getValue(){
	    return value;
	  }
	  /* accessor method for left, precondition is that isOp() is true.*/
	  private ExpressionTree getLeft(){
	    return left;
	  }
	  /* accessor method for right, precondition is that isOp() is true.*/
	  private ExpressionTree getRight(){
	    return right;
	  }
	  
	  private boolean isOp(){
	    return hasChildren();
	  }
	  private boolean isValue(){
	    return !hasChildren();
	  }
	  
	  private boolean hasChildren(){
	    return left != null && right != null;
	  }
	  

}