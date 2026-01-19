package BinarySearch;

public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int st = 0;
        int end = x / 2;

        while (st <= end) {
            int mid = st + ((end - st) / 2);

            long sq = (long) mid * mid;

            if (sq == x) {
                return mid;
            } else if (sq < x) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
