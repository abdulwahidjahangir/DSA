package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] i : intervals) {
            pq.add(i);
        }

        List<int[]> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int st = curr[0];
            int end = curr[1];

            while (!pq.isEmpty() && pq.peek()[0] <= end) {
                end = Math.max(pq.peek()[1], end);
                pq.remove();
            }

            list.add(new int[] { st, end });
        }

        return list.toArray(new int[list.size()][]);
    }
}
