package com.lee.july.day17;


/**
 * @Author Lee
 * @Create 2019/7/22 15:16
 * @Description 把给定源二叉树变换为镜像二叉树
 */


class TreeNode1{
    int value = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;
    public TreeNode1(int value){
        this.value = value;
    }
}


public class TestDemo2 {
    public static void Mirror(TreeNode1 root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right != null){
            root.left = root.right;
            root.right = null;
            Mirror(root.left);
            return;
        }
        if(root.right == null && root.left != null){
            root.right = root.left;
            root.left = null;
            Mirror(root.right);
            return;
        }
        TreeNode1 temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
        return;
    }
}
