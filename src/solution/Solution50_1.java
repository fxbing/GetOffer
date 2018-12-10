package solution;
/* ��Ŀ������
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
 * ����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * */
public class Solution50_1 {
	public static int FirstNotRepeatingChar(String str) {
        // -1:û�г��ֹ�  -2�����ֹ����  ���������ֹ�һ�ε�����λ��
        int[] upperLetter = new int[26];
        int[] lowerLetter = new int[26];
        for (int i = 0;i < 26;i++){
            upperLetter[i] = -1;
            lowerLetter[i] = -1;
        }
        char[] chs = str.toCharArray();
        for (int i = 0; i < str.length();i++) {
            char c = chs[i];
            if (c == 'K') {
				System.out.println();
			}
            if (c - 'a' >= 0 && c - 'a' < 26) {
                if (lowerLetter[c - 'a'] == -1) {
                    lowerLetter[c - 'a'] = i;
                } else if (lowerLetter[c - 'a'] != -2) {
                    lowerLetter[c - 'a'] = -2;
                }
            } else {
                if (upperLetter[c - 'A'] == -1) {
                    upperLetter[c - 'A'] = i;
                } else if (upperLetter[c - 'A'] != -2) {
                    upperLetter[c - 'A'] = -2;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < 26;i++){
            res = upperLetter[i] >= 0 ? Math.min(res, upperLetter[i]) : res;
            res = lowerLetter[i] >= 0 ? Math.min(res, lowerLetter[i]) : res;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FirstNotRepeatingChar("SKQmoiGXAJWdqxkWmyyemQfSPQFQFwevDWfToOcZMFLYookJkaTibswKDCq"));
	}

}
