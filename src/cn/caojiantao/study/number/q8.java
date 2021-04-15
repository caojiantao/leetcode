package cn.caojiantao.study.number;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 字符串转换整数
 */
public class q8 {

    public static void main(String[] args) {
        q8 q8 = new q8();
        System.out.println(q8.myAtoi("2147483648"));
    }

    public int myAtoi(String s) {
        int num = 0, neg = 1;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flag) {
                if (c < '0' || c > '9') {
                    break;
                }
                int n = num * 10 + (c - '0');
                if (n / 10 != num) return neg < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                num = n;
            } else {
                if (c == ' ') {
                    continue;
                } else if (c == '-' || c == '+') {
                    flag = true;
                    if (c == '-') neg = -1;
                } else if (c < '0' || c > '9') {
                    break;
                } else {
                    num = c - '0';
                    flag = true;
                }
            }
        }
        int n = neg * num;
        if (neg * n != num) return Integer.MIN_VALUE;
        return neg * num;
    }
}
