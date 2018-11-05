package solution;
/* 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * */
public class Solution16 {
	/*解题方法
	 * 考虑底数为0，指数为负数的情况
	 * 使用二分法求解
	 * */
	public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        int count = 1;
        boolean tag = false;
        if (exponent == 0) {
            return 1;
        }
        else if (exponent < 0) {
            tag = true;
            exponent = -exponent;
        }
        double cur = base;
        while (2 * count < exponent) {
            cur *= cur;
            count *= 2;
        }
        count = exponent - count;
        while (count-- > 0) {
            cur *= base;
        }
        if (tag) {
            return 1 / cur;
        } else {
            return cur;
        }
    }
}
