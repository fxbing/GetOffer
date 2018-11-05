package solution;

/*题目描述:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 *  在本题中，匹配是指字符串的所有字符匹配整个模式。
 *  例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
*/
public class Solution19 {
	/*
	 * 解题方法： 分情况讨论（有无*），递归。 如果递归爆栈，考虑使用动态规划。
	 */
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return helper(str, pattern, 0, 0);
	}

	public boolean helper(char[] str, char[] pattern, int index1, int index2) {
		if (index1 == str.length && index2 == pattern.length) {
			return true;
		} else if (index1 < str.length && index2 == pattern.length) {
			return false;
		}
		if (index2 + 1 < pattern.length && pattern[index2 + 1] == '*') {
			if (index1 < str.length && (pattern[index2] == '.' || str[index1] == pattern[index2])) {
				return helper(str, pattern, index1, index2 + 2) ||  //跳过*
					   helper(str, pattern, index1 + 1, index2) ||  //用*匹配一次（后面可能还有相同的字母）
					   helper(str, pattern, index1 + 1, index2 + 2);//用*匹配一次（后面没有相同的字母）
			} else {
				return helper(str, pattern, index1, index2 + 2);
			}
		} else {
			if (index1 < str.length && (pattern[index2] == '.' || str[index1] == pattern[index2])) {
				return helper(str, pattern, index1 + 1, index2 + 1);
			} else {
				return false;
			}
		}
	}
}
