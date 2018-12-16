package solution;

/*题目描述：
0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。
求出这个圈圈里剩下的最后一个数字。*/
public class Solution62 {
    public int LastRemaining_Solution(int n, int m) {
        /*
        约瑟夫环的公式是：
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