package cn.caojiantao.study.number;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * 字符串相乘
 */
public class q43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] nums = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int sum = nums[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                nums[i + j + 1] = sum % 10;
                nums[i + j] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] == 0) continue;
            builder.append(nums[i]);
        }
        return builder.toString();
    }
}
