package algorithm.leetcode;

/**
 * @author snail
 * @description 二叉树的最小深度    深度优先搜索,时间：O(n),空间：O(H),其中H是树的高度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        return (root.left == null || root.right == null ? d1 + d2 : Math.min(d1, d2)) + 1;
    }

}
