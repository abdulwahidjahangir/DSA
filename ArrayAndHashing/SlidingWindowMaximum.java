package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        int lastMax = nums[0];

        while (j < nums.length) {
            if (j - i < k) {
                lastMax = Math.max(lastMax, nums[j]);
                j++;
            } else {
                ans.add(lastMax);

                i++;

                if (nums[i] == lastMax) {
                    continue;
                }

                if (nums[i - 1] == lastMax) {

                    lastMax = nums[i];
                    for (int l = i; l <= j; l++) {
                        lastMax = Math.max(lastMax, nums[l]);
                    }
                }

            }
        }

        ans.add(lastMax);

        int[] result = new int[ans.size()];
        for (i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
