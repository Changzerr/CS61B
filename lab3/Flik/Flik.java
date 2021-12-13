import org.junit.Test;

import static org.junit.Assert.assertTrue;


/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        //return a==b;
        return a.equals(b);
    }

    @Test
    public void testIsSameNumber(){
        Integer a ;
        Integer b;
        a = 128;
        b = 128;
        assertTrue(isSameNumber(a,b));
    }
}
