package solution;
/*
��Ŀ������
дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
*/
public class Solution65 {
    /*�ӷ������������
    * 1����Ӳ���λ���õ�sum
    * 2��ֻ���λ���õ�carry
    * 3:1.2�����ӣ�ѭ��֪��û�н�λ���õ����
    * */

    public int Add(int num1,int num2) {
        int sum,carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
