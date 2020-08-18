package algorithm.leetcode;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * @Description 有序链表转换二叉搜索树     分治+中序遍历优化 时间：O(n) 空间：O(logn)
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @Author snail
 */
public class LeetCode109 {

    private static ListNode targetHead;

    public static TreeNode sortedListToBST(ListNode head) {
        targetHead = head;
        int len = getLength(head);
        return buildTree(0, len - 1);
    }

    private static TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = targetHead.val;
        targetHead = targetHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}