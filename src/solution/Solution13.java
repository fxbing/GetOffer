package solution;

/*  ��Ŀ����:
 *  ������һ��m�к�n�еķ���
 *  һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 *  ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 *  ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
 *  ���ʸû������ܹ��ﵽ���ٸ����ӣ�
 */	
public class Solution13 {
	/* ���ⷽ����
	 * ���ݷ������������������������visited���Ϊ1֮����Ҫ���ڵݹ������ʱ���Ϊ0.
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
