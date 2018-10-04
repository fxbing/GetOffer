package solution;
/*
 * ��Ŀ������
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
 * ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * */
public class Solution4 {
	/*
	 * ����˼·��
	 * �����ص㿼�ǲ��ҵ���㣬��������Ͻǻ������½ǿ�ʼ���ң��޷����ݵ�ǰλ�����ݺ�target�ıȽ����ж����ĸ��������ߡ�
	 * ��������½ǻ������Ͻǿ�ʼ���ң��Ϳ���ͨ����ǰλ�����ݺ�target�ıȽ��������ƶ��ķ���
	 * ���´�����Ǵ����Ͻǿ�ʼ�ƶ��ķ�����
	 * ʱ�临�Ӷȣ�O(m+n)   �ռ临�Ӷȣ�O(1)
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
