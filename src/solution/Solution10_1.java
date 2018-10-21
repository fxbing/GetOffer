package solution;

/*
 * 题目描述：
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * */
public class Solution10_1 {
	/*
	 * 解题思路：
	 * 解法一：利用f(n)=f(n-1)+f(n-2)编写递归函数。 
	 * 解法二：动态规划，写法如下。  时间复杂度：O(n)
	 * 解法三：矩阵运算。https://blog.csdn.net/kuhuaishuxia/article/details/52217872  时间复杂度：O(logn)
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
