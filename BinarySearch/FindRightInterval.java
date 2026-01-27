package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {

        Map<Integer, Integer> startIndexMap = new HashMap<>();
        int[] sortedStarts = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startIndexMap.put(intervals[i][0], i);
            sortedStarts[i] = intervals[i][0];
        }

        Arrays.sort(sortedStarts);

        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int insertPos = lowerBound(sortedStarts, intervals[i][1]);

            if (insertPos == sortedStarts.length) {
                result[i] = -1;
            } else {
                result[i] = startIndexMap.get(sortedStarts[insertPos]);
            }
        }

        return result;
    }

    private int lowerBound(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int[] findRightInterval0(int[][] intervals) {
        int[] ans = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int idx = -1;
            int minStart = Integer.MAX_VALUE;

            for (int j = 0; j < intervals.length; j++) {
                if (i == j) {
                    continue;
                }

                if (intervals[j][0] >= intervals[i][1] && minStart > intervals[j][0]) {
                    idx = j;
                    minStart = intervals[j][0];
                }
            }
            ans[i] = idx;
        }

        return ans;
    }
}
