package solution;
/*
��Ŀ������
����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
*/
public class Solution66 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = 1;
        for (int i = 1; i < A.length; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }
        D[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }
        for (int i = 0; i < A.length; i++) {
            B[i] = C[i] * D[i];
        }
        return B;
    }
}
