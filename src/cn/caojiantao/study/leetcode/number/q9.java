package cn.caojiantao.study.leetcode.number;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 回文数
 */
public class q9 {

    public static void main(String[] args) {
        System.out.println();
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = 0;
        for (int n = x; n != 0; n /= 10) {
            int temp = res * 10 + n % 10;
            if (temp / 10 != res) return false;
            res = temp;
        }
        return x == res;
    }
}
