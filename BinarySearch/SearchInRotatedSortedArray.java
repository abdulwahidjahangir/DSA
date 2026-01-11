package BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);

        if (target >= nums[0] && target <= nums[pivot]) {
            return binarySearch(nums, target, 0, pivot);
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int st, int end) {
        while (st <= end) {
            int mid = st + ((end - st) / 2);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return -1;
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
