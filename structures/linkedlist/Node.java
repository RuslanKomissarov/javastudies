package structures.linkedlist;

public class Node <T> {
    T value;
    Node<T> nextObject;

    public Node(T value, Node<T> nextObject){
      this.value = value;
      this.nextObject = nextObject;  
    } 
}
