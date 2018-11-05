package solution;
/* ��Ŀ����
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * */
public class Solution16 {
	/*���ⷽ��
	 * ���ǵ���Ϊ0��ָ��Ϊ���������
	 * ʹ�ö��ַ����
	 * */
	public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        int count = 1;
        boolean tag = false;
        if (exponent == 0) {
            return 1;
        }
        else if (exponent < 0) {
            tag = true;
            exponent = -exponent;
        }
        double cur = base;
        while (2 * count < exponent) {
            cur *= cur;
            count *= 2;
        }
        count = exponent - count;
        while (count-- > 0) {
            cur *= base;
        }
        if (tag) {
            return 1 / cur;
        } else {
            return cur;
        }
    }
}
