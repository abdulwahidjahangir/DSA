package BinarySearch;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int ans = -1;
        while (min <= max) {
            int mid = min + ((max - min) / 2);

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int d : bloomDay) {
            if (d <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets >= m) {
                        return true;
                    }
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
