package solution;

/*��Ŀ������
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * */
public class Solution25 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode result;
		if (list1.val <= list2.val) {
			result = list1;
			result.next = Merge(list1.next, list2);
		} else {
			result = list2;
			result.next = Merge(list1, list2.next);
		}
		return result;
	}
}
