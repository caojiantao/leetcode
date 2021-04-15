package cn.caojiantao.study.leetcode.dynamic;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 */
public class q5 {

    public static void main(String[] args) {
        q5 q5 = new q5();
        long l = System.currentTimeMillis();
        System.out.println(q5.longestPalindrome("a"));
        System.out.println(System.currentTimeMillis() - l);
    }

    public String longestPalindrome(String s) {
        s = Arrays.stream(s.split("")).collect(Collectors.joining("#", "#", "#"));
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int len = 0; i - len >= 0 && i + len < s.length(); len++) {
                if (s.charAt(i - len) != s.charAt(i + len)) break;
                int start = i - len, end = i + len, curLen = end - start + 1;
                if (curLen > res.length()) res = s.substring(start, end + 1);
            }
        }
        return res.replaceAll("#", "");
    }

    /**
     * 动态规划
     */
    public String longestPalindromeV2(String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                boolean match = s.charAt(i) == s.charAt(i + l);
                if (l == 0) {
                    dp[i][i] = true;
                } else if (l == 1) {
                    dp[i][i + l] = match;
                } else {
                    dp[i][i + l] = match && dp[i + 1][i + l - 1];
                }
                if (dp[i][i + l] && l + 1 > res.length()) {
                    res = s.substring(i, i + l + 1);
                }
            }
        }
        return res;
    }
}
