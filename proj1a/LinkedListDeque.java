/**
 * @author lingqu
 * @date 2021/12/13
 * @apiNote
 */
public class LinkedListDeque<T> {

    private class Node {
        public Node next;
        public Node pre;
        public T item;

        public Node(T i, Node pre, Node next){
            item = i;
            this.pre = pre;
            this.next = next;
        }
    }
    private Node head;
    private Node last;
    private int size;

    public LinkedListDeque() {

        head = new Node(null, null,null);
        head.next = head;
        head.pre = head;
        size = 0;
    }

    LinkedListDeque(T x) {

        head = new Node(null,null,null);
        head.next = new Node(x,head,head);
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void addFirst(T pre) {
        if(size == 0){
            Node temp = new Node(pre,head,head);
            head.pre = temp;
            head.next = temp;
            last = temp;
            size++;
        } else{
            Node temp = new Node(pre,head,head.next);
            head.next.pre = temp;
            head.next = temp;
            size++;
        }
    }
    public void addLast(T middle) {
        if(size == 0){
            Node temp = new Node(middle,head,head);
            head.pre = temp;
            head.next = temp;
            last = temp;
            size++;
        }else{
            Node temp = new Node(middle,last,last.next);
            head.pre = temp;
            last.next = temp;
            last = temp;
            size++;
        }
    }
    public void printDeque() {
        Node node = head.next;
        for(int i = 0; i <size; i++){
            System.out.print(node.item.toString() + " ");
            node = node.next;
        }
    }
    public T removeFirst() {
        if(size == 0){
            return null;
        }else{
            Node temp = head.next;
            T res = temp.item;
            head.next = head.next.next;
            head.next.pre = head;
            temp = null;
            size--;
            return res;
        }

    }

    public T removeLast() {
        if(size == 0){
            return null;
        }else{
            Node temp = last;
            T res = temp.item;
            last.pre.next = head;
            head.pre = last.pre;
            temp = null;
            last = head.pre;
            size--;
            return res;
        }

    }

    public T get(int index) {
        if(index < 0 || index >= size){
            return null;
        }
        Node temp = head.next;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.item;
    }

    public T getRecursive(int index){
        if (index > size - 1) {
            return null;
        }
        return getR(head.next, index);
    }

    private T getR(Node next, int index) {
        if(index == 0){
            return next.item;
        }else{
            return getR(next.next,index-1);
        }
    }
}
