package com.example.jsj.datastructuredemo.My.Tree;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树
 * 数据结构特征：在树中的任意一个节点，其左子树中的每个节点的值都要小于这个节点的值
 * ，其右子树中的每个节点的值都大于这个节点的值
 */
public class BinarySearchTree {

    TreeNode tree = null;


    public TreeNode getHeaderNode() {
        if (tree != null) {
            return tree;
        }
        return null;
    }

    /**
     * 二叉查找树的查找
     *
     * @return
     */
    public TreeNode findNode(TreeNode node, String data) {
        TreeNode p;
        if (node == null) {
            return null;
        }

        if (node.data.equals(data)) {
            return node;
        } else if (Integer.parseInt(data) > Integer.parseInt(node.data)) {
            //进入右子树
            p = findNode(node.rightNode, data);
            if (p != null) {//找到了
                return p;
            }
        } else if (Integer.parseInt(data) == Integer.parseInt(node.data)) {
            //进入左子树
            p = findNode(node.rightNode, data);
            if (p != null) {//找到了
                return p;
            }
        }

        return null;
    }


    /**
     * 插入
     *
     * @param data
     */
    public void insert(String data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }

        TreeNode p = tree;
        while (p != null) {
            if (Integer.parseInt(data) > Integer.parseInt(p.data)) {
                if (p.rightNode == null) {//如果右子树为null,将新数据插到右节点的位置
                    p.rightNode = new TreeNode(data);
                    return;
                } else {//如果不为空
                    p = p.rightNode;
                }
            } else if (Integer.parseInt(data) < Integer.parseInt(p.data)) {//data <p.data
                if (p.leftNode == null) {
                    p.leftNode = new TreeNode(data);
                    return;
                } else {
                    p = p.leftNode;
                }
            }
        }
    }


    /**
     * 删除-- 三种情况
     * 1.如果要删除的节点没有子节点 -- 只需要直接将父节点中指向要删除节点的指针置为null
     * 2.如果要删除的节点只有一个子节点(只有左节点或者右节点) -- 只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点
     * 3.如果要删除的节点有两个子节点 -- 需要找到这个节点的右子树中最小节点，把他替换到要删除的节点上，然后再删除这个最小节点
     */
    public void delete(int data) {
        TreeNode current = tree;//current 指向要删除的节点，初始化指向根节点 --- 指针方向
        TreeNode pp = null;//pp记录的是current的父节点

        //查找要删除的节点
        while (current != null && Integer.parseInt(current.data) != data) {//遍历树
            pp = current;
            if (data > Integer.parseInt(current.data)) {
                current = current.rightNode; //指向右子树
            } else {
                current = current.leftNode;//指向左子树
            }
        }

        if (current == null) {
            return;//没有找到
        }

        //要删除的节点有两个子节点
        if (current.leftNode != null && current.rightNode != null) {
            //查找右子树中最小节点
            TreeNode minNode = findMinNode(current);
            current.data = minNode.data;//将minNode的数据替换到p中
            current = minNode;//下面就变成了删除minNode了
        }

        //删除结点是叶子节点或者仅有一个子节点
        //无论有没有子节点都获取子节点
        TreeNode child = null;
        if (current.leftNode != null) {
            child = current.leftNode;
        } else if (current.rightNode != null) {
            child = current.rightNode;
        } else {//要删除结点是叶子节点
            child = null;
        }

        if (pp == null) {
            tree = child;
        } else if (pp.leftNode != null) {
            pp.leftNode = child;
        } else {
            pp.rightNode = child;
        }
    }


    /**
     * 查找右子树中最小节点
     *
     * @param currentNode
     */
    private TreeNode findMinNode(TreeNode currentNode) {
        TreeNode minNode = currentNode.rightNode;//minNode 最小节点
//        TreeNode minNodeP = currentNode;//最小节点的父节点 minNodeP
        while (minNode.leftNode != null) {
//            minNodeP = minNode;
            minNode = minNode.leftNode;
        }

//        pp = minNodeP;
        return minNode;
    }


    /**
     * 删除-- 三种情况
     * 1.如果要删除的节点没有子节点 -- 只需要直接将父节点中指向要删除节点的指针置为null
     * 2.如果要删除的节点只有一个子节点(只有左节点或者右节点) -- 只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点
     * 3.如果要删除的节点有两个子节点 -- 需要找到这个节点的右子树中最小节点，把他替换到要删除的节点上，然后再删除这个最小节点
     */
    public void delete1(int data) {
        TreeNode current = tree;//p 指向要删除的节点，初始化指向根节点 --- 指针方向
        TreeNode parent = null;//pp记录的是p的父节点

        //查找要删除的节点
        while (current != null && Integer.parseInt(current.data) != data) {//遍历树
            parent = current;
            if (data > Integer.parseInt(current.data)) {
                current = current.rightNode; //指向右子树
            } else {
                current = current.leftNode;//指向左子树
            }
        }

        if (current == null) {
            return;//没有找到
        }

        //要删除的节点有两个子节点
        if (current.leftNode != null && current.rightNode != null) {
            //查找右子树中最小节点
            TreeNode successor = minimun(current.rightNode);
            //转移后续节点值到当前值
            current.data = successor.data;
            //把要删除的当前节点设置为后续节点
            current = successor;
        }

        //删除结点是叶子节点或者仅有一个子节点
        //无论有没有子节点都获取子节点
        TreeNode child = null;
        if (current.leftNode != null) {
            child = current.leftNode;
        } else {
            child = current.rightNode;
        }

        if (child != null) {//有一个子节点

        } else {//没有子节点

        }

        //如果当前节点没有子节点
        if (current.leftNode == null && current.rightNode == null) {
            current = null;
//            if(current == tree){//如果要删除的节点就是这个树的父节点，直接至为null
//                tree = null;
//            }else if(){
//
//            }

        }
    }


    /**
     * 按层遍历
     */
    void LevelTree() {
        Queue<TreeNode> queue = new LinkedList<>();

        if (tree != null) {
            queue.offer(tree);//将根节点入队
        }

        while (!queue.isEmpty()) {
            //访问根节点，就是队头元素
            TreeNode node = queue.poll();//出队并访问
            TreeNodeData(node);
            if (node.leftNode != null) {
                queue.offer(node.leftNode);//如果当前节点的左节点不为空入队
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);//如果当前节点的右节点不为空，把右节点入队
            }
        }
    }

    /**
     * 显示结点数据
     *
     * @param treeNode
     */
    void TreeNodeData(TreeNode treeNode) {
        Log.e("BinarySearchTree ", treeNode.data);
    }


    /**
     * 查找最小节点
     *
     * @param node
     * @return
     */
    private TreeNode minimun(TreeNode node) {
        if (node.leftNode == null) return node;

        return minimun(node.leftNode);
    }


}
