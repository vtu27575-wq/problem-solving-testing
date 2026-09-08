class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, currentMax = 0, maxSum = nums[0];
        int currentMin = 0, minSum = nums[0];

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}
