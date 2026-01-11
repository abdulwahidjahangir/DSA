package BinarySearch;

public class SearchATwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int st = 0;
        int end = n * m - 1;

        while (st <= end) {
            int mid = st + ((end - st) / 2);

            int row = mid / m;
            int col = mid % m;

            int element = matrix[row][col];

            if (element == target) {
                return true;
            }

            if (element > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return false;
    }
}
