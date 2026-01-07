package StackAndQueue;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();

        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            while (!st.isEmpty() && st.peek()[0] < currTemp) {
                int[] curr = st.pop();
                ans[curr[1]] = i - curr[1];
            }
            st.add(new int[] { currTemp, i });
        }

        return ans;
    }
}
