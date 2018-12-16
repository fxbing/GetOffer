package solution;

import java.util.ArrayList;

/*
题目描述:
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
对应每个测试案例，输出两个数，小的先输出。
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
