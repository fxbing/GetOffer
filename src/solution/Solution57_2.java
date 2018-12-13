package solution;

import java.util.ArrayList;

/*题目描述：
输出所有和为S的连续正数序列。
序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
* */
public class Solution57_2 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 0) {
            return res;
        }
        int curSum = 0;
        ArrayList<Integer> cur = new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            System.out.println(cur);
            if (curSum < sum) {
                cur.add(i);
                curSum += i;
            } else if (curSum > sum) {
                while (curSum > sum) {
                    int tmp = cur.remove(0);
                    curSum -= tmp;
                }
                i--;
            } else {
                res.add(new ArrayList<>(cur));
                cur.add(i);
                curSum += i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(9));
    }
}
