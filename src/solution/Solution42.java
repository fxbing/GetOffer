package solution;

/* 题目描述：
 * 给一个数组，返回它的最大连续子序列的和*/
public class Solution42 {
	/* 解法一：
	 * 遍历所有子序列，时间复杂度O(n2)
	 * */
	public int FindGreatestSumOfSubArray1(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int res = array[0];
		for (int i = 0; i < array.length; i++) {
			int max = array[i];
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				max = Math.max(sum, max);
			}
			res = Math.max(max, res);
		}
		return res;
	}
	/* 解法二：
	 * 如果之前的最大子序列之和为负数，则抛弃，时间复杂度O(n)
	 * */
	public int FindGreatestSumOfSubArray2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int res = array[0];
		int sum = 0;
		for (int i : array) {
			sum = Math.max(sum + i, i);
			res = Math.max(sum, res);
		}
		return res;
	}
	/* 解法三：
	 * 动态规划，时间复杂度O(n)
	 * */
	public int FindGreatestSumOfSubArray3(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] res = new int[array.length];
		res[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			res[i] = Math.max(res[i - 1] + array[i], array[i]);
		}
		int max = res[0];
		for (int i : res) {
			max = Math.max(max, i);
		}
		return max;
	}
}
