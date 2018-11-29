package solution;
/* 题目描述:
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */
public class Solution35 {
	/* 解法一：
	 * 利用map进行复制，时间复杂度O(n),空间复杂度O(n)。
	 * 解法二：
	 * 不用map，将每个节点的赋值先放在该节点的后面。如下：
	 * */
	public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode currentNode = pHead;
        while(currentNode != null){
            RandomListNode tmp = new RandomListNode(currentNode.label);
            tmp.next = currentNode.next;
            currentNode.next = tmp;
            currentNode = tmp.next;
        }
        currentNode = pHead;
        while(currentNode != null){
        	currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
        	currentNode = currentNode.next.next;
        }
        RandomListNode res = pHead.next;
        currentNode = pHead;
        while(currentNode != null){
        	RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return res;
    }

	static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
}
