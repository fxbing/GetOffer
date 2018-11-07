package solution;

/*��Ŀ������
 * ����һ��������ת��������������ı�ͷ��
 * */
public class Solution24 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		head = null;
		ListNode tmp;
		while (pre.next != null) {
			tmp = pre.next;
			pre.next = head;
			head = pre;
			pre = tmp;
		}
		pre.next = head;
		return pre;
	}
}
