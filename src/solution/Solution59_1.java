package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
��Ŀ����:
����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
{[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
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
