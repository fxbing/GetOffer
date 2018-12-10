package solution;
/* 题目描述:
 * 输入两个链表，找出它们的第一个公共结点。*/
public class Solution52 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        if (pHead1 == pHead2) {
            return pHead1;
        }
        ListNode a = pHead1;
        ListNode b = pHead2;
        int count1 = 1;
        int count2 = 1;
        while (a.next != null) {
            count1++;
            a = a.next;
        }
        while (b.next != null) {
            count2++;
            b = b.next;
        }
        if (count1 > count2) {
            while (count1-- != count2) {
                pHead1 = pHead1.next;
            }
        } else if (count1 < count2) {
            while (count2-- != count1) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
