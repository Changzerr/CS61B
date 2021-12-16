import java.util.LinkedList;

/**
 * @author lingqu
 * @date 2021/12/13
 * @apiNote
 */
public class LinkedListDeque<T> {




    private class Node{
        public Node next;
        public Node front;
        public T item;

        public Node(T i, Node front, Node next){
            item = i;
            this.front = front;
            this.next = next;
        }
    }
    private Node head;
    private int size;

    public LinkedListDeque(){
        T a = null;
        head = new Node(a, null,null);
        head.next = head.front;
        head.front = head;
        size = 0;
    }

    public LinkedListDeque(T x){
        T a = null;
        head = new Node(a,null,null);
        head.next = new Node(x,head,null);
        size = 0;
    }
    public Boolean isEmpty(){
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void addFirst(T front) {
        head.next = new Node(front,head,head.next);
        size++;
    }
    public void addLast(T middle) {
        head.front = new Node(middle,head.front,head);
        size++;
    }
    public void printDeque() {
        Node node = head;
        for(int i = 0; i <size&& node.next != null; i++){
            System.out.println(node.next.item);
            node = node.next;
        }
    }
    public void removeFirst() {
        head.next = head.next.next;
        size--;
    }
}
