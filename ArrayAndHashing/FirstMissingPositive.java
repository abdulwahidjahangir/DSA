package ArrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            if (i > 0) {
                set.add(i);
                max = Math.max(max, i);
            }
        }

        if (max == 0) {
            return 1;
        }

        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max + 1;
    }
}
