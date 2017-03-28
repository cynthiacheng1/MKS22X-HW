import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
    ArrayList<String>words = new ArrayList<String>();
    words.add(" ");
    help(words, s, 0);
    Collections.sort(words);
    return words;
  }
  
  private static void help(ArrayList<String> words, String orgString, int index){
    if (index == orgString.length()){
      return;
    }
    for (int i =0; i < orgString.length(); i++){
      int size = words.size();
      for (int j =0; j <size; j++){
        words.add(words.get(j) + orgString.charAt(i));
      }
    }
  }

  public static void main(String args[]){
    System.out.println(Arrays.toString(combinations("abc").toArray()));
  }
}
