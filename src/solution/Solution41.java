package solution;
/* ��Ŀ������
 * ��εõ�һ���������е���λ����
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����*/

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
