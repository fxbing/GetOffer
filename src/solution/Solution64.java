package solution;
/*
��Ŀ������
��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
*/
public class Solution64 {
    public int Sum_Solution(int n) {
        int sum = n;
        // n > 0��Ϊ��ȷ����n<=0ʱ��ִֻ��ǰ�棬�������½��еݹ顣
        boolean tag = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
