package cn.caojiantao.study.leetcode.number;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * 整数反转
 */
public class q7 {

    public static void main(String[] args) {
        q7 q7 = new q7();
        System.out.println(q7.reverseV2(123456789));
    }

    /**
     * 反转字符串 parseInt
     */
    public int reverse(int x) {
        String str = x < 0 ? "-" : "";
        String num = Math.abs(x) + "";
        StringBuilder builder = new StringBuilder();
        for (char c : num.toCharArray()) {
            builder.append(c);
        }
        str += builder.reverse();
        int res = 0;
        try {
            res = Integer.parseInt(str);
        } catch (Exception ignore) {
        }
        return res;
    }

    public int reverseV2(int x) {
        int res = 0, neg = x < 0 ? -1 : 1;
        x *= neg;
        while (x != 0) {
            int n = res;
            n *= 10;
            n += x % 10;
            if (n / 10 != res) return 0;
            res = n;
            x /= 10;
        }
        return neg * res;
    }
}