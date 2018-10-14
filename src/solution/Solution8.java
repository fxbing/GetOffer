package solution;

/**
* 题目描述：
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
    
public class Solution8 {
	/*
	 * 解题思路：
	 * 先讨论存在右子树的情况，如果不存在右子树，则讨论父节点。
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
