package cn.caojiantao.study.leetcode.sliding.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和
 */
public class q15 {

    public static void main(String[] args) {
        q15 q15 = new q15();
        System.out.println(q15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(q15.threeSum(new int[]{}));
        System.out.println(q15.threeSum(new int[]{0}));
        System.out.println(q15.threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(q15.threeSum(new int[]{1, -1, -1, 0}));
        System.out.println(q15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            for (int l = i + 1, r = nums.length - 1; l < r; ) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] == target) {
                    List<Integer> part = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(part);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;r--;
                } else {
                    r--;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}
