package solution;
/*
题目描述:
一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
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
