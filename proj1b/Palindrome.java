/**
 * @author lingqu
 * @date 2021/12/19
 * @apiNote
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    //public boolean isPalindrome(String word){
    //    Deque<Character> deque = wordToDeque(word);
    //    while (deque.size()>1){
    //        Character first = deque.removeFirst();
    //        Character last = deque.removeLast();
    //        if (!first.equals(last)) {
    //            return false;
    //        }
    //    }
    //    return true;
    //}

    private String listToString(Deque<Character> deque) {
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
    //改为递归recursion
    public boolean isPalindrome(String word){
        if(word.length() <= 1){
            return true;
        }else {
            Deque deque = wordToDeque(word);
            char first = (char) deque.removeFirst();
            char last = (char) deque.removeLast();
            return (first == last) && isPalindrome(listToString(deque));
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() <= 1){
            return true;
        }else {
            Deque deque = wordToDeque(word);
            char first = (char) deque.removeFirst();
            char last = (char) deque.removeLast();
            return cc.equalChars(first,last) && isPalindrome(listToString(deque),cc);
        }
    }

}
