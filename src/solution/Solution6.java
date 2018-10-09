package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
/*
 * ��Ŀ������
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
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
 * �ⷨһ��
 * ��ջ��һ���м�ת�����ȱ�������ѹ��ջ��Ȼ��ջ�õ����ս����  ʱ�临�Ӷȣ�O(n) �ռ临�Ӷȣ�O(n)
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
 * �ⷨ����
 * �ݹ飨������Ȼ��ʹ��ջ�������ǵݹ��³���Բ��㣬����Ҫ�ݹ�϶�㼶��ʱ����ܻᱬջ��
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
