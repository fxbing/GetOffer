package solution;
/* ��Ŀ������
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * */
public class Solution15 {
	/*�ⷨһ�� ����Ҫѭ��32��
	 * flag��1��ʼÿ������һλ���жϵ�ǰλ�Ƿ�Ϊ1,��
	 * ע�⣺���ܶ�n�������Ʋ�������Ϊ��nΪ����ʱ�����Ʋ��������߲�1�������ѭ����
	 * */
	public int NumberOf1_1(int n) {
        int res = 0;
        int flag = 1;
        while(flag != 0) {
            if((n & flag) != 0) {
                res++;
            }
            flag = flag<<1;
        }
        return res;
    }
	/* �ⷨ���� �м���1��ѭ������
	 * ���Ž⣬(n - 1) & n����n�е����ұߵ�1���0
	 * */
    public int NumberOf1_2(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n = (n - 1) & n;
        }
        return res;
    }
}
