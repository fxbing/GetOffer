package solution;

/*
 * ��Ŀ������
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 * */
public class Solution10_1 {
	/*
	 * ����˼·��
	 * �ⷨһ������f(n)=f(n-1)+f(n-2)��д�ݹ麯���� 
	 * �ⷨ������̬�滮��д�����¡�  ʱ�临�Ӷȣ�O(n)
	 * �ⷨ�����������㡣https://blog.csdn.net/kuhuaishuxia/article/details/52217872  ʱ�临�Ӷȣ�O(logn)
	 * */
	public int Fibonacci(int n) {
        int a = 0,b = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = -1;
        for (int i = 2;i <= n;i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
