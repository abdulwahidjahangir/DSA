package StackAndQueue;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            boolean isAlive = true;

            while (isAlive && asteroid < 0 && !st.isEmpty() && st.peek() > 0) {
                if (st.peek() < -asteroid) {
                    st.pop();
                } else if (st.peek() == -asteroid) {
                    st.pop();
                    isAlive = false;
                } else {
                    isAlive = false;
                }
            }

            if (isAlive) {
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
