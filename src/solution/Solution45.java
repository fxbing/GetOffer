package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* ��Ŀ������
 * ����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��*/
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
