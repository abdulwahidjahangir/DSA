package StackAndQueue;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        int[] prevSmallestElement = prevSmallestElement(heights);
        int[] nextSmallestElement = nextSmallestElement(heights);

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if (nextSmallestElement[i] == -1) {
                nextSmallestElement[i] = heights.length;
            }
            int width = nextSmallestElement[i] - prevSmallestElement[i] - 1;
            result = Math.max(result, height * width);
        }

        return result;
    }

    private int[] prevSmallestElement(int[] heights) {
        int[] ans = new int[heights.length];

        Stack<Integer> st = new Stack<>();
        st.add(-1);

        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= currHeight) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add(i);
        }

        return ans;
    }

    private int[] nextSmallestElement(int[] heights) {
        int[] ans = new int[heights.length];

        Stack<Integer> st = new Stack<>();
        st.add(-1);
        for (int i = heights.length - 1; i >= 0; i--) {
            int currHeight = heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= currHeight) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add(i);
        }

        return ans;
    }
}
