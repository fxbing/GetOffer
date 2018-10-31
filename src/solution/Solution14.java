package solution;
/* 题目要求：
 * 给你一根长度为n的绳子，请把绳子剪成m段（m , n ）都是正整数，（n>1&m>1）
 * 每段绳子的长度为k[0],k[1],k[2],...,k[m]。请问k[0]k[1]k[2]...k[m]的最大值。
 * 例如绳子是长度为8，我们把它剪成的长度分别为2,3,3的三段，此时得到的最大的乘积是18。
 * */
public class Solution14 {
	/*
	 * 解法一：
	 * 动态规划
	 * */
	int maxProductAfterCutting1(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		int[] products = new int[length + 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;//此处注意，长度小于4的情况都在前面返回了，这里的products[3]并不是长度为3的结果
		
		int max = 0;
		for(int i = 4;i <= length;i++) {
			max = 0;
			for(int j = 1;j <= i/2;j++) {
				max = Math.max(max, products[j] * products[i - j]);
			}
			products[i] = max;
		}
		return products[length];
	}
	/*解法二：
	 * 贪心算法
	 * */
	int maxProductAfterCutting2(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// 尽可能多地减去长度为3的绳子段
		int timesOf3 = length / 3;
		// 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。改为剪成2*2的两段
		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		int timesOf2 = (length - timesOf3 * 3) / 2;
		return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
	}
}
