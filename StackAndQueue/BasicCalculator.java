package StackAndQueue;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        long result = 0;
        long number = 0;
        int sign = 1;

        Stack<Long> results = new Stack<>();
        Stack<Integer> signs = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                results.push(result);
                signs.push(sign);

                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;

                result = results.pop() + signs.pop() * result;
            }
        }

        result += sign * number;

        return (int) result;
    }
}
