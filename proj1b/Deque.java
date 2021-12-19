/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public interface Deque<T>{
    public void addLast(T x);
    public void addFirst(T x);
    public T get(int i);
    public int size();
    public boolean isEmpty();
    public T removeLast();
    public T removeFirst();
    public void printDeque();
}
