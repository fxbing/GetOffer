package solution;
/*
 * 题目描述:
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/
public class Solution5 {
/*
 * 解题思路：
 * 解法一：正向移动——正向搜索，每次遇到一个空格就遍历移动后面的全部元素。    时间复杂度：O(n*n)
 * 解法二：反向移动——先遍历一遍字符串，统计空格出现的次数，计算好最终结果字符串的长度，然后从后向前遍历移动元素。具体代码如下：    时间复杂度：O(n)
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
