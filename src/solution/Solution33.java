package solution;
/* ��Ŀ����:
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��*/
public class Solution33 {
	/* ����˼·��
	 * ���η�
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
