package solution;
/* 题目描述：
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 *  习惯上我们把1当做是第一个丑数。
 *  求按从小到大的顺序的第N个丑数。
 *  */
public class Solution49 {
	public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int i = 1;
        while (i < index) {
            ugly[i] = Math.min(factor2, Math.min(factor3, factor5));
            if (factor2 == ugly[i]) {
                factor2 = 2 * ugly[++index2];
            }
            if (factor3 == ugly[i]) {
                factor3 = 3 * ugly[++index3];
            }
            if (factor5 == ugly[i]) {
                factor5 = 5 * ugly[++index5];
            }
            i++;
        }
        return ugly[index - 1];
    }
}
