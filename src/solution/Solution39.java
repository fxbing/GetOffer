package solution;
/* 题目描述:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。*/
public class Solution39 {
	/* 解法一：
	 * 利用快速排序中的partition函数，先找出中位数，然后判断中位数是不是要求的结果。时间复杂度：O(n)
	 * 解法二：
	 * 利用计数，找到出现次数最多的数字（如果存在），然后判断该数字是不是要求的结果。
	 * 注意：
	 * 两种方法求出结果后都需要进行一次是否符合要求的判断。
	 * */
	public static int MoreThanHalfNum_Solution(int [] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int res = array[0];
		int count = 0;
        for (int i : array) {
        	if (count == 0) {
        		res = i;
        	}
        	if (res == i) {
				count++;
			} else {
				count--;
			}
        }
        count = 0;
        for (int i : array) {
        	if (i == res) {
				count++;
			}
        }
        return count > array.length >> 1 ? res : 0;
    }
}
