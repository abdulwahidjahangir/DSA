package BinarySearch;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int st = 0, end = num / 2;

        while (st <= end) {
            int mid = st + ((end - st) / 2);
            long pow = (long) mid * mid;

            if (pow == num) {
                return true;
            } else if (pow < num) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

}
