package cn.edu.bjtu.tencent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by pangchao on 2016/11/3.
 */
public class TreeRelevance {

    public static void main(String[] args) {
        // 前序遍历： 1 2 4 8 9 5 3 6 7
        // 中序遍历： 8 4 9 2 5 1 6 3 7
        // 后续遍历： 8 9 4 5 2 6 7 3 1
        TreeNode tree = TreeNode.generateTree();
//        preTraverse(tree);
//        System.out.println();
//        preTraverse1(tree);
//        System.out.println();
//        inTraverse(tree);
//        System.out.println();
//        inTraverse1(tree);
//        System.out.println();
//        postTraverse(tree);
//        System.out.println();
//        postTraverse1(tree);
//        System.out.println();
//        findNodePath(tree, 9);
//        System.out.println();
//        levelTraverse(tree);
//        System.out.println(nodeNum(tree));
//        System.out.println(nodeNum1(tree));
        System.out.println(leafNodeNum(tree));
        System.out.println(leafNodeNum1(tree));

    }

    //递归版前序遍历
    public static void preTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    //非递归版前序遍历
    public static void preTraverse1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || stack.size() > 0) {
            if (pNode != null) {
                System.out.print(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode p = stack.pop();
                pNode = p.right;
            }
        }
    }

    //递归版中序遍历
    public static void inTraverse(TreeNode root) {
        if (root != null) {
            inTraverse(root.left);
            System.out.print(root.val);
            inTraverse(root.right);
        }
    }

    //非递归版中序遍历
    public static void inTraverse1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode p = stack.pop();
                System.out.print(p.val);
                pNode = p.right;
            }
        }
    }

    //递归版后序遍历
    public static void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.print(root.val);
        }
    }

    //非递归版后序遍历
    public static void postTraverse1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        TreeNode flag = null; //记录最近访问的节点
        while (pNode != null || stack.size() > 0) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode p = stack.peek();
                if (p.right != null && !p.right.equals(flag)) {//右子树存在且没被访问过
                    pNode = p.right;
                    stack.push(pNode);
                    pNode = pNode.left;
                } else {
                    p = stack.pop();
                    System.out.print(p.val);
                    flag = p;
                    // pNode = null;
                }

            }
        }
    }

    //输出某个节点到根节点的路径
    public static void findNodePath(TreeNode root, int val) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        TreeNode flag = null;//记录最近访问的节点
        while (pNode != null || stack.size() > 0) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode p = stack.peek();
                if (p.val == val) {//找到节点,依次输出堆栈即是路径
                    while (stack.size() > 0) {
                        System.out.print(stack.pop().val);
                    }
                    return;
                }
                if (p.right != null && !p.right.equals(flag)) {
                    pNode = p.right;
                    stack.push(pNode);
                    pNode = pNode.left;
                } else {
                    p = stack.pop();
                    flag = p;
                }
            }
        }
    }

    //层次遍历
    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode p = queue.poll();
            System.out.print(p.val);
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }

    //递归求树的节点数
    public static int nodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = nodeNum(root.left);
        int rightNum = nodeNum(root.right);
        return leftNum + rightNum + 1;
    }

    //非递归求树的节点个数
    public static int nodeNum1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        int num = 0;
        while (pNode != null || stack.size() > 0) {
            if (pNode != null) {
                num++;
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode p = stack.pop();
                pNode = p.right;
            }
        }
        return num;
    }

    //递归求树的叶子节点数
    public static int leafNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftNum = leafNodeNum(root.left);
        int rightNum = leafNodeNum(root.right);

        return leftNum + rightNum;
    }

    //非递归求树的叶子节点数
    public static int leafNodeNum1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        int num = 0;
        while (pNode != null || stack.size() > 0) {
            if (pNode != null) {
                if (pNode.left == null && pNode.right == null) {
                    num++;
                }

                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode p = stack.pop();
                pNode = p.right;
            }
        }
        return num;
    }

    //判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {//都等于null
            return true;
        } else if (p == null || q == null) {//其中一个等于null
            return false;
        } else if (p != null && q != null && p.val == q.val) {//都不等于null
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }

    }

    //判断是否是镜像二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            return false;
        }
        if (root.left != null && root.right == null) {
            return false;
        }

        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode x, TreeNode y) {
        if (x == null && y == null) {
            return true;
        }
        if (x == null && y != null) {
            return false;
        }
        if (x != null && y == null) {
            return false;
        }
        if (x.val != y.val) {
            return false;
        }

        return symmetric(x.left, y.right) && symmetric(x.right, y.left);
    }

    //求树的最大高度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countHeight(root, 1);
    }

    private int countHeight(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        if (root.left == null && root.right != null) {
            return countHeight(root.right, height + 1);
        } else if (root.left != null && root.right == null) {
            return countHeight(root.left, height + 1);
        } else if (root.left == null && root.right == null) {
            return height;
        }
        int leftHeight = countHeight(root.left, height + 1);
        int rightHeight = countHeight(root.right, height + 1);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    //计算是否存在路径值和为某个值得路径
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            } else {
                return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
            }
        }
    }

    //递归方式实现二叉树的反转
    public TreeNode invertTree(TreeNode root) {
        //递归解法
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    //非递归方式实现二叉树的反转
    public TreeNode invertTree1(TreeNode root) {
        //迭代解法
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



}
