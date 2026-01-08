package StackAndQueue;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ']') {
                st.push(String.valueOf(ch));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    sb.insert(0, st.pop());
                }

                st.pop();

                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    num.insert(0, st.pop());
                }

                int n = Integer.parseInt(num.toString());
                String repeated = sb.toString().repeat(n);

                st.push(repeated);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}
