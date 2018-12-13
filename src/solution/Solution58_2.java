package solution;
/*
题目描述:
汇编语言中有一种移位指令叫做循环左移（ROL），
现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
*/
public class Solution58_2 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() < 2) {
            return str;
        }
        if (n > str.length()) {
            n %= str.length();
        }
        StringBuffer left = new StringBuffer(str.substring(0, n));
        StringBuffer right = new StringBuffer(str.substring(n));
        return left.reverse().append(right.reverse()).reverse().toString();
    }
}
