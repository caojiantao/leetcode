package cn.caojiantao.study.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 字符串中的第一个唯一字符
 */
public class q387 {

    public int firstUniqChar(String s) {
        if (s == null) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharV2(String s) {
        // 你可以假定该字符串只包含小写字母。
        if (s == null) return -1;
        int res = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i != -1 && i == s.lastIndexOf(c)) {
                res = Math.min(i, res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
