import java.io.*;
import java.util.*;

class Result {

    public static String timeConversion(String s) {
        String period = s.substring(8, 10);
        int hour = Integer.parseInt(s.substring(0, 2));

        if (period.equals("AM") && hour == 12) {
            hour = 0;
        } else if (period.equals("PM") && hour != 12) {
            hour += 12;
        }

        return String.format("%02d", hour) + s.substring(2, 8);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(Result.timeConversion(s));
    }
}
