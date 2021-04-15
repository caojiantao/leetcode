package cn.caojiantao.study.dynamic;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 */
public class q70 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int i = 1, j = 2, res = 0;
        for (int index = 2; index < n; index++) {
            res = i + j;
            i = j;
            j = res;
        }
        return res;
    }
}
