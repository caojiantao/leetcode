package cn.caojiantao.study.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * 基本计算器
 */
public class q224 {

    public static void main(String[] args) {
        q224 q224 = new q224();
//        System.out.println(q224.calculate("1 + 2"));
//        System.out.println(q224.calculate(" 2-1 + 2 "));
//        System.out.println(q224.calculateV2("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(q224.calculateV2(" -1 -2 + 3"));
        System.out.println(q224.calculateV2("2147483647"));
    }

    /**
     * 双栈，操作栈，数据栈
     */
    public int calculate(String s) {
        Stack<Character> signStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int n = 0;
                while (true) {
                    n = n * 10 + (s.charAt(i) - '0');
                    if (i + 1 == s.length() || !Character.isDigit(s.charAt(i + 1))) break;
                    i++;
                }
                numberStack.add(n);
            } else if (c == ')') {
                char sign;
                while ((sign = signStack.pop()) != '(') {
                    calculate(numberStack, sign);
                }
            } else {
                if (c != '(' && !signStack.isEmpty() && signStack.peek() != '(') {
                    calculate(numberStack, signStack.pop());
                }
                signStack.add(c);
            }
        }
        while (!signStack.isEmpty()) calculate(numberStack, signStack.pop());
        return numberStack.pop();
    }

    /**
     */
    public int calculateV2(String s) {
        int res = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            switch (c) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                    break;
                case ')':
                    res = stack.pop() * res + stack.pop();
                    break;
                default:
                    int n = 0;
                    for (int j = i; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
                        n = n * 10 + (s.charAt(j) - '0');
                        i = j;
                    }
                    res += sign * n;
                    break;
            }
        }
        return res;
    }

    private void calculate(Stack<Integer> numberStack, char sign) {
        int b = numberStack.pop();
        int a = numberStack.isEmpty() ? 0 : numberStack.pop();
        int res = (sign == '+') ? a + b : a - b;
        numberStack.add(res);
    }
}
