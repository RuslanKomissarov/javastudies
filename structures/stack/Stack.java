package structures.stack;

import javax.management.RuntimeErrorException;

public class Stack {

    int stack[];
    int top = 0;
    int size;

    public Stack() {
        stack = new int[top];
    }

    public Stack(int size) {
        stack = new int[size];
        this.size = size;
    }

    public void push(int data) {
        if(size != 0 && top == size) {
            throw new RuntimeErrorException(new Error("Stack is already full"));
        } else if(stack.length==top) {
            increase();
        }
            
        stack[top] = data;
        top++;
    }

    private void increase(){
        int copy[] = stack;
        stack = new int[top+1];
        top = 0;
        for(int n : copy) {
            push(n);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeErrorException(new Error("Stack is empty"));
        } 
        top--;
        int data = stack[top];
        stack[top] = 0;
        if (size == 0) {
            decrease();
        }
        return data;
    }

    private void decrease(){
        int copy[] = stack;
        stack = new int[top];
        top = 0;
        for(int i = 0; i < copy.length-1; i++){
            push(copy[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeErrorException(new Error("Stack is empty"));
        }
        int data = stack[top - 1];
        return data;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public void show() {
        for (int n : stack) {
            System.out.println(n);
        }
    }
}
