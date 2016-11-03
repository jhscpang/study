package cn.edu.bjtu.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by pangchao on 2016/10/14.
 */
public class TreeWidth {

    public static void main(String[] args) {
        System.out.println("haha");
    }

    // 获取最大宽度
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            if (queue.size() == 0)
                break;
            while (queue.size() > 0) {// 如果当前层，还有节点
                TreeNode t = queue.poll();
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }
}

class TreeNode {
    char val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(char _val) {
        this.val = _val;
    }
}
