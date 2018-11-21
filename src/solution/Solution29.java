package solution;

import java.util.ArrayList;

/*
 * 题目描述:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */
public class Solution29 {
	/*
	 * 解题方法:
	 * 先一圈一圈的存,最后存剩下的一行或者一列.
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
