package solution;

import java.util.ArrayList;

/*
��Ŀ����:
����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
��Ӧÿ�����԰����������������С���������
*/
public class Solution57_1 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] > sum) {
                end--;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                res.add(array[start]);
                res.add(array[end]);
                break;
            }
        }
        return res;
    }
}
