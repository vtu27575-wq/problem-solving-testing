import java.util.*;

class Result {
    public static List<Integer> maxSubarray(List<Integer> arr) {
        int current = arr.get(0);
        int maxSub = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            current = Math.max(arr.get(i), current + arr.get(i));
            maxSub = Math.max(maxSub, current);
        }

        int maxSeq = 0;
        int maxElement = arr.get(0);

        for (int x : arr) {
            if (x > 0)
                maxSeq += x;
            maxElement = Math.max(maxElement, x);
        }

        if (maxSeq == 0)
            maxSeq = maxElement;

        return Arrays.asList(maxSub, maxSeq);
    }
}
