package lesson_2026_05_15;

class Node{
    int key;
    Node next;
    Node(int key){
        this.key = key;
        this.next = null;
    }
    Node(){
    }
}
class SinglyLinkedList{
    private Node head;
    public SinglyLinkedList(){
        this.head = null;
    }
    public void traverse(){
        System.out.println("Traverse Linked List");
        Node x = head;
        while (x!=null){
            System.out.print(x.key+" ");
            x = x.next;
        }
        System.out.println();
    }

    public Node search(int k){
        Node x = head;
        while (x!=null && x.key!=k){
            x = x.next;
        }
        return x;
    }

    public void insert(Node x){
        x.next = head;
        head = x;
    }

    public void delete(Node x){
        if(head == null || x == null){
            return;
        }

        if(head == x){
            head = head.next;
            return;
        }

        Node current = head;

        while(current.next != null && current.next != x){
            current = current.next;
        }

        if(current.next == x){
            current.next = x.next;
        }
    }

    public void deleteByKey(int key){
        Node n = search(key);
        delete(n);
    }

    public Node pop(){
        Node x = head;
        delete(head);
        return x;
    }

    public void push(Node x) {
        x.next = head;
        head = x;

    }

    public Node dequeue(){
        if (head.next == null) {
            Node x = head;
            head = null;
            return x;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        Node x = current.next;
        current.next = null;
        return x;
    }

    public void enqueue(Node x) {
        x.next = null;
        if (head == null) {
            head = x;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = x;
    }
}

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Node k  = new Node(10);
        list.insert(k);
        list.insert(new Node(20));
        list.insert(new Node(30));
        list.traverse();
        list.delete(k);
        list.traverse();
        list.deleteByKey(30);
        list.traverse();
    }
}

