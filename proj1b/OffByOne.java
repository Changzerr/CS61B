/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if( x == y ){
            return true;
        } else {
            return false;
        }
    }
}
