import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
    ArrayList<String> words = new ArrayList<String>();
    help(words, s, 0, "");
    Collections.sort(words);
    return words;
  }
  
  private static void help(ArrayList<String> words, String orgString, int index, String s){
    if (index >= orgString.length()){
      words.add(s);
      return;
    }
    help(words, orgString, index+1, s);
    help(words, orgString, index+1, s + orgString.substring(index,index+1) );
  }

  public static void main(String args[]){
    System.out.println(Arrays.toString(combinations("abc").toArray()));
  }
}
