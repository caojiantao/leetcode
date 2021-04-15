package cn.caojiantao.study.leetcode.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 最长公共前缀
 */
public class q14 {

    public static void main(String[] args) {
        q14 q14 = new q14();
        System.out.println(q14.longestCommonPrefix(new String[]{""}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; ; i++) {
            char pre = 0;
            int j = 0;
            for (; j < strs.length && i < strs[j].length(); j++) {
                char c = strs[j].charAt(i);
                if (j == 0) pre = c;
                if (c != pre) {
                    break;
                }
            }
            if (j == strs.length) {
                builder.append(pre);
            } else {
                break;
            }
        }
        return builder.toString();
    }
}
