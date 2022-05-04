package leet;

import java.util.LinkedList;
import java.util.Queue;

public class _572SubtreeofAnotheTree {

    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        /*
            Travese tree s

            if value the and node in s == value of treeNode t
                then check for subtree if true then break and return true;
            else
                complete the traversal of tree s and return false;

        */

        // Traversal of tree s;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                //     System.out.println(temp.val);
                if (temp.val == t.val) {
                    if (checkValidSubTree(temp, t)) {
                        return true;
                    }
                }
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }
        return false;
    }

    public boolean checkValidSubTree(TreeNode a, TreeNode b) {
        boolean r = true;
        // System.out.println(a.val + " : " + b.val);
        if (a.val == b.val) {
            if (a.left != null && b.left != null) {
                r = r && checkValidSubTree(a.left, b.left);
            } else if (a.left == null && b.left == null) {
                r = r && true;
            } else {
                r = r && false;
            }

            if (a.right != null && b.right != null) {
                r = r && checkValidSubTree(a.right, b.right);
            } else if (a.right == null && b.right == null) {
                r = r && true;
            } else {
                r = r && false;
            }

        } else {
            r = false;
        }
        return r;
    }


}
