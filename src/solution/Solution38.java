package solution;

import java.util.ArrayList;
import java.util.Arrays;

/* ��Ŀ����:
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��*/
public class Solution38 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str == null || str.length() == 0) {
			return res;
		}
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        dfs(res, new StringBuffer(), chs, 0);
        return res;
    }
	public void dfs(ArrayList<String> res, StringBuffer stringBuffer, char[] chs, int index) {
		if (index >= chs.length) {
			res.add(stringBuffer.toString());
			return;
		}
		for(int i = index;i < chs.length;i++){
			if (i != index && chs[i] == chs[index]) {
				continue;
			}
			swap(chs, index, i);
			stringBuffer.append(chs[index]);
			dfs(res, stringBuffer, chs, index + 1);
			stringBuffer.deleteCharAt(stringBuffer.length() - 1);
			swap(chs, index, i);
		}
	}
	public void swap(char[] chs, int a, int b) {
		char tmp = chs[a];
		chs[a] = chs[b];
		chs[b] = tmp;
	}
}
