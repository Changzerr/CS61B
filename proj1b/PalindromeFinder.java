/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        OffByN offByN = new OffByN(4);
        while (!in.isEmpty()) {
            String word = in.readString();
            OffByN wordOffByN = new OffByN(9);
            if (word.length() >= minLength && palindrome.isPalindrome(word,wordOffByN)) {
                System.out.println(word);
            }
        }
    }
}
