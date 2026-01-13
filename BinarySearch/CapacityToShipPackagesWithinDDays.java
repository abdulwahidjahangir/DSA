package BinarySearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int min = Arrays.stream(weights).max().getAsInt();
        int max = Arrays.stream(weights).sum();
        int ans = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int requiredDays = daysRequired(weights, mid);

            if (requiredDays <= days) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int daysRequired(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return days;
    }
}
