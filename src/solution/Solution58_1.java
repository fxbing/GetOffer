package solution;

/*
��Ŀ����:
ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
���磬��student. a am I����
��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
*/
public class Solution58_1 {
    public static String ReverseSentence(String str) {
        System.out.println(str.length());
        if (str == null || str.length() < 2) {
            return str;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        String[] strs = sb.toString().split(" ");
        String res = new String();
        for (String s : strs) {
            res += new StringBuffer(s).reverse().toString() + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }
}
