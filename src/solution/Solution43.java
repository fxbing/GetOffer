package solution;
/* ��Ŀ������
 * ��1��n������1���ֵĴ���
 * */
public class Solution43 {
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
	    for (int i = 1; i <= n; i *= 10) {
	        int a = n / i,b = n % i;
	        //֮���Բ�8������Ϊ����λΪ0����a/10==(a+8)/10��
	        //����λ>=2����8�������λλ��Ч����ͬ��(a/10+1)
	        count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
	    }
	    return count;
    }
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(100));
	}
}
