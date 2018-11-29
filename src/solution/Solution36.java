package solution;
/* ��Ŀ����:
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * */
public class Solution36 {
	/* ���ⷽ����
	 * �ȴ����ұߣ������������δ���
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
