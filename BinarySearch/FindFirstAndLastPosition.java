package BinarySearch;

public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums == null || nums.length == 0) {
            return result;
        }

        int st = 0;
        int end = nums.length - 1;

        while (st < end) {
            int mid = st + ((end - st) / 2);

            if (nums[mid] >= target) {
                end = mid;
            } else {
                st = mid + 1;
            }
        }

        if (nums[st] != target) {
            return result;
        }

        result[0] = st;

        st = result[0];
        end = nums.length - 1;
        while (st < end) {
            int mid = st + (end - st + 1) / 2;

            if (nums[mid] <= target) {
                st = mid;
            } else {
                end = mid - 1;
            }
        }

        result[1] = end;

        return result;
    }

}
