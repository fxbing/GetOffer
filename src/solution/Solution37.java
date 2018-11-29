package solution;

/* ��Ŀ������
 * ��ʵ�������������ֱ��������л��ͷ����л�������*/
public class Solution37 {
	static String Serialize(TreeNode root) {
		if (root == null) {
			return "#,";
		}
		String left = Serialize(root.left);
		String right = Serialize(root.right);
		return root.val + "," + left + right;
	}

	static int index = -1;

	static TreeNode Deserialize(String str) {
		index++;
		int len = str.length();
		if (index >= len) {
			return null;
		}
		String[] strings = str.split(",");
		TreeNode node = null;
		if (!strings[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(strings[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}

		return node;
	}

}
