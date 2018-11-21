package solution;
/*
*��Ŀ������
*��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� 
*������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
*Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
*���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
*/
public class Solution3_1 {
/*
 * ���ⷽ����
 * 1.������֮�������������������ȵ�Ԫ�ؼ�Ϊ��⡣                     ʱ�临�Ӷȣ�O(nlogn)  �ռ临�Ӷȣ����ΪO(1),����μ����������㷨�Ŀռ临�Ӷ�
 * 2.ʹ�ù�ϣ�������ж��Ƿ����ظ�Ԫ�ء�                                             ʱ�临�Ӷȣ�O(n)      �ռ临�Ӷȣ�O(n)
 * 3.���½ⷨ��                                                                                                 ʱ�临�Ӷȣ�O(n)      �ռ临�Ӷȣ�O(1)
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
