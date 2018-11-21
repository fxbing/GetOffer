package solution;

/*��Ŀ����:
 * ���������Ķ�����������任ΪԴ�������ľ���
 * */
public class Solution27 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public void Mirror(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if (root.right != null) {
			Mirror(root.right);
		}
		if (root.left != null) {
			Mirror(root.left);
		}
	}
}
