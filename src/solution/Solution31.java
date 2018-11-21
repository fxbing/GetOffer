package solution;

import java.util.Stack;
/*
 * ��Ŀ������
 * ���������������У� ��һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�*/
public class Solution31 {
	/* ����˼·��
	 * ������Ϊ�ֹ�ȷ���Ƿ���ȷ�İ취�������⡣
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
