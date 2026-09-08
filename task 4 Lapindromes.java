import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int[] freq = new int[26];
            int n = s.length();

            for (int i = 0; i < n / 2; i++) {
                freq[s.charAt(i) - 'a']++;
                freq[s.charAt(n - 1 - i) - 'a']--;
            }

            boolean result = true;

            for (int x : freq) {
                if (x != 0) {
                    result = false;
                    break;
                }
            }

            System.out.println(result ? "YES" : "NO");
        }
    }
}
