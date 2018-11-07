package solution;

/* ��Ŀ����:
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
 * ��ps������Լ��������������һ�������ӽṹ��
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

	// �ҵ�ֵ��ȵĸ��ڵ�֮��root1���Ըýڵ�Ϊ��������ʱ�����root2
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
