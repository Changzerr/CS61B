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

    /**
     *迭代方法
     */
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
        //StringBuilder sb = new StringBuilder();
        //while (!deque.isEmpty()){
        //    sb.append(deque.removeFirst());
        //}
        //return sb.toString();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < deque.size(); i++){
            ans.append(deque.get(i));
        }
        return ans.toString();
    }


    /**
     *
     * @return
     * 改为递归recursion
     */
    public boolean isPalindrome(String word){
        if(word.length() <= 1){
            return true;
        }else {
            Deque<Character> deque = wordToDeque(word);
            char first = deque.removeFirst();
            char last = deque.removeLast();
            return (first == last) && isPalindrome(listToString(deque));
        }
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {
        return helper(wordToDeque(word), cc);
    }

    private boolean helper(Deque<Character> rest, CharacterComparator cc) {
        if (rest.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(rest.removeFirst(), rest.removeLast())) {
            return false;
        }
        return helper(rest, cc);
    }

}
