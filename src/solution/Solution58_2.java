package solution;
/*
��Ŀ����:
�����������һ����λָ�����ѭ�����ƣ�ROL����
�����и��򵥵����񣬾������ַ���ģ�����ָ�����������
����һ���������ַ�����S���������ѭ������Kλ������������
���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
*/
public class Solution58_2 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() < 2) {
            return str;
        }
        if (n > str.length()) {
            n %= str.length();
        }
        StringBuffer left = new StringBuffer(str.substring(0, n));
        StringBuffer right = new StringBuffer(str.substring(n));
        return left.reverse().append(right.reverse()).reverse().toString();
    }
}
