package solution;
/*
题目描述:
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/
public class Solution55_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDeepth(root) != -1;
    }
    public int getDeepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDeepth(root.left);
        if (left != -1) {
            int right = getDeepth(root.right);
            if (right == -1 || Math.abs(left - right) > 1) {
                return -1;
            } else {
                return Math.max(left, right) + 1;
            }
        } else {
            return -1;
        }
    }
}
