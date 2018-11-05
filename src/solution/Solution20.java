package solution;

/*题目描述：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *  */
public class Solution20 {
	/*
	 * 解题思路： 从前往后，按照模式依次匹配
	 */
	public boolean isNumeric(char[] str) {
		boolean result = false;
		int index = 0;
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		int tmp = scanUnsignedInteger(str, index);
		// 是否以整数开头
		result = tmp > index;
		index = tmp;
		if (index < str.length && str[index] == '.') {
			index++;
			tmp = scanUnsignedInteger(str, index);
			// 如果有小数点，只要保证小数点前面是整数或者小数点后面是无符号整数就可以
			result = result || tmp > index;
			index = tmp;
		}
		if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			if (index < str.length && (str[index] == '+' || str[index] == '-')) {
				index++;
			}
			tmp = scanUnsignedInteger(str, index);
			// 如果有指数要保证底数存在并且指数为整数
			result = result && tmp > index;
		}
		return result && tmp == str.length;
	}

	public int scanUnsignedInteger(char[] str, int index) {
		while (index < str.length && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index;
	}
}
