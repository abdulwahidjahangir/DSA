package ArrayAndHashing;

import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }

            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
    }
}
