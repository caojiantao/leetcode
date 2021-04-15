package cn.caojiantao.study.sliding.window;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 盛最多水的容器
 */
public class q11 {

    public static void main(String[] args) {
        q11 q11 = new q11();
        System.out.println(q11.maxArea(new int[]{1, 1}));
        System.out.println(q11.maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(q11.maxArea(new int[]{1, 2, 1}));
    }

    public int maxArea(int[] height) {
        if (height == null) return 0;
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
