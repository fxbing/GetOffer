package solution;
/*
 * ��Ŀ����:
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
*/
public class Solution5 {
/*
 * ����˼·��
 * �ⷨһ�������ƶ���������������ÿ������һ���ո�ͱ����ƶ������ȫ��Ԫ�ء�    ʱ�临�Ӷȣ�O(n*n)
 * �ⷨ���������ƶ������ȱ���һ���ַ�����ͳ�ƿո���ֵĴ�������������ս���ַ����ĳ��ȣ�Ȼ��Ӻ���ǰ�����ƶ�Ԫ�ء�����������£�    ʱ�临�Ӷȣ�O(n)
*/
	public String replaceSpace(StringBuffer str) {
    	int length = str.length();
        if (str == null || length == 0) {
            return new String();
        }
        
        int count = 0;
        for (char c : str.toString().toCharArray()) {
            if (c == ' ') {
                ++count;
            }
        }
        
        int newLength = length + count * 2;
        str.setLength(newLength);
        while (--length >= 0) {
            char c = str.charAt(length);
            if (c == ' ') {
                str.setCharAt(--newLength, '0');
                str.setCharAt(--newLength, '2');
                str.setCharAt(--newLength, '%');
            }
            else {
                str.setCharAt(--newLength, str.charAt(length));
            }
        }
        return str.toString();
    }
}
