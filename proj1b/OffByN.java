/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public class OffByN implements CharacterComparator  {

    private int n;
    public OffByN(int N){
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs((int)x - (int)y) == n;
    }
}
