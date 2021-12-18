import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author lingqu
 * @date 2021/12/17
 * @apiNote
 */
public class ArrayDequeTest {
    @Test
    public void testEmptySize() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(99);
        L.addLast(9);
        System.out.println(L.get(0));
        assertEquals(2, L.size());
    }


    @Test
    public void testAddAndGetLast() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(99);
        L.addLast(36);
    }


    @Test
    public void testGet() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(99);
        assertEquals(99, (int)L.get(0));
        L.addLast(36);
        assertEquals(99, (int)L.get(0));
        assertEquals(36, (int)L.get(1));
    }


    @Test
    public void testRemove() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(99);
        assertEquals(99, (int)L.get(0));
        L.addLast(36);
        assertEquals(99, (int)L.get(0));
        L.removeLast();

        L.addLast(100);

        assertEquals(2, L.size());
    }

    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }

    @Test
    public void test(){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(0);
        L.addLast(1);
        L.get(0);
        L.removeLast() ;
        L.addFirst(4);
        L.get(1);
        L.addLast(6);
        L.get(0);
        L.addFirst(8);
        L.addLast(9);
        L.addFirst(10);
        L.get(3) ;
        L.addLast(12);
        L.removeFirst();
        L.addLast(14);
        L.addLast(15);
        L.addFirst(16);
        L.addLast(17);
        L.get(8)   ;
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
