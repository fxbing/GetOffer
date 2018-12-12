package solution;

/*
��Ŀ������
        ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬��5��3��7��2��4��6��8���У��������ֵ��С˳�����С����ֵΪ4��
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
