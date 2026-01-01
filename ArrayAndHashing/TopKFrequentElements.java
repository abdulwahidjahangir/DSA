package ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            pq.add(new int[] { i.getKey(), i.getValue() });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int index = 0;
        while (index < k && !pq.isEmpty()) {
            ans[index++] = pq.poll()[0];
        }

        return ans;
    }
}
