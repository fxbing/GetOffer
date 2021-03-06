package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
题目描述:
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/
public class Solution59_1 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int start = 0;
        for (int end = 0; end < num.length; end++) {
            while (!queue.isEmpty() && num[queue.getLast()] < num[end]) {
                queue.removeLast();
            }
            queue.addLast(end);
            if (end - start + 1 == size) {
                res.add(num[queue.getFirst()]);
                if (queue.getFirst() == start) {
                    queue.removeFirst();
                }
                start++;
            }
        }
        return res;
    }
}
