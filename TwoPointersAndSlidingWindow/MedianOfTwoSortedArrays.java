package TwoPointersAndSlidingWindow;

import java.util.PriorityQueue;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>((a, b) -> b - a);

        int i = 0, j = 0;

        while (i < nums1.length || j < nums2.length) {
            int curr;
            if (j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            desc.offer(curr);
            asc.offer(desc.poll());

            if (asc.size() > desc.size()) {
                desc.offer(asc.poll());
            }
        }

        if (((nums1.length + nums2.length) & 1) == 1) {
            return desc.peek();
        } else {
            return (desc.peek() + asc.peek()) / 2.0;
        }
    }
}
