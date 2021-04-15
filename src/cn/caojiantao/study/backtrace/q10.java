package cn.caojiantao.study.backtrace;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 正则表达式匹配
 */
public class q10 {

    public static void main(String[] args) {
        q10 q10 = new q10();
        System.out.println(q10.isMatch("ab", ".*"));
        System.out.println(q10.isMatch("aab", "c*a*b"));
        System.out.println(q10.isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    /**
     * 普通递归
     */
    private boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();
        char p_char = p.charAt(j);
        boolean match = (i < s.length()) && (p_char == '.' || p_char == s.charAt(i));
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return isMatch(s, p, i, j + 2) || (match && isMatch(s, p, i + 1, j));
        } else {
            return match && isMatch(s, p, i + 1, j + 1);
        }
    }

    /**
     * 备忘录递归（动态规划）
     */
    private boolean isMatchV2(String s, String p, int i, int j, Boolean[][] dp) {
        if (dp[i][j] != null) return dp[i][j];
        boolean res;
        if (j == p.length()) {
            res = i == s.length();
        } else {
            char p_char = p.charAt(j);
            boolean match = (i < s.length()) && (p_char == '.' || p_char == s.charAt(i));
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                res = isMatchV2(s, p, i, j + 2, dp) || (match && isMatchV2(s, p, i + 1, j, dp));
            } else {
                res = match && isMatchV2(s, p, i + 1, j + 1, dp);
            }
        }
        dp[i][j] = res;
        return res;
    }
}
