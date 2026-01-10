package StackAndQueue;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int area = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != '0') {
                    heights[j] = 1 + heights[j];
                } else {
                    heights[j] = 0;
                }
            }
            area = Math.max(area, maxRectangleArea(heights, matrix[0].length));
        }
        return area;
    }

    private int maxRectangleArea(int[] arr, int n) {
        int[] nextSmallest = nextSmallestElement(arr, n);
        int[] prevSmallest = prevSmallestElement(arr, n);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            if (nextSmallest[i] == -1)
                nextSmallest[i] = n;
            int width = nextSmallest[i] - prevSmallest[i] - 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }

    private int[] prevSmallestElement(int[] arr, int n) {
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();
        s.add(-1);
        for (int i = 0; i < n; i++) {
            int currElement = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= currElement) {
                s.pop();
            }
            ans[i] = s.peek();
            s.add(i);
        }
        return ans;
    }

    private int[] nextSmallestElement(int[] arr, int n) {
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();
        s.add(-1);
        for (int i = n - 1; i >= 0; i--) {
            int currElement = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= currElement) {
                s.pop();
            }
            ans[i] = s.peek();
            s.add(i);
        }
        return ans;
    }

}
