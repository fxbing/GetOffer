package solution;
/* ��ĿҪ��
 * ����һ������Ϊn�����ӣ�������Ӽ���m�Σ�m , n ����������������n>1&m>1��
 * ÿ�����ӵĳ���Ϊk[0],k[1],k[2],...,k[m]������k[0]k[1]k[2]...k[m]�����ֵ��
 * ���������ǳ���Ϊ8�����ǰ������ɵĳ��ȷֱ�Ϊ2,3,3�����Σ���ʱ�õ������ĳ˻���18��
 * */
public class Solution14 {
	/*
	 * �ⷨһ��
	 * ��̬�滮
	 * */
	int maxProductAfterCutting1(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		int[] products = new int[length + 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;//�˴�ע�⣬����С��4���������ǰ�淵���ˣ������products[3]�����ǳ���Ϊ3�Ľ��
		
		int max = 0;
		for(int i = 4;i <= length;i++) {
			max = 0;
			for(int j = 1;j <= i/2;j++) {
				max = Math.max(max, products[j] * products[i - j]);
			}
			products[i] = max;
		}
		return products[length];
	}
	/*�ⷨ����
	 * ̰���㷨
	 * */
	int maxProductAfterCutting2(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		// �����ܶ�ؼ�ȥ����Ϊ3�����Ӷ�
		int timesOf3 = length / 3;
		// ���������ʣ�µĳ���Ϊ4��ʱ�򣬲����ټ�ȥ����Ϊ3�����ӶΡ���Ϊ����2*2������
		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		int timesOf2 = (length - timesOf3 * 3) / 2;
		return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
	}
}
