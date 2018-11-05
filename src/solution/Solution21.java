package solution;

/*题目描述：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class Solution21 {
	/*
	 * 解题方法： 此题属于排序问题，主要是根据是否稳定来选择排序算法。 如果不要求相对位置，可以用类似快排的思想。
	 * 如果要求相对位置，由于快排不稳定，故采用类似冒泡法的思想。
	 */
	public void reOrderArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
					int tmp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
}
