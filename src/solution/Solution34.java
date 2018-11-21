package solution;

import java.util.ArrayList;

/* ��Ŀ������
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
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
