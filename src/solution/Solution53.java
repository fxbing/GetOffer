package solution;
/*题目描述：
统计一个数字在排序数组中出现的次数。*/
public class Solution53 {
    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start1 = 0, end1 = array.length - 1;
//        找出最后一次出现的位置
        while ((start1+ 1) < end1) {
            int mid = start1 + ((end1 - start1) >> 1);
            if (array[mid] < k || (array[mid] == k && array[mid + 1] == k)) {
                start1 = mid + 1;
            } else if (array[mid] > k) {
                end1 = mid - 1;
            } else {
                start1 = mid;
                break;
            }
        }
        if (array[end1] == k) {
            start1 = end1;
        }
//        找出第一次出现的位置
        int start2 = 0, end2 = array.length - 1;
        while ((start2 + 1)< end2) {
            int mid = start2 + ((end2 - start2) >> 1);
            if (array[mid] < k) {
                start2 = mid + 1;
            } else if (array[mid] > k || (array[mid] == k && array[mid - 1] == k)) {
                end2 = mid - 1;
            } else {
                end2 = mid;
                break;
            }
        }
        if (array[start2] == k) {
            end2 = start2;
        }
//        有不存在的情况，所以需要进行判断
        return array[start1] == k ? start1 - end2 + 1 : 0;
    }
}
