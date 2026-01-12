package BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int st = 1;
        int end = nums.length - 2;

        while (st < end) {
            int mid = st + ((end - st) / 2);

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
