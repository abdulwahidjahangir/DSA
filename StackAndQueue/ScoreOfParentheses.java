package StackAndQueue;

import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(String.valueOf(ch));
            } else {
                int sum = 0;

                while (!st.isEmpty() && !st.peek().equals("(")) {
                    sum += Integer.valueOf(st.pop());
                }

                st.pop();

                if (sum == 0) {
                    st.add(String.valueOf(1));
                } else {
                    st.add(String.valueOf(sum * 2));
                }
            }
        }

        int ans = 0;

        while (!st.isEmpty()) {
            ans += Integer.valueOf(st.pop());
        }

        return ans;
    }
}
