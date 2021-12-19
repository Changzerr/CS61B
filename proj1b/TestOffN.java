import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public class TestOffN {
    @Test
    public void test(){
        OffByN offBy5 = new OffByN(5);
        // true
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        // false
        assertFalse(offBy5.equalChars('f', 'h'));

    }
}
