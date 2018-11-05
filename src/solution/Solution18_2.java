package solution;
/*  ��Ŀ����
 *  ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 *  ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
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
