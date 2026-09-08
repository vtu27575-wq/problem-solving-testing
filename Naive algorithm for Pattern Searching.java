import java.util.*;

class Solution {
    static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && txt.charAt(i + j) == pat.charAt(j))
                j++;

            if (j == m)
                ans.add(i);
        }

        return ans;
    }
}
