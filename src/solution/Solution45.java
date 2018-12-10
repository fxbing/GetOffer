package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 题目描述：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。*/
public class Solution45 {
	public String PrintMinNumber(int [] nums) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
        	list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				String s1 = String.valueOf(a);
				String s2 = String.valueOf(b);
                return (s1 + s2).compareTo(s2 +s1);
			}
		});
        for (int i : list) {
        	stringBuffer.append(String.valueOf(i));
        }
        return stringBuffer.toString();
    }
}
