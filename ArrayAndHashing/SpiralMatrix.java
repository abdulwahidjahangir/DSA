package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int stCol = 0, stRow = 0, endCol = m - 1, endRow = n - 1;
        int totalBox = n * m;
        int countBox = 0;
        List<Integer> ans = new ArrayList<>();
        while (countBox < totalBox) {
            for (int i = stCol; i <= endCol && countBox < totalBox; i++) {
                ans.add(matrix[stRow][i]);
                countBox++;
            }
            stRow++;

            for (int i = stRow; i <= endRow && countBox < totalBox; i++) {
                ans.add(matrix[i][endCol]);
                countBox++;
            }
            endCol--;

            for (int i = endCol; i >= stCol && countBox < totalBox; i--) {
                ans.add(matrix[endRow][i]);
                countBox++;
            }
            endRow--;

            for (int i = endRow; i >= stRow && countBox < totalBox; i--) {
                ans.add(matrix[i][stCol]);
                countBox++;
            }
            stCol++;
        }

        return ans;
    }
}
