package solution;
/*
 * 题目描述：
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 * */
public class Solution3_2 {

	/*
	 * 解题方案：(主要是考虑空间复杂度优先还是时间复杂度优先)
	 * 1.创建长度为n的数组，遍历输入数组并存入对应下标，直到找到重复元素。                时间复杂度：O(n)       空间复杂度：O(n)
	 * 2.二分查找，如下解法：                                                                                                           时间复杂度：O(nlogn)   空间复杂度：O(1)   时间复杂度有问题？？？
	 * */
	public int getDuplication(int[] numbers, int length) {
		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		
		int start = 1;
		int end = length - 1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			int count = countRange(numbers, length, start, mid);
			if (end == start) {
				if (count > 1) {
					return start;
				}
				else {
					break;
				}
			}
			if (count > (mid - start + 1)) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}
	public static int countRange(int[] numbers, int length, int start, int end) {
		if (numbers == null) {
			return 0;
		}
		int count = 0;
		for (int i : numbers) {
			if (i >= start && i <= end) {
				++count;
			}
		}
		return count;
	}
}
