package solution;
/* 题目描述：
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution41 {
	static PriorityQueue<Integer> high = new PriorityQueue<>();
	static PriorityQueue<Integer> low = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			return b - a;
		}
	});
	public static void Insert(Integer num) {
		if (low.isEmpty()) {
			low.add(num);
			return;
		}
	    if (high.size() > low.size()) {
			if (num <= high.peek()) {
				low.add(num);
			} else {
				low.add(high.remove());
				high.add(num);
			}
		} else if (high.size() < low.size()) {
			if (num >= low.peek()) {
				high.add(num);
			} else {
				high.add(low.remove());
				low.add(num);
			}
		} else {
			if (num >= low.peek()) {
				high.add(num);
			} else {
				low.add(num);
			}
		}
    }

    public static Double GetMedian() {
    	if (high.size() > low.size()) {
			return high.peek().doubleValue();
		} else if (high.size() < low.size()) {
			return low.peek().doubleValue();
		} else {
			return (high.peek().doubleValue() + low.peek().doubleValue()) / 2;
		}
    }
    public static void main(String[] args) {
		int[] nums = new int[]{5,2,3,4,1,6,7,0,8};
		for (int i : nums) {
			Insert(i);
			System.out.println("low:" + low + " high:" + high + " median:" + GetMedian());
		}
		System.out.println(low.peek());
		System.out.println(high.peek());
	}
}
