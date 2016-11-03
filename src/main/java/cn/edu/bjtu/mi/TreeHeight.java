package cn.edu.bjtu.mi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeHeight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] a = new int[num - 1];
		int[] b = new int[num - 1];

		for (int i = 0; i < num - 1; i++) {
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
		}
		TreeNode tree = deserialize(a, b);
		int height = countHeight(tree);
		System.out.println(height);

	}

//	public static TreeNode deserialize(int[] a, int[] b) {
//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		TreeNode root = new TreeNode(a[0]);
//		TreeNode node = root;
//
//		queue.add(node);
//		for (int i = 0; i < a.length; i++) {
//			node = queue.peek();
//			if (i < a.length - 1 && a[i] == node.val && a[i + 1] == node.val) {
//				node.left = new TreeNode(b[i]);
//				node.right = new TreeNode(b[++i]);
//				queue.add(node.left);
//				queue.add(node.right);
//			} else if ((i < a.length - 1 && a[i] == node.val && a[i + 1] != node.val) || (i == a.length - 1)){
//				node.left = new TreeNode(b[i]);
//				queue.add(node.left);
//			}
//			queue.poll();
//		}
//		return root;
//	}

	public static TreeNode deserialize(int[] a, int[] b) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(a[0]);
		TreeNode node = root;

		queue.add(node);
		for (int i = 0; i < a.length; i++) {
			node = queue.poll();
			if(a[i] == node.val){
				if(node.left == null){
					node.left = new TreeNode(b[i]);
					queue.add(node.left);
				}else{
					node.right = new TreeNode(b[i]);
					queue.add(node.right);
				}
			}
		}
		return root;
	}

	public static int countHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int nLelt = countHeight(root.left);
		int nRight = countHeight(root.right);
		return nLelt > nRight ? (nLelt + 1) : (nRight + 1);
	}
}

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}