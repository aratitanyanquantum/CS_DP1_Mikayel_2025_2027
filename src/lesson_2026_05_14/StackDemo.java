package lesson_2026_05_14;

class Stack {

    static int[] stack = new int[6];
    static int top = 0;

    static void push(int x) {
        if (top == stack.length) {
            System.out.println("Overflow");
            return;
        }
        stack[top++] = x;
    }

    static int pop() {
        if (top == 0) {
            System.out.println("Underflow");
            return -1;
        }
        return stack[--top];
    }
}
class Queue {
    static int[] queue = new int[6];
    static int head = 0, tail = 0;

    static void enqueue(int x) {
        if ((tail + 1) % queue.length == head) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[tail] = x;
        tail = (tail + 1) % queue.length;
    }

    static int dequeue() {
        if (head == tail) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int x = queue[head];
        head = (head + 1) % queue.length;
        return x;
    }
}

public class StackDemo {
    public static void main(String[] args){
    }
}

