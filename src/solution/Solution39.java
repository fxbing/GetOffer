package solution;
/* ��Ŀ����:
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��*/
public class Solution39 {
	/* �ⷨһ��
	 * ���ÿ��������е�partition���������ҳ���λ����Ȼ���ж���λ���ǲ���Ҫ��Ľ����ʱ�临�Ӷȣ�O(n)
	 * �ⷨ����
	 * ���ü������ҵ����ִ����������֣�������ڣ���Ȼ���жϸ������ǲ���Ҫ��Ľ����
	 * ע�⣺
	 * ���ַ�������������Ҫ����һ���Ƿ����Ҫ����жϡ�
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
