package ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (prefix.containsKey(sum - k)) {
                count += prefix.get(sum - k);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}