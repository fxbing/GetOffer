package solution;

/* ��Ŀ����:
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007*/
public class Solution51 {
	public int InversePairs(int[] array) {
		if (array == null || array.length < 2) {
			return 0;
		}
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		return mergeCount(array, copy, 0, array.length - 1);
	}

	public static int mergeCount(int[] array, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = array[start];
			return 0;
		}
		int mid = (start + end) >> 1;
		int leftCount = mergeCount(copy, array, start, mid);
		int rightCount = mergeCount(copy, array, mid + 1, end);

		int i = mid;// i��ʼ��Ϊǰ������һ�����ֵ��±�
		int j = end;// j��ʼ��Ϊ�������һ�����ֵ��±�
		int index = end;// �������鸴�Ƶ���������һ�����ֵ��±�
		int count = 0;// ����--����Ե���Ŀ
		while (i >= start && j >= mid + 1) {
			if (array[i] > array[j]) {
				copy[index--] = array[i--];
				count += j - mid;
				if (count >= 1000000007)// ��ֵ��������
				{
					count %= 1000000007;
				}
			} else {
				copy[index--] = array[j--];
			}
		}
		for (; i >= start; i--) {
			copy[index--] = array[i];
		}
		for (; j >= mid + 1; j--) {
			copy[index--] = array[j];
		}
		return (leftCount + rightCount + count) % 1000000007;
	}
}
