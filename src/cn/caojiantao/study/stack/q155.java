package cn.caojiantao.study.stack;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 */
public class q155 {

    private LinkedList<Integer> numList;
    private LinkedList<Integer> minList;

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public q155() {
        numList = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int x) {
        numList.addLast(x);
        minList.addLast(minList.isEmpty() ? x : Math.min(minList.getLast(), x));
    }

    public void pop() {
        numList.removeLast();
        minList.removeLast();
    }

    public int top() {
        return numList.getLast();
    }

    public int getMin() {
        return this.minList.getLast();
    }

}
