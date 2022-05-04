package leet;

/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class _1110DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        int[] to_delete = {1,2,3,4};
        delNodes(null, to_delete);
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> s2 = (HashSet<Integer>) Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode>  res = new ArrayList<>();
        TreeNode parent = null;
        buildForest(root, parent, res, s2);
        return res;
    }

    private static boolean buildForest(TreeNode root, TreeNode parent, List<TreeNode> res, HashSet<Integer> s2) {
        boolean addParent = false;
        boolean leftResult = false;
        boolean rightResult = false;


        if(s2.contains(root.val)) {

                if(root.left == null && root.right == null){
                    addParent = true;
                }
                // delete the node and also parent and child links and call build Forest on child nodes
            if(root.left != null) {
                    leftResult = buildForest(root.left, null, res, s2);
                    res.add(root.left);
                }
            if(root.right != null) {
                    rightResult = buildForest(root.right, null, res, s2);
                    res.add(root.right);
                }

                if(leftResult || rightResult) {
                    addParent = true;
                }
                // need to backTrack or keep a hashMap referencing the parent. root node which has parent as null and add it.
                if(parent.right.val == root.val) {
                    parent.right = null;
                }
                if(parent.left.val == root.val) {
                    parent.left = null;
                }
            } else {
            if (root.left != null) {
                leftResult = buildForest(root.left, null, res, s2);
                res.add(root.left);
            }
            if (root.right != null) {
                rightResult = buildForest(root.right, null, res, s2);
                res.add(root.right);
            }

            if (leftResult || rightResult) {
                addParent = true;
            }
        }

        if(addParent && parent == null) {
            res.add(root); // as root the firstAncestor
            addParent = false;
        }
        return addParent;
    }

    //* Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
