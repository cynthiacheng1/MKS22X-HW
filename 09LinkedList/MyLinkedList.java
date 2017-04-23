import java.util.*;
public class MyLinkedList implements Iterable<Integer>{

  private class LNode{
    LNode next,prev;
    int value;

    public LNode(int value){
      this.value=value;
    }

    public String toString(){
      return value+"";
    }

  }
  private class MyLinkedListIterator implements Iterator<Integer>{
    LNode current = head;

    public boolean hasNext(){
        return current != null;
    }

    public Integer next(){
      if(hasNext()){
        LNode prev = current;
        current = current.next; 
        return new Integer(prev.value);
      }
      else{
        throw new NoSuchElementException();
      }
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
  }
    
  LNode head = null;
  LNode tail = null;
  int size = 0;

  public int size(){
    return size;
  }

  public MyLinkedList(){
  
  }

  public Iterator<Integer> iterator(){
    return new MyLinkedListIterator();
  }
    
  private LNode getNthNode(int n){
    if(n<0 || n > size()){
      throw new IndexOutOfBoundsException("index out of bounds");
    }
      LNode oneImAt;
      if (n <= size/2){
        oneImAt = head;
        for (int i =0; i < size/2; i++){
          oneImAt = oneImAt.next;
        }
      }
      else{
        oneImAt = tail;
        for (int i = size; i>0; i--){
          oneImAt = oneImAt.prev;
        }
      }
    return oneImAt;
  }

  private void addAfter(LNode location, LNode toBeAdded){
    if (location == tail){
      tail.next = toBeAdded;
      toBeAdded.prev = tail;
      tail = toBeAdded;
    }
    else {
      toBeAdded.next = location.next;
      toBeAdded.prev = location;
      location.next = toBeAdded;
    }
    size++;
  }

  private void remove(LNode target){
    if (target == head){
      head = head.next;
      if (size != 1){
        head.prev = null;
      }
    }
    else if (target == tail){
      tail = tail.prev;
      tail.next = null;
    }
    else{
      target.prev.next = target.next;
      target.next.prev = target.prev;
    }
    size--;
  }

  public String toString(){ 
    String ans = "[";
    if (size >0){
      LNode current = head;
      for (int i=0; i <size; i++){
        ans += current.value +",";
        current = current.next;
      }
    }
    return ans.substring(0,ans.length()) +"]";
  }

  public int get(int index){
    return getNthNode(index).value;
  }

  public int set(int index, int value){
    if (index >= size){
      throw new IndexOutOfBoundsException();
    }
    LNode prev = getNthNode(index);
    int prevVal = prev.value;
    prev.value = value;

    return prevVal;
  }

  public int indexOf(int value){
    LNode current = head;
    for (int i=0; i< size; i++){
      if (current.value == value){
        return i;
      }
      current = current.next;
    }
    return -1;
  }

  public int remove(int index){
    if(index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    int pop;
    if (size == 1){
      pop = head.value;
      head = null;
      tail = null;
    }
    else if (index == size-1){
      pop  = tail.value;
      tail = tail.prev;
      tail.next = null;
    }
    else if (index ==0){
      pop = head.value;
      head = head.next;
      head.prev = null;
    }
    else{
      LNode takeOut = getNthNode(index);
      pop = takeOut.value;
      takeOut.prev.next = takeOut.next;
      takeOut.next.prev = takeOut.prev;
    }
    return pop;
  }

  public void add(int index,int value){
    if (index <0 || index>size){
      throw new IndexOutOfBoundsException("Index out of bounds!");
    }
    LNode add = new LNode(value);
    if (size ==0){
      head = add;
      tail = add;
    }
    else if (index == size){
      tail.next = add;
      add.prev = tail;
      tail = add;
    }
    else if (index ==0){
      head.prev = add;
      add.next = head;
      head = add;
    }
    else{
      LNode before = getNthNode(index-1);
      add.prev = before;
      add.next = before.next;
      before.next.prev = add;
      before.next = add;
    }
    size++;
  }

  public boolean add(int value){
    add(size-1, value);
    return true;
  }


}