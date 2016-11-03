package cn.edu.bjtu.mi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TreeReverse2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            int sourseNumber = in.nextInt();
            TreeNode[] tree = new TreeNode[sourseNumber];
            TreeNode treeHead;
            ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
            treeList.add(new TreeNode());
            tree[0] = new TreeNode();

            for (int i = 0; i < sourseNumber - 1; i++) {

                int parent = in.nextInt();
                int children = in.nextInt();
                TreeNode node = new TreeNode();

                TreeNode pNode = tree[parent];
                if (pNode.left == null) {
                    pNode.left = node;
                } else {
                    pNode.right = node;
                }
                tree[children] = node;

            }

            treeHead = tree[0];
            int deep = getDepth(treeHead);
            myprint(deep);
        }
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;

    }

    /**
     * 求二叉树的深度（高度） 迭代解法： O(n) 基本思想同LevelOrderTraversal，还是用一个Queue
     */
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0; // 深度
        int currentLevelNodes = 1; // 当前Level，node的数量
        int nextLevelNodes = 0; // 下一层Level，node的数量

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove(); // 从队头位置移除
            currentLevelNodes--; // 减少当前Level node的数量
            if (cur.left != null) { // 如果有左孩子，加到队尾
                queue.add(cur.left);
                nextLevelNodes++; // 并增加下一层Level node的数量
            }
            if (cur.right != null) { // 如果有右孩子，加到队尾
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
                depth++; // 增加高度
                currentLevelNodes = nextLevelNodes; // 初始化下一层的遍历
                nextLevelNodes = 0;
            }
        }

        return depth;
    }

    private static void myprint(String string) {

        System.out.println(string);
    }

    private static void myprint(int num) {
        System.out.println("" + num);
    }

}