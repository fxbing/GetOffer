package solution;

/* ��Ŀ����:
 * ����һ����������������е�����k����㡣
 * */
public class Solution22 {
	// �������³���ԣ�ע��߽��������쳣����
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
