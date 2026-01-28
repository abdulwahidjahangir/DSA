package BinarySearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int minDis = 0, maxDis = nums[nums.length - 1] - nums[0];

        while (minDis < maxDis) {
            int midDis = minDis + ((maxDis - minDis) / 2);
            int pairsCount = countPairs(nums, midDis);

            if (pairsCount < k) {
                minDis = midDis + 1;
            } else {
                maxDis = midDis;
            }
        }

        return minDis;
    }

    private int countPairs(int[] nums, int targetDistance) {
        int count = 0, left = 0;

        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > targetDistance) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}
