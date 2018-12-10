package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * */
public class Solution48 {
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, end = 1;
        int[] f = new int[s.length()];
        f[0] = 1;
        Set<Character> set = new HashSet<Character>();
        set.add(s.charAt(0));
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                while (start < end && s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start++));
                }
                start++;
            } else {
                set.add(s.charAt(end));
            }
            f[end] = end - start + 1;
            end++;
        }
        int res = 0;
        for (int i : f) {
            res = Math.max(res, i);
        }
        System.out.println(Arrays.toString(f));
        return res;
    }
	public static void main(String[] args) {
		lengthOfLongestSubstring("abcabcbb");
	}
}
