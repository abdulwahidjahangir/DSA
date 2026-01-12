package BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int pivot = getPivot(nums);
        if (pivot == nums.length - 1) {
            return nums[0];
        }

        return nums[pivot + 1];
    }

    public int getPivot(int[] nums) {
        int st = 0;
        int end = nums.length - 1;

        if (nums[st] < nums[end]) {
            return end;
        }

        while (st <= end) {
            int mid = st + ((end - st) / 2);

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (mid > st && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] >= nums[0]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums.length - 1;
    }
}
