package solution;
/*题目描述:
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * */
public class Solution23 {
	/*解题方法：
	 * https://www.cnblogs.com/wxisme/p/5834383.html
	 * */
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }
        ListNode ahead = pHead;
        ListNode behind = pHead;
        do{
            ahead = ahead.next.next;
            behind = behind.next;
        }while(ahead != null && ahead.next != null && behind != ahead);
        if(behind != null && behind == ahead){
            ListNode result = pHead;
            while(result != ahead){
                result = result.next;
                ahead = ahead.next;
            }
            return result;
        } else{
            return null;
        }
    }
}
