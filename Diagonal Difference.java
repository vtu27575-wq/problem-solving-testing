import java.io.*;
import java.util.*;

class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            left += arr.get(i).get(i);
            right += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(left - right);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            List<Integer> row = new ArrayList<>();

            for (String x : input)
                row.add(Integer.parseInt(x));

            arr.add(row);
        }

        System.out.println(Result.diagonalDifference(arr));
    }
}
