package StackAndQueue;

import java.util.Stack;

public class OnlineStockSpan {

    Stack<int[]> st;

    public OnlineStockSpan() {
        st = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            count += st.pop()[1];
        }
        st.add(new int[] { price, count });
        return count;
    }
}
