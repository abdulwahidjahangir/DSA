package BinarySearch;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        long l = 1;
        long r = n;
        while (l <= r) {
            int m = (int) ((l + r) / 2);
            long g = (int) guess(m);
            if (g == -1) {
                r = m - 1;
            } else if (g == 1) {
                l = m + 1;
                ;
            } else {
                return m;
            }
        }
        return -1;
    }

    public int guess(int i) {
        return 1;
    }
}
