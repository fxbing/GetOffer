package solution;
/* 题目描述：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * */
public class Solution50_1 {
	public static int FirstNotRepeatingChar(String str) {
        // -1:没有出现过  -2：出现过多次  正数：出现过一次的索引位置
        int[] upperLetter = new int[26];
        int[] lowerLetter = new int[26];
        for (int i = 0;i < 26;i++){
            upperLetter[i] = -1;
            lowerLetter[i] = -1;
        }
        char[] chs = str.toCharArray();
        for (int i = 0; i < str.length();i++) {
            char c = chs[i];
            if (c == 'K') {
				System.out.println();
			}
            if (c - 'a' >= 0 && c - 'a' < 26) {
                if (lowerLetter[c - 'a'] == -1) {
                    lowerLetter[c - 'a'] = i;
                } else if (lowerLetter[c - 'a'] != -2) {
                    lowerLetter[c - 'a'] = -2;
                }
            } else {
                if (upperLetter[c - 'A'] == -1) {
                    upperLetter[c - 'A'] = i;
                } else if (upperLetter[c - 'A'] != -2) {
                    upperLetter[c - 'A'] = -2;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < 26;i++){
            res = upperLetter[i] >= 0 ? Math.min(res, upperLetter[i]) : res;
            res = lowerLetter[i] >= 0 ? Math.min(res, lowerLetter[i]) : res;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FirstNotRepeatingChar("SKQmoiGXAJWdqxkWmyyemQfSPQFQFwevDWfToOcZMFLYookJkaTibswKDCq"));
	}

}
