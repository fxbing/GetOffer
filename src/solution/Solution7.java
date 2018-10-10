package solution;

public class Solution7 {
	/*
	 * ��Ŀ����:
	 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
	 * ���������ǰ���������������Ľ���ж������ظ������֡�
	 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
	 * */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	/*
	 * �ⷨһ��
	 * ���η������Ҹ��ڵ㣬Ȼ��ݹ鴦����������
	 * */
	public static TreeNode helper(int [] pre, int start1, int end1, int [] in, int start2, int end2) {
        if (start1 + 1 == end1) {
            return new TreeNode(pre[start1]);
        }
        
        int cur = pre[start1];
        TreeNode res = new TreeNode(cur);
        int leftLength = 0;
        while (in[start2 + leftLength] != cur) {
            ++leftLength;
        }
        if (leftLength != 0) {
            res.left = helper(pre, start1 + 1, start1 + leftLength + 1, in, start2, start2 + leftLength);
        }
        else {
            res.left = null;
        }
        if (leftLength  < end1 - start1 - 1) {
            res.right = helper(pre, start1 + leftLength + 1, end1, in, start2 + leftLength + 1, end2);
        }
        else {
            res.right = null;
        }
        return res;
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length == 0) {
            return null;
        }
        return helper(pre, 0, pre.length, in, 0, in.length);
    }
    public static void main(String[] args) {
		reConstructBinaryTree(new int[]{1,2,4,3,5,6}, new int[]{4,2,1,5,3,6});
	}
}
