package solution;

import java.util.ArrayList;

/* 题目描述：
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 * */
public class Solution40 {
	/* 解法一：
	 * 利用堆存储最小的K个数。可以使用PriorityQueue实现,时间复杂度O(nlogn)
	 * 适合处理海量数据
	 * 
	 * 解法二：
	 * 利用partition函数，时间复杂度O(n)
	 * */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (input == null || input.length < k || k < 1) {
			return res;
		}
		int index = partition(input, 0, input.length - 1);
		while (index != k - 1) {
			if (index > k - 1) {
				index = partition(input, 0, index - 1);
			} else {
				index = partition(input, index + 1, input.length - 1);
			}
		}
		for (int i = 0; i < k; i++) {
			res.add(input[i]);
		}
		return res;
	}

	public int partition(int[] input, int start, int end) {
		int tmp = input[end];
		int low = start, high = end;
		while (low < high) {
			while (low < high && input[low] <= tmp) {
				low++;
			}
			if (low < high) {
				input[high] = input[low];
				high--;
			}
			while (low < high && input[high] > tmp) {
				high--;
			}
			if (low < high) {
				input[low] = input[high];
				low++;
			}
		}
		input[high] = tmp;
		return high;
	}
}
