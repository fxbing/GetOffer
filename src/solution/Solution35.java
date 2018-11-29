package solution;
/* ��Ŀ����:
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * */
public class Solution35 {
	/* �ⷨһ��
	 * ����map���и��ƣ�ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)��
	 * �ⷨ����
	 * ����map����ÿ���ڵ�ĸ�ֵ�ȷ��ڸýڵ�ĺ��档���£�
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
