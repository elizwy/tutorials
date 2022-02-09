package com.elizwy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337
 */
public class Rob3 {
    static Map<TreeNode, Integer> f = new HashMap<>();
    static Map<TreeNode, Integer> g = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node1.left = node4;
        node2.right = node5;
        node2.left = node6;


        System.out.println(rob(root));
    }

    private static int rob(TreeNode root) {
        dfs(root);

        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.value + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }


    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
