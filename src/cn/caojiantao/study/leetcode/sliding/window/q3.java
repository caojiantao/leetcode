package cn.caojiantao.study.leetcode.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 */
public class q3 {

    public static void main(String[] args) {
        q3 q3 = new q3();
        System.out.println(q3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(q3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(q3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(q3.lengthOfLongestSubstring(""));
        System.out.println(q3.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null) return 0;
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            Integer hint = map.getOrDefault(c, -1);
            if (hint >= i) {
                res = Math.max(res, j - i);
                i = hint + 1;
            }
            map.put(c, j++);
        }
        res = Math.max(res, j - i);
        return res;
    }
}
