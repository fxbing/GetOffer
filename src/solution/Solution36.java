package solution;
/* 题目描述:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * */
public class Solution36 {
	/* 解题方法：
	 * 先处理右边，从右往左，依次处理。
	 * */
	public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode res = root;
        while (res.left != null) {
            res = res.left;
        }
        
        TreeNode right = Convert(root.right);
        root.right = right;
        if (right != null) {
            right.left = root;
        }
        
        TreeNode left = Convert(root.left);
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = root;
            root.left = left;
        }
        return res;
    }
}
