package cn.caojiantao.study.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 */
public class q22 {

    public static void main(String[] args) {
        q22 q22 = new q22();
        System.out.println(q22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
//        generateParenthesis("", n, result);
        generateParenthesis("", 3, 0, 0, result);
        return result;
    }

    /**
     * 暴力递归 2^2n
     */
    private void generateParenthesis(String path, int n, List<String> result) {
        if (path.length() == 2 * n) {
            if (isValid(path)) result.add(path);
            return;
        }
        generateParenthesis(path + "(", n, result);
        generateParenthesis(path + ")", n, result);
    }

    private boolean isValid(String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                result++;
            } else if (result > 0) {
                result--;
            } else {
                return false;
            }
        }
        return result == 0;
    }

    private void generateParenthesis(String path, int n, int open, int close, List<String> result) {
        if (path.length() == 2 * n) {
            System.out.println(path);
            result.add(path);
            return;
        }
        if (open < n) {
            generateParenthesis(path + '(', n, open + 1, close, result);
        }
        if (close < open) {
            generateParenthesis(path + ')', n, open, close + 1, result);
        }
    }
}
