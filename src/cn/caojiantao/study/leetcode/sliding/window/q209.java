package cn.caojiantao.study.leetcode.sliding.window;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 长度最小的子数组
 */
public class q209 {

    public static void main(String[] args) {
        q209 q209 = new q209();
        System.out.println(q209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println(q209.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            while (j < nums.length && sum < target) sum += nums[j++];
            if (sum < target) break;
            while (i < j && sum >= target) {
                res = Math.min(j - i, res);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
