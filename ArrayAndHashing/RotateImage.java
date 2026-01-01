package ArrayAndHashing;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int st = 0;
            int end = matrix[i].length - 1;

            while (st < end) {
                int temp = matrix[i][st];
                matrix[i][st] = matrix[i][end];
                matrix[i][end] = temp;
                st++;
                end--;
            }
        }
    }
}
