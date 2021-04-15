package cn.caojiantao.study.division;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 搜索旋转排序数组
 */
public class q33 {

    public static void main(String[] args) {
        q33 q33 = new q33();
        System.out.println(q33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(q33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(q33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(q33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(q33.search(new int[]{1}, 0));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[start] <= nums[mid]) {
            int index = searchDivision(nums, start, mid, target);
            if (index != -1) return index;
            return search(nums, mid + 1, end, target);
        } else {
            int index = search(nums, start, mid, target);
            if (index != -1) return index;
            return searchDivision(nums, mid + 1, end, target);
        }
    }

    private int searchDivision(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) start = mid + 1;
        else end = mid - 1;
        return searchDivision(nums, start, end, target);
    }
}
