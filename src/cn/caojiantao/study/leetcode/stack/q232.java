package cn.caojiantao.study.leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 用栈实现队列
 */
public class q232 {

    private Stack<Integer> left;
    private Stack<Integer> right;

    /** Initialize your data structure here. */
    public q232() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        left.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) right.push(left.pop());
        }
        return right.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) right.push(left.pop());
        }
        return right.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}
