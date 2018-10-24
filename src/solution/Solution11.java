package solution;
/*
 *   ��Ŀ����:
 *   ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 *   ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 *   ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 *   NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *   */
public class Solution11 {
	/*
	 * �ⷨ��
	 * ���ֲ��ң�����Ҫע����������ظ�Ԫ�ص������
	 * */
	public int minNumberInRotateArray(int [] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}

        int start = 0;
        int end = nums.length - 1;
        // ���ų��ظ�Ԫ��
        while (nums[start] == nums[end] && start < end) {
			start++;
		}
        // ֱ����������������
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
