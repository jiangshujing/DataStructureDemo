package com.example.jsj.datastructuredemo.My.Tree;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jsj.datastructuredemo.R;

/**
 * Created by jiangshujing on 2018/1/26.
 */

public class TreeTestActivity extends Activity {

//
//                  A
//          B               C
//     D        E      F
//

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_tast);
        binaryTree();
//        binarySearchTree();
    }


    /**
     * 二叉树
     */
    private void binaryTree() {
        TreeNode root = new TreeNode();
        Tree tree = new Tree();
        //初始化栈
        root = tree.initTree();

        //添加节点
        tree.addTreeNode(root, "B", "A", 1);
        tree.addTreeNode(root, "C", "A", 2);
        tree.addTreeNode(root, "D", "B", 1);
        tree.addTreeNode(root, "E", "B", 2);
        tree.addTreeNode(root, "F", "C", 1);

        //遍历
//        tree.DLRTree(root);//先序
        tree.DLRTree2(root);//先序
        Log.e("中序 Tree","\n");
//        tree.LDRTree(root);//中序
        tree.LDRTree2(root);//中序
//        Log.e("后序 Tree","\n");
//        tree.LRDTree(root);//后序
        tree.LevelTree(root);

        Log.e("Tree 深度 == ", tree.TreeDepth(root) + "");
        Log.e("5/2 =  ", 5/2 + "");
    }


    /**
     * 二叉查找树
     */
    private void binarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();
        //添加节点
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");
        tree.insert("4");
        tree.insert("5");

        //遍历
        tree.LevelTree();

        TreeNode node = tree.findNode(tree.getHeaderNode(), "3");
        if (node != null) {
            Log.e("TreeTestActivity", node.toString());
        }
    }
}
