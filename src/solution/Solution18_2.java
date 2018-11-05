package solution;
/*  题目描述
 *  在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *  */
public class Solution18_2 {
	class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = pHead;
        boolean delete = false;
        ListNode start = dummyNode;
        ListNode end = pHead;
        while(end.next != null) {
            if(end.val == end.next.val){
                delete = true;
                end = end.next;
            } else {
                if(delete){
                    start.next = end.next;
                    delete = false;
                } else{
                    start = end;
                }
                end = end.next;
            }
        }
        if(delete){
            start.next = null;
        }
        return dummyNode.next;
    }
}
