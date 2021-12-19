import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    */
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars(){
        OffByOne obo = new OffByOne();
        //true
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('r', 'q'));
        //false
        assertFalse(obo.equalChars('a', 'e'));
        assertFalse(obo.equalChars('a', 'a'));
        assertFalse(obo.equalChars('z', 'a'));
    }
}
