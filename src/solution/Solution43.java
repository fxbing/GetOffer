package solution;
/* 题目描述：
 * 从1到n整数中1出现的次数
 * */
public class Solution43 {
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
	    for (int i = 1; i <= n; i *= 10) {
	        int a = n / i,b = n % i;
	        //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
	        //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
	        count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
	    }
	    return count;
    }
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(100));
	}
}
