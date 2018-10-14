package solution;

/**
* ��Ŀ������
* ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
* ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
*/
    
public class Solution8 {
	/*
	 * ����˼·��
	 * �����۴��������������������������������������۸��ڵ㡣
	 * */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) {
            return null;
        }
        
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        else if (pNode.next != null) {
            while (pNode.next != null && pNode != pNode.next.left) {
                pNode = pNode.next;
            }
            return pNode.next;
        }
        return null;
    }
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
}
