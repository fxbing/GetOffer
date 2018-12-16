package solution;

/*��Ŀ������
0, 1, �� , n-1 �� n �������ų�һ��ȦȦ�������� 0 ��ʼÿ�δ�Բ����ɾ���� m �����֡�
������ȦȦ��ʣ�µ����һ�����֡�*/
public class Solution62 {
    public int LastRemaining_Solution(int n, int m) {
        /*
        Լɪ�򻷵Ĺ�ʽ�ǣ�
        f(n, m) = 0                   (n = 1)
        f(n, m) = [f(n-1, m) +m] % n  (n > 1)
        */
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}