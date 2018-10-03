package solution;
/*
 * ��Ŀ������
 * ��Ŀ����һ������Ϊn+1����������������ֶ���1��n�ķ�Χ�ڣ�����������������һ���������ظ��ġ�
 * ���ҳ�����������һ���ظ������֣��������޸���������顣
 * ���磬������볤��Ϊ8������{2, 3, 5, 4, 3, 2, 6, 7}����ô��Ӧ��������ظ�������2����3��
 * */
public class Solution3_2 {

	/*
	 * ���ⷽ����(��Ҫ�ǿ��ǿռ临�Ӷ����Ȼ���ʱ�临�Ӷ�����)
	 * 1.��������Ϊn�����飬�����������鲢�����Ӧ�±ֱ꣬���ҵ��ظ�Ԫ�ء�                ʱ�临�Ӷȣ�O(n)       �ռ临�Ӷȣ�O(n)
	 * 2.���ֲ��ң����½ⷨ��                                                                                                           ʱ�临�Ӷȣ�O(nlogn)   �ռ临�Ӷȣ�O(1)   ʱ�临�Ӷ������⣿����
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
