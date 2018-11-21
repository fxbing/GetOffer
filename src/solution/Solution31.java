package solution;

import java.util.Stack;
/*
 * 题目描述：
 * 输入两个整数序列， 第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）*/
public class Solution31 {
	/* 解题思路：
	 * 仿照人为手工确定是否正确的办法考虑问题。
	 * */
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int length = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        int start = 0;
        while (popIndex < length) {
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
            start = pushIndex;
            while (pushIndex < length && pushA[pushIndex] != popA[popIndex]) {
                pushIndex++;
            }
            if (pushIndex == length) {
                return popIndex == length  ? true : false;
            }
            for (int i = start;i <= pushIndex;i++) {
                stack.push(pushA[i]);
            }
            pushIndex++;
        }
        return true;
    }
}
