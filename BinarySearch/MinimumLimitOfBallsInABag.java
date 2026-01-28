package BinarySearch;

public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;

        for (int num : nums) {
            right = Math.max(num, right);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (canAchieve(nums, maxOperations, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canAchieve(int[] nums, int maxOperations, int maxBallInABag) {
        long operations = 0;

        for (int num : nums) {
            operations += (num - 1) / maxBallInABag;
            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
