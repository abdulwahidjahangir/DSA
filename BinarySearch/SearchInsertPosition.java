package BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int ans = 0;

        while (st <= end) {
            int mid = st + ((end - st) / 2);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
                ans = mid;
            } else {
                ans = mid + 1;
                st = mid + 1;
            }
        }

        return ans;
    }
}
