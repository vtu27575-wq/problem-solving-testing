import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern))
                result.add(word);
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] map = new int[26];
        int[] used = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';

            if (map[p] != 0) {
                if (map[p] != w + 1)
                    return false;
            } else {
                if (used[w] != 0)
                    return false;

                map[p] = w + 1;
                used[w] = 1;
            }
        }

        return true;
    }
}
