import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public class TestArrayDequeGold {
    @Test
    public void test(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
            } else {
                sad1.addFirst(i);
            }
        }

        sad1.printDeque();
    }
}
