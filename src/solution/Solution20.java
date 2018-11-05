package solution;

/*��Ŀ������
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 *  ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 *  */
public class Solution20 {
	/*
	 * ����˼·�� ��ǰ���󣬰���ģʽ����ƥ��
	 */
	public boolean isNumeric(char[] str) {
		boolean result = false;
		int index = 0;
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		int tmp = scanUnsignedInteger(str, index);
		// �Ƿ���������ͷ
		result = tmp > index;
		index = tmp;
		if (index < str.length && str[index] == '.') {
			index++;
			tmp = scanUnsignedInteger(str, index);
			// �����С���㣬ֻҪ��֤С����ǰ������������С����������޷��������Ϳ���
			result = result || tmp > index;
			index = tmp;
		}
		if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			if (index < str.length && (str[index] == '+' || str[index] == '-')) {
				index++;
			}
			tmp = scanUnsignedInteger(str, index);
			// �����ָ��Ҫ��֤�������ڲ���ָ��Ϊ����
			result = result && tmp > index;
		}
		return result && tmp == str.length;
	}

	public int scanUnsignedInteger(char[] str, int index) {
		while (index < str.length && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index;
	}
}
