package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
/*
 * 题目描述：
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * */
public class Solution6 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
/*
 * 解法一：
 * 用栈做一次中间转换，先遍历链表，压入栈，然后弹栈得到最终结果。  时间复杂度：O(n) 空间复杂度：O(n)
 * */
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
		ArrayList res = new ArrayList<Integer>();
		ArrayDeque stack = new ArrayDeque<Integer>();
		ListNode p = listNode;
		while (p != null) {
			stack.push(p.val);
			p = p.next;
		}
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}
/*
 * 解法二：
 * 递归（本质仍然是使用栈），但是递归的鲁棒性不足，在需要递归较多层级的时候可能会爆栈。
 * */
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList res = new ArrayList<Integer>();
		if (listNode != null) {
			if (listNode.next != null) {
				res.addAll(printListFromTailToHead2(listNode.next));
			}
			res.add(listNode.val);
		}
		return res;
	}

}
