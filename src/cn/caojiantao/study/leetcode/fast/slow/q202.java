package cn.caojiantao.study.leetcode.fast.slow;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * 快乐数
 */
public class q202 {

    public boolean isHappy(int n) {
        int i = n, j = i;
        do {
            i = next(i);
            j = next(j);
            j = next(j);
        } while (i != j);
        return i == 1;
    }

    private int next(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
