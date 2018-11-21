package solution;

import java.util.ArrayList;

/*
 * ��Ŀ������
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * */
public class Solution32_1 {
	/*
	 * ����˼·��
	 * ʹ�ö��д洢��������⡣
	 * */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        res.add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove(0);
            if (tmp.left != null) {
                queue.add(tmp.left);
                res.add(tmp.left.val);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                res.add(tmp.right.val);
            }
        }
        return res;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}