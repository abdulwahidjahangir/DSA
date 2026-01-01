package ArrayAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) > 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}
