/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    /** Creates an empty list. */
    public ArrayDeque() {

        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private int addOne(int i) {
        return (i + 1)%items.length;
    }

    private int subOne(int i){
        return (i - 1 + items.length)%items.length;
    }

    /** Rerears the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int oldFirst = addOne(nextFirst);
        for(int i = 0; i < size; i++){
            newItems[i] = items[oldFirst];
            oldFirst = addOne(oldFirst);
        }
        nextLast = size;
        items = newItems;
        nextFirst = items.length - 1;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if(size == items.length){
            resize(size*2);
        }
        items[nextLast] = x;
        nextLast = addOne(nextLast);
        size++;
    }

    @Override
    public void addFirst(T x) {
        if(size == items.length){
            resize(size*2);
        }
        items[nextFirst] = x;
        nextFirst = subOne(nextFirst);
        size++;
    }

    /** Returns the item from the back of the list. */
    private T getLast() {
        return items[subOne(nextLast)];
    }
    private T getFirst() {
        return items[addOne(nextFirst)];
    }
    /** Gets the ith item in the list (0 is the front). */
    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        }
        int start = addOne(nextFirst);
        return items[(start + i) % items.length];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public T removeLast() {
        if(size == 0){
            return null;
        }
        T x = items[subOne(nextLast)];
        items[subOne(nextLast)] = null;
        nextLast = subOne(nextLast);
        size--;
        //保证空间利用率在25%
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return x;
    }

    @Override
    public T removeFirst() {
        if(size == 0){
            return null;
        }
        T x = items[addOne(nextFirst)];
        items[addOne(nextFirst)] = null;
        nextFirst = addOne(nextFirst);
        size--;
        //保证空间利用率在25%
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return x;
    }

    @Override
    public void printDeque(){
        int oldFirst = addOne(nextFirst);
        for(int i = 0; i < size; i++){
            System.out.print(items[oldFirst] + " ");
            oldFirst = addOne(oldFirst);
        }
    }


}

