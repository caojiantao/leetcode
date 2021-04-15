package cn.caojiantao.study.leetcode.sliding.window;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 买卖股票的最佳时机
 */
public class q121 {

    public static void main(String[] args) {
        q121 q121 = new q121();
        System.out.println(q121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(q121.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0, j = 0; j < prices.length; j++) {
            if (prices[i] < prices[j]) {
                res = Math.max(prices[j] - prices[i], res);
            } else {
                i = j;
            }
        }
        return res;
    }
}
