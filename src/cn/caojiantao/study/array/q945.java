package cn.caojiantao.study.array;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * 使数组唯一的最小增量
 */
public class q945 {

    public static void main(String[] args) {
        q945 q945 = new q945();
//        System.out.println(q945.minIncrementForUniqueV3(new int[]{1, 2, 2}));
//        System.out.println(q945.minIncrementForUniqueV3(new int[]{3, 2, 1, 2, 1, 7}));
        System.out.println(q945.minIncrementForUniqueV3(new int[]{2, 2, 2, 1}));
    }

    /**
     * set去重，暴力++（超时）
     */
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            while (set.contains(A[i])) {
                A[i]++;
                res++;
            }
            set.add(A[i]);
        }
        return res;
    }

    /**
     * 先排序，后面元素相比前面递增 1
     */
    public int minIncrementForUniqueV2(int[] A) {
        int res = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int add = A[i - 1] + 1;
                res += add - A[i];
                A[i] = add;
            }
        }
        return res;
    }

    /**
     * 计数排序
     */
    public int minIncrementForUniqueV3(int[] A) {
        if (A == null || A.length == 0) return 0;
        int res = 0;
        int[] nums = new int[80000];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : A) {
            nums[n]++;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        for (int i = min; i <= max; i++) {
            if (nums[i] > 1) {
                int step = nums[i] - 1;
                res += step;
                nums[i + 1] += step;
            }
        }
        int n = nums[max + 1];
        if (n > 1) {
            res += (n - 1) * n / 2;
        }
        return res;
    }
}
