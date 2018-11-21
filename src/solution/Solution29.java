package solution;

import java.util.ArrayList;

/*
 * ��Ŀ����:
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */
public class Solution29 {
	/*
	 * ���ⷽ��:
	 * ��һȦһȦ�Ĵ�,����ʣ�µ�һ�л���һ��.
	 * */
	public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int start = 0;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;        
        while (start < row && start < col) {
            addCircle(start, row, col, matrix, res);
            start++;
            row--;
            col--;
        }
        if (start == row) {
            for (int i = start; i<= col; i++)
                res.add(matrix[start][i]);
        } else if (start == col) {
            for (int i = start; i<= row; i++)
                res.add(matrix[i][start]);            
        }
        return res;
    }
    private void addCircle(int start, int row, int col, int[][] matrix, ArrayList<Integer> res) {
        for (int i = start; i<= col; i++) 
            res.add(matrix[start][i]);
        for (int i = start + 1; i<= row; i++) 
            res.add(matrix[i][col]);  
        for (int i = col - 1; i>= start; i--) 
            res.add(matrix[row][i]);
        for (int i = row - 1; i> start; i--) 
            res.add(matrix[i][start]);
    }
}
