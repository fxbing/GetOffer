package solution;
/*
*题目描述：
*在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
*数组中某些数字是重复的，但不知道有几个数字是重复的。
*也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
*例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*/
public class Solution3_1 {
/*
 * 解题方案：
 * 1.先排序，之后遍历，遇到相邻且相等的元素即为题解。                     时间复杂度：O(nlogn)  空间复杂度：最好为O(1),具体参见各个排序算法的空间复杂度
 * 2.使用哈希表，遍历判断是否有重复元素。                                             时间复杂度：O(n)      空间复杂度：O(n)
 * 3.如下解法：                                                                                                 时间复杂度：O(n)      空间复杂度：O(1)
*/

	public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        for (int i : numbers) {
            if (i < 0 || i >= length) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
}
