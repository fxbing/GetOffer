package solution;

import java.util.Stack;

/*
 * 题目描述:
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。*/
public class Solution30 {
	Stack<Integer> data = new Stack<>();
	// 通过辅助栈记录最小值。
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
