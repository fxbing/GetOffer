package solution;

/*  题目描述:
 *  地上有一个m行和n列的方格。
 *  一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *  请问该机器人能够达到多少个格子？
 */	
public class Solution13 {
	/* 解题方法：
	 * 回溯法，但是这道题是求计数结果，visited标记为1之后不需要再在递归回来的时候改为0.
	 * */
	public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[] visited = new int[rows * cols];
        int res = helper(threshold, rows, cols, 0, 0, visited);
        return res;
    }
    public int helper(int threshold, int rows, int cols, int row, int col, int[] visited) {
        if (row < 0 || col < 0 || row == rows || col == cols || visited[row * cols + col] == 1 || !check(threshold, row, col)) {
            return 0;
        }
        visited[row * cols + col] = 1;
        return 1 + helper(threshold, rows, cols, row + 1, col, visited) +
            helper(threshold, rows, cols, row - 1, col, visited) +
            helper(threshold, rows, cols, row, col + 1, visited) +
            helper(threshold, rows, cols, row, col - 1, visited);
    }
    public boolean check(int threshold, int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum <= threshold;
    }
}
