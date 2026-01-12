package BinarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = findMax(piles);

        int res = max;
        while (min <= max) {
            int mid = min + ((max - min) / 2);
            int hours = hourRequiredToEatAllBananas(piles, mid);

            if (hours <= h) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    private int hourRequiredToEatAllBananas(int[] piles, int k) {
        int totalHours = 0;
        for (int bananas : piles) {
            totalHours += Math.ceil((double) bananas / k);
        }
        return totalHours;
    }

    private int findMax(int[] piles) {
        int max = 0;

        for (int bananas : piles) {
            max = Math.max(max, bananas);
        }

        return max;
    }
}
