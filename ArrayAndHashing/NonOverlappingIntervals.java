package ArrayAndHashing;

import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });

        for (int[] i : intervals) {
            pq.add(i);
        }

        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int end = curr[1];

            while (!pq.isEmpty() && pq.peek()[0] < end) {
                System.out.println(end + " : " + pq.peek()[1]);
                pq.remove();
                count++;
            }

        }

        return count;
    }
}
