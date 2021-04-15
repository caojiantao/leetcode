package cn.caojiantao.study.number;

/**
 * https://leetcode-cn.com/problems/add-digits/
 * 各位相加
 */
public class q258 {

    public static void main(String[] args) {
        q258 q258 = new q258();
        System.out.println(q258.addDigits(0));
        System.out.println(q258.addDigits(3));
        System.out.println(q258.addDigits(9));
        System.out.println(q258.addDigits(25));
        System.out.println(q258.addDigits(567));

    }

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
