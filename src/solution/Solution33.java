package solution;
/* 题目描述:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/
public class Solution33 {
	/* 解题思路：
	 * 分治法
	 * */
	public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        return helper(sequence, 0, sequence.length);
    }
    public static boolean helper(int[] nums, int start, int end){
        if(end - start <= 2){
            return true;
        }
        int root = nums[end - 1];
        int mid = end - 1;
        for(int i = start;i < end;i++){
            if(mid == end - 1 && nums[i] > root){
                mid = i;
            }
            if(mid != end - 1 && nums[i] < root){
                return false;
            }
        }
        return helper(nums, start, mid) && helper(nums, mid, end -1);
    }
}
