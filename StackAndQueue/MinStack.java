package StackAndQueue;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        if (this.stack.isEmpty()) {
            this.stack.push(val);
            this.min.push(val);
        } else {
            this.stack.push(val);
            if (this.min.peek() < val) {
                this.min.push(min.peek());
            } else {
                this.min.push(val);
            }

        }
    }

    public void pop() {
        this.stack.pop();
        this.min.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.min.peek();
    }
}
