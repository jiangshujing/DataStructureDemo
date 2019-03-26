package com.example.jsj.datastructuredemo.My.Tree;

/**
 * Created by jiangshujing on 2018/1/26.
 * 二叉树节点类型
 */

public class TreeNode {
    String data;
    TreeNode leftNode;//左子树节点引用
    TreeNode rightNode;//右子树节点引用

    public TreeNode() {
    }

    public TreeNode(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data='" + data + '\'' +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}

