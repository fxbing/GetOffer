package solution;
/* 题目描述：
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 * */
public class Solution17 {
	/*
	 * 解法一：模拟字符串
	 * 解法二：递归求全排列
	 * */
	void Print1ToMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		helper(number, n, 0);
	}
	void helper(char[] number, int length, int index) {
		if (index > length - 1) {
			PrintNumber(number);
			return;
		}
		for(int i = 0;i < 10;i++) {
			number[index] = (char) (i + '0');
			helper(number, length, index + 1);
		}
	}
	void PrintNumber(char[] number) {
		String string = new String(number);
		int start = 0;
		while (string.charAt(start) == '0') {
			start++;
		}
		System.out.println(string.substring(start));
	}
}
