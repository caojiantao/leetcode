package cn.caojiantao.study.sliding.window;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 */
public class q42 {

    public static void main(String[] args) {
        q42 q42 = new q42();
        System.out.println(q42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(q42.trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(q42.trap(new int[]{}));
        System.out.println(q42.trap(new int[]{0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2}));
    }

    public int trap(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        int m = 0, n = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                m = Math.max(height[i], m);
                res += m - height[i];
                i++;
            } else {
                n = Math.max(height[j], n);
                res += n - height[j];
                j--;
            }
        }
        return res;
    }
}
