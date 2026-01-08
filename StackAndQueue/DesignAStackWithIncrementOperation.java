package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class DesignAStackWithIncrementOperation {
    private final int max;
    private final List<Integer> stack;

    public DesignAStackWithIncrementOperation(int maxSize) {
        this.stack = new ArrayList<>();
        this.max = maxSize;
    }

    public void push(int x) {
        if (stack.size() >= max) {
            return;
        }

        stack.add(x);
    }

    public int pop() {
        if (stack.size() == 0) {
            return -1;
        }

        return stack.remove(stack.size() - 1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < stack.size(); i++) {
            stack.set(i, stack.get(i) + val);
        }
    }
}
