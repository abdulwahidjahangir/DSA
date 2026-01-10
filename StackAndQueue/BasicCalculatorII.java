package StackAndQueue;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");

        Stack<Integer> st = new Stack<>();

        int num = 0;
        char prevOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }

            if (!Character.isDigit(curr) || i == s.length() - 1) {
                if (prevOperator == '+') {
                    st.add(num);
                } else if (prevOperator == '-') {
                    st.add(-num);
                } else if (prevOperator == '*') {
                    st.add(num * st.pop());
                } else {
                    st.add(st.pop() / num);
                }

                prevOperator = curr;
                num = 0;
            }

        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

}
