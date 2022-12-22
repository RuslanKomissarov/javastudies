package structures.linkedlist;

import javax.management.RuntimeErrorException;

public class LinkedList <T> {
    private Node<T> head;

    public void show(){
        Node<T> tempNode = head;
        while(tempNode.nextObject != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.nextObject;
        }
        System.out.println(tempNode.value);
    }

    public void insert(T value){
        Node<T> newNode = new Node<T>(value, null);

        if(head==null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while(temp.nextObject!=null){
                temp = temp.nextObject;
            }
            temp.nextObject = newNode;
        }
    }

    public void insertAtIndex(T value, int atIndex){
        if(atIndex == 0) {
            insertAtFirst(value);
        } else if (atIndex < 0) {
            throw new RuntimeErrorException(new Error("Index must be greater than zero"));
        } else {
            Node<T> node = head;
            int index = 0;
            while(index<atIndex-1){
                node = node.nextObject;
                index++;
            }
            Node<T> newNode = new Node<T>(value, null);
            Node<T> tempNode = node.nextObject;
            node.nextObject = newNode;
            newNode.nextObject = tempNode;
        }
    }

    public void insertAtFirst(T value){
        Node<T> newNode = new Node<T>(value, head);
        head = newNode;
    }

    public void replace(T value, int atIndex){
        Node<T> node = head;
        int index = 0;
        while(index<atIndex-1){
            node = node.nextObject;
            index++;
        }
        node.value = value;
    }

    public int length(){
        if(head==null) return 0;
        Node<T> node = head;
        int count = 0;
        while(node.nextObject != null) {
            node = node.nextObject;
            count++;
        }
        count++;
        return count;
    }

    public T get(int index){
        if(index>=length()) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        int count = 0;
        while(count<index){
            node = node.nextObject;
            count++;
        }
        return node.value;
    }

    public void removeAt(int index){
        if(index>=length()) throw new IndexOutOfBoundsException();
        if(index==0){
            head = head.nextObject;
        } else {
            Node<T> node = head;
            int count = 0;
            while(count<index-1){
                node = node.nextObject;
                count++;
            }
            Node<T> tempNode = node.nextObject;
            node.nextObject = tempNode.nextObject;    
        }
    }
}
