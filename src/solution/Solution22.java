package solution;

/* 题目描述:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */
public class Solution22 {
	// 考察代码鲁棒性，注意边界条件及异常处理。
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode p = head;
		while (k-- != 0) {
			if (p == null) {
				return null;
			}
			p = p.next;
		}
		ListNode result = head;
		while (p != null) {
			p = p.next;
			result = result.next;
		}
		return result;
	}
}
