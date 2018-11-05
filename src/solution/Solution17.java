package solution;
/* ��Ŀ������
 * ��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3һֱ������3λ����999��
 * */
public class Solution17 {
	/*
	 * �ⷨһ��ģ���ַ���
	 * �ⷨ�����ݹ���ȫ����
	 * */
	void Print1ToMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		helper(number, n, 0);
	}
	void helper(char[] number, int length, int index) {
		if (index > length - 1) {
			PrintNumber(number);
			return;
		}
		for(int i = 0;i < 10;i++) {
			number[index] = (char) (i + '0');
			helper(number, length, index + 1);
		}
	}
	void PrintNumber(char[] number) {
		String string = new String(number);
		int start = 0;
		while (string.charAt(start) == '0') {
			start++;
		}
		System.out.println(string.substring(start));
	}
}
