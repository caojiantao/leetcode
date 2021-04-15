package cn.caojiantao.study.number;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 阶乘后的零
 */
public class q172 {

    public static void main(String[] args) {
        q172 q172 = new q172();
        System.out.println(q172.trailingZeroes(3));
        System.out.println(q172.trailingZeroes(5));
        System.out.println(q172.trailingZeroes(13));
        System.out.println(q172.trailingZeroes(25));
        System.out.println(q172.trailingZeroes(30));
        System.out.println(q172.trailingZeroes(50));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
