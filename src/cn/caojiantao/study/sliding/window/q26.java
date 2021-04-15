package cn.caojiantao.study.sliding.window;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 删除排序数组中的重复项
 */
public class q26 {

    public static void main(String[] args) {
        q26 q26 = new q26();
        System.out.println(q26.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(q26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; i++) {
            nums[i] = nums[j++];
            while (j < nums.length && nums[i] == nums[j]) j++;
        }
        return i;
    }
}
