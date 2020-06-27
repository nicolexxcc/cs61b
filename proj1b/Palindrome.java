
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> finalDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            finalDeque.addLast(word.charAt(i));
        }
        return finalDeque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        if (word.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    public String dequeToString(Deque d) {
        String words = "";
        while (d.size() > 0) {
            words += d.removeFirst();
        }
        return words;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);

        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            if (cc.equalChars(d.removeFirst(), d.removeLast())) {
                return isPalindrome(dequeToString(d), cc);
            } else {
                return false;
            }
        }
    }
}
