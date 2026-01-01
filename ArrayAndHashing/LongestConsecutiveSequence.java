package ArrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int max = 0;
        for (int i : set) {
            if (set.contains(i - 1)) {
                continue;
            }

            int currMax = 1;
            int curr = i;
            while (set.contains(curr + 1)) {
                curr++;
                currMax++;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }
}
