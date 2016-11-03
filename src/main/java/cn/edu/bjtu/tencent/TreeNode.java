package cn.edu.bjtu.tencent;

/**
 * Created by pangchao on 2016/11/3.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //生成一棵二叉树
    //           1
    //          / \
    //         2   3
    //        / \ / \
    //       4  5 6  7
    //      / \
    //     8   9
    // 前序遍历： 1 2 4 8 9 5 3 6 7
    // 中序遍历： 8 4 9 2 5 1 6 3 7
    // 后续遍历： 8 9 4 5 2 6 7 3 1
    public static TreeNode generateTree() {
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4, eight, nine);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);

        return one;
    }
}
