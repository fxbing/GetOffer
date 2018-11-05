package solution;

/*��Ŀ����:
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
 * ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 *  �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 *  ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
*/
public class Solution19 {
	/*
	 * ���ⷽ���� ��������ۣ�����*�����ݹ顣 ����ݹ鱬ջ������ʹ�ö�̬�滮��
	 */
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return helper(str, pattern, 0, 0);
	}

	public boolean helper(char[] str, char[] pattern, int index1, int index2) {
		if (index1 == str.length && index2 == pattern.length) {
			return true;
		} else if (index1 < str.length && index2 == pattern.length) {
			return false;
		}
		if (index2 + 1 < pattern.length && pattern[index2 + 1] == '*') {
			if (index1 < str.length && (pattern[index2] == '.' || str[index1] == pattern[index2])) {
				return helper(str, pattern, index1, index2 + 2) ||  //����*
					   helper(str, pattern, index1 + 1, index2) ||  //��*ƥ��һ�Σ�������ܻ�����ͬ����ĸ��
					   helper(str, pattern, index1 + 1, index2 + 2);//��*ƥ��һ�Σ�����û����ͬ����ĸ��
			} else {
				return helper(str, pattern, index1, index2 + 2);
			}
		} else {
			if (index1 < str.length && (pattern[index2] == '.' || str[index1] == pattern[index2])) {
				return helper(str, pattern, index1 + 1, index2 + 1);
			} else {
				return false;
			}
		}
	}
}
