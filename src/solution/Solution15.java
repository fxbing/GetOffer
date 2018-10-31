package solution;
/* 题目描述：
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class Solution15 {
	/*解法一： 共需要循环32次
	 * flag从1开始每次右移一位，判断当前位是否为1,。
	 * 注意：不能对n进行左移操作，因为当n为负数时，左移操作会对左边补1，造成死循环。
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
	/* 解法二： 有几个1就循环几次
	 * 最优解，(n - 1) & n代表将n中的最右边的1变成0
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
