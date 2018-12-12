package solution;

/*
题目描述：
        给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
*/
public class Solution54 {
    int count = 1;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        TreeNode res = null;
        if (pRoot.left != null) {
            res = KthNode(pRoot.left, k);
        }
        if (res == null) {
            if (k == count++) {
                res = pRoot;
            }
        }
        if (res == null && pRoot.right != null) {
            res = KthNode(pRoot.right, k);
        }
        return res;
    }
}
