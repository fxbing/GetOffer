package solution;
/*
 *   题目描述:
 *   把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *   输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *   例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 *   NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *   */
public class Solution11 {
	/*
	 * 解法：
	 * 二分查找，但是要注意数组包含重复元素的情况。
	 * */
	public int minNumberInRotateArray(int [] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}

        int start = 0;
        int end = nums.length - 1;
        // 先排除重复元素
        while (nums[start] == nums[end] && start < end) {
			start++;
		}
        // 直接是有序数组的情况
        if (nums[start] <= nums[end]) {
			return nums[start];
		}
        while (start + 1 < end) {
			int mid = start + (end - start)/2;
			if (nums[mid] < nums[start]) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
        return Math.min(nums[start], nums[end]);
    }
}
