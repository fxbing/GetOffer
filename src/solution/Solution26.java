package solution;

/* 题目描述:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * */
public class Solution26 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		boolean result = false;
		if (root1.val == root2.val) {
			result = helper(root1, root2);
		}
		if (!result) {
			result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
		}
		return result;
	}

	// 找到值相等的根节点之后看root1中以该节点为根的子树时候包含root2
	boolean helper(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null || root1.val != root2.val) {
			return false;
		}
		return helper(root1.left, root2.left) && helper(root1.right, root2.right);
	}
}
