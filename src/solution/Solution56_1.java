package solution;
/*
��Ŀ����:
һ�����������������������֮�⣬���������ֶ�������ż���Ρ���д�����ҳ�������ֻ����һ�ε����֡�
*/
public class Solution56_1 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int n = 0;
        for (int i : array) {
            n = n ^ i;
        }
        int lastBit = n - (n & (n - 1));
        for (int i : array) {
            if ((lastBit & i) == 0) {
                num1[0] = num1[0] ^ i;
            } else {
                num2[0] = num2[0] ^ i;
            }
        }
    }
}
