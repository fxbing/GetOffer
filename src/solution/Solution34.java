package solution;

import java.util.ArrayList;

/* 题目描述：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * */
public class Solution34 {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        if(root.val == target && root.left == null && root.right == null){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(target);
            res.add(tmp);
            return res;
        } else {
            if(root.left == null && root.right == null){
                return null;
            }
            ArrayList<ArrayList<Integer>> left = null;
            ArrayList<ArrayList<Integer>> right = null;
            if(root.left != null){
                left = FindPath(root.left, target - root.val);
            }
            if(root.right != null){
                right = FindPath(root.right, target - root.val);
            }
            if(left != null){
                res.addAll(left);
            }
            if(right != null){
                res.addAll(right);
            }
            for(ArrayList<Integer> each : res){
                each.add(root.val);
            }
        }
        return res;
    }

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		
		public TreeNode(int val) {
			this.val = val;
			
		}
		
	}
}
