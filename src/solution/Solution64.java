package solution;
/*
题目描述：
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
*/
public class Solution64 {
    public int Sum_Solution(int n) {
        int sum = n;
        // n > 0是为了确保当n<=0时，只执行前面，不再向下进行递归。
        boolean tag = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
