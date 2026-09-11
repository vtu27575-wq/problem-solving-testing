import java.util.*;

public class Main {
    static long similarity(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        long sum = n;

        for (int i = 1; i < n; i++) {
            if (i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }

            sum += z[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            System.out.println(similarity(s));
        }
    }
}
