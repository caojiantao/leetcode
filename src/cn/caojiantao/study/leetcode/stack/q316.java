package cn.caojiantao.study.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 去除重复字母
 */
public class q316 {

    public static void main(String[] args) {
        q316 q316 = new q316();
        System.out.println(q316.removeDuplicateLetters("bcabc"));
        System.out.println(q316.removeDuplicateLetters("cbacdcbc"));
        System.out.println(q316.removeDuplicateLetters("abacb"));
        System.out.println(q316.removeDuplicateLetters("edebbed"));
    }

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
            map.put(c, map.get(c) - 1);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.insert(0, stack.pop());
        return builder.toString();
    }
}
