package solution;
/*
 * 题目描述：
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */
public class Solution4 {
	/*
	 * 解题思路：
	 * 此题重点考虑查找的起点，如果从左上角或者右下角开始查找，无法根据当前位置数据和target的比较来判断向哪个个方向走。
	 * 如果从左下角或者右上角开始查找，就可以通过当前位置数据和target的比较来决定移动的方向。
	 * 以下代码就是从右上角开始移动的方案：
	 * 时间复杂度：O(m+n)   空间复杂度：O(1)
	 * */
	public boolean Find(int target, int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
