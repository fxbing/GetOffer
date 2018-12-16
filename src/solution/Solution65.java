package solution;
/*
题目描述：
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
*/
public class Solution65 {
    /*加法运算分三步：
    * 1：相加不进位，得到sum
    * 2：只算进位，得到carry
    * 3:1.2结果相加，循环知道没有进位，得到结果
    * */

    public int Add(int num1,int num2) {
        int sum,carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
