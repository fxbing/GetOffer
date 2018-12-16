package solution;

import java.util.HashSet;

/*
��Ŀ������
LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
*/
public class Solution61 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int max = -1;
        for (int i : numbers) {
            max = Math.max(i, max);
            if (set.contains(i)) {
                return false;
            }
            if (i == 0) {
                count++;
                continue;
            }
            set.add(i);
        }
        for (int i = max;!set.isEmpty();i--) {
            if (!set.remove(i)) {
                if (count == 0) {
                    break;
                } else {
                    count--;
                }
            }
        }
        return set.isEmpty();
    }
}
