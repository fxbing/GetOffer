package solution;

import java.util.ArrayList;
import java.util.Arrays;

/* 题目描述:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。*/
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
