package BinarySearch;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int st = 1;
        int end = n;

        int res = 0;

        while (st <= end) {
            int mid = st + ((end - st) / 2);
            long reqCoins = (long) mid * (mid + 1) / 2;
            if (reqCoins > n) {
                end = mid - 1;
            } else {
                st = mid + 1;
                res = Math.max(mid, res);
            }
        }

        return res;
    }

}
