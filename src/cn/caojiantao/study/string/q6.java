package cn.caojiantao.study.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * Z字形变换
 */
public class q6 {

    public static void main(String[] args) {
        q6 q6 = new q6();
        System.out.println(q6.convert("A", 1));
    }

    /**
     * 逐行 StringBuilder 排序，最后汇总
     */
    public String convert(String s, int numRows) {
        if (s == null || numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int curRow = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) flag = -flag;
            curRow += flag;
        }
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return builder.toString();
    }

    /**
     * 逐行遍历，坐标计算
     */
    public String convertV2(String s, int numRows) {
        if (s == null || numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                builder.append(s.charAt(j));
                j = j + (numRows - 1 - j % (numRows - 1)) * 2;
            }
        }
        return builder.toString();
    }
}
