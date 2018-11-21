package solution;

import java.util.Stack;

/*
 * ��Ŀ����:
 * ����ջ�����ݽṹ��
 * ���ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������*/
public class Solution30 {
	Stack<Integer> data = new Stack<>();
	// ͨ������ջ��¼��Сֵ��
	Stack<Integer> min = new Stack<>();

	public void push(int node) {
		data.push(node);
		if (min.isEmpty()) {
			min.push(node);
		} else {
			min.push(Math.min(min.peek(), node));
		}
	}

	public void pop() {
		data.pop();
		min.pop();
	}

	public int top() {
		return data.peek();
	}

	public int min() {
		return min.peek();
	}

}
