package solution;
/* ��Ŀ������
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 *  ϰ�������ǰ�1�����ǵ�һ��������
 *  �󰴴�С�����˳��ĵ�N��������
 *  */
public class Solution49 {
	public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int i = 1;
        while (i < index) {
            ugly[i] = Math.min(factor2, Math.min(factor3, factor5));
            if (factor2 == ugly[i]) {
                factor2 = 2 * ugly[++index2];
            }
            if (factor3 == ugly[i]) {
                factor3 = 3 * ugly[++index3];
            }
            if (factor5 == ugly[i]) {
                factor5 = 5 * ugly[++index5];
            }
            i++;
        }
        return ugly[index - 1];
    }
}
