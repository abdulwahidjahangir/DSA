package BinarySearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int s = 1;
        int e = n;

        while (s <= e) {
            int mid = s + ((e - s) / 2);

            if (isBadVersion(mid)) {
                e = mid - 1;
            } else if (!isBadVersion(mid)) {
                s = mid + 1;
            }
        }
        return s;
    }

    public boolean isBadVersion(int version) {
        return true;
    }
}
