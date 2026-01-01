package TwoPointersAndSlidingWindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        int currentSum = 0;
        while (i < nums.length) {
            currentSum += nums[i++];

            while (currentSum >= target) {
                minLength = Math.min(i - j, minLength);
                currentSum -= nums[j++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
