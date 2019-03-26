package com.example.jsj.datastructuredemo.My.Tree;

import android.util.Log;

import com.example.jsj.datastructuredemo.structures.Tree.BinaryTree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jiangshujing on 2018/1/27.
 */

public class Tree {

    /**
     * 初始化二叉树
     *
     * @return
     */
    TreeNode initTree() {
        TreeNode treeNode = new TreeNode();
        if (treeNode != null) {
            treeNode.data = "A";
            treeNode.leftNode = null;
            treeNode.rightNode = null;
            return treeNode;
        }
        return null;
    }

    /**
     * 查找结点
     *
     * @param treeNode
     * @param data
     * @return
     */
    TreeNode findNode(TreeNode treeNode, String data) {
        TreeNode ptr;
        if (treeNode == null) {
            return null;
        } else {
            if (treeNode.data.equals(data)) {
                return treeNode;
            } else {
                ptr = findNode(treeNode.leftNode, data);//递归左子树
                if (ptr != null) {//返回不为null,说明查找到了
                    return ptr;
                }
                ptr = findNode(treeNode.rightNode, data);//递归右子树
                if (ptr != null) {
                    return ptr;
                }
            }
        }
        return null;
    }

    /**
     * 添加结点
     *
     * @param treeNode
     * @param data
     * @param parentData 父节点数据，要添加到此节点下
     * @param position   1添加在左结点 2添加到右接点
     */
    void addTreeNode(TreeNode treeNode, String data, String parentData, int position) {

        //分配内存空间
        TreeNode newTreeNode = new TreeNode();
        if (newTreeNode == null) {
            Log.d("", "申请空间失败");
            return;
        } else {
            //给新结点设置数据
            newTreeNode.data = data;
            newTreeNode.leftNode = null;//设置左右子树为空
            newTreeNode.rightNode = null;

            //查找要添加到哪个父节点下
            TreeNode parentNode = findNode(treeNode, parentData);
            if (parentNode == null) {
                Log.d("", "未能找到该父节点");
                newTreeNode = null;//释放创建的节点内存
                return;
            } else {
                if (position == 1) {//添加到左结点下
                    parentNode.leftNode = newTreeNode;
                } else {//添加到右节点下
                    parentNode.rightNode = newTreeNode;
                }
            }
        }
    }

    /**
     * 获取左子树
     *
     * @param treeNode
     * @return
     */
    TreeNode getLeftTreeNode(TreeNode treeNode) {
        if (treeNode != null) {
            return treeNode.leftNode;
        }
        return null;
    }

    /**
     * @param treeNode
     * @return
     */
    TreeNode getRightNode(TreeNode treeNode) {
        if (treeNode != null) {
            return treeNode.rightNode;
        }
        return null;
    }

    /**
     * 判断二叉树是否为空
     *
     * @param treeNode
     * @return
     */
    int TreeIsEmpty(TreeNode treeNode) {
        //判断是否为空，就是数据是否为空
        if (treeNode != null) {
            return 0;
        }
        return 1;
    }

    /**
     * 计算二叉树中结点的深度
     * 返回当前树的深度
     * 说明:
     * 1、如果一棵树只有一个结点，它的深度为1。
     * 2、如果根结点只有左子树而没有右子树，那么树的深度是其左子树的深度加1；
     * 3、如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1；
     * 4、如果既有右子树又有左子树，那该树的深度就是其左、右子树深度的较大值再加1。
     *
     * @param treeNode
     * @return
     */
    int TreeDepth(TreeNode treeNode) {
        int leftDep, rightDep;
        if (treeNode == null) {
            return 0;
        } else {
            leftDep = TreeDepth(treeNode.leftNode);
            rightDep = TreeDepth(treeNode.rightNode);

            Log.e("Tree", "leftDep == " + leftDep);
            Log.e("Tree", "rightDep == " + rightDep);

            //取最大深度
            return 1 + Math.max(leftDep, rightDep);

        }
    }

    /**
     * 清空二叉树
     *
     * @param treeNode
     */
    void clearTree(TreeNode treeNode) {
        if (treeNode != null) {
            clearTree(treeNode.leftNode);//清空左子树
            clearTree(treeNode.rightNode);//清空右子树
            treeNode = null;//释放父节点
        }
    }

    /**
     * 显示结点数据
     *
     * @param treeNode
     */
    void TreeNodeData(TreeNode treeNode) {
        Log.d("Tree ", treeNode.data);
    }

    /**
     * 按层遍历
     *
     * @param treeNode
     */
    void LevelTree(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (treeNode != null) {
            queue.offer(treeNode);//将根节点入队
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
     * 先序遍历二叉树  先访问根结点，再按先序遍历左子树，最后按先序遍历右子树
     *
     * @param treeNode
     */
    void DLRTree(TreeNode treeNode) {
        if (treeNode != null) {
            TreeNodeData(treeNode);//输出结点数据
            DLRTree(treeNode.leftNode);//遍历左子树
            DLRTree(treeNode.rightNode);//遍历右子树
        }
    }

    /**
     * 中序遍历二叉树 先按中序遍历左子树，再访问跟结点，最后按照中序遍历右子树
     *
     * @param treeNode
     */
    void LDRTree(TreeNode treeNode) {
        if (treeNode != null) {
            LDRTree(treeNode.leftNode);//按照中序遍历左子树
            TreeNodeData(treeNode);//显示根节点数据
            LDRTree(treeNode.rightNode);//按照中序遍历右子树
        }
    }

    /**
     * 后序遍历二叉树 先按后序遍历左子树，再按后序遍历右子树，最后再访问根节点
     *
     * @param treeNode
     */
    void LRDTree(TreeNode treeNode) {
        if (treeNode != null) {
            LRDTree(treeNode.leftNode);//按后序遍历左子树
            LRDTree(treeNode.rightNode);//按后序遍历右子树
            TreeNodeData(treeNode);//显示节点数据
        }
    }

    /**
     * 先序遍历，非递归
     *
     * @param treeNode
     */
    /**
     * 先序遍历（非递归）
     * 根据先序遍历的访问的顺序，先访问根节点，然后再访问左子树和右子树。对于树中的任意一个节点，都可以看做是一个根节点（也可以看成是一个树），因此可以直接访问根节点，访问完根节点，如果它的左子树不为空，用相同的方法访问它的左子树，直到左子树为空，再访问它的右子树。
     * 对于树中的任意一个节点node:
     * （1）访问node,并将节点入栈；
     * （2）判断节点node的左孩子是否为空.若不为空，则将p的左孩子置为当前的结点node;
     * （3）若为空，则取栈顶节点并进行出栈操作（根据出栈节点去找该节点的右孩子），并将栈顶结点的右孩子置为当前的结点node，循环至1);
     *
     * @param rootNode
     */
    void DLRTree2(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<>();//定义栈用于存放节点
        while (rootNode != null || !stack.isEmpty()) {
            while (rootNode != null) {
                Log.e("DLRTree2", rootNode.data);//显示节点数据
                stack.push(rootNode);//将节点入栈
                rootNode = rootNode.leftNode;//将当前结点置为左结点
            }
            //当p为空时，需要切换到父父节点的右结点
            if (!stack.empty()) {
                rootNode = stack.pop();//将当前结点出栈，回到父结点的位置
                rootNode = rootNode.rightNode;//将当前结点置为右结点
            }
        }
    }

//    /**
//     * 中序遍历二叉树（非递归）
//     *
//     * @param rootNode
//     */
//    void LDRTree2(TreeNode rootNode) {
//        Stack<TreeNode> stack = new Stack<>();//创建栈
//        while (!stack.isEmpty() || rootNode != null) {
//            if (rootNode != null) {//先把所有的左节点放入栈中
//                Log.e("node ", rootNode.data);
//                stack.push(rootNode);//将结点入栈 A B D E C F
//                rootNode = rootNode.leftNode;//将左结点置为当前结点
//            } else {
//                rootNode = stack.pop();//获取父节点  出栈顺序 D B A
//                Log.e("Tree", rootNode.data);//显示节点数据
//                rootNode = rootNode.rightNode;//进入右节点
//            }
//        }
//    }

    /**
     * 中序遍历二叉树（非递归）
     *
     * @param rootNode
     */
    public void LDRTree2(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<>();//创建栈
        while (rootNode != null || !stack.empty()) {
            while (rootNode != null) {//先把所有的左节点放入栈中
                stack.push(rootNode);//将结点入栈 A B D E C F
                rootNode = rootNode.leftNode;//将左结点置为当前结点
            }
            if (!stack.empty()) {
                rootNode = stack.pop();//获取父节点  出栈顺序 D B A
                Log.e("Tree", rootNode.data + "   ");//显示节点数据
                rootNode = rootNode.rightNode;//进入右节点
            }
        }
    }


    /**
     * 后序遍历二叉树（非递归）
     */
    public void LRDTree2(TreeNode rootNode) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while (rootNode != null || !stack1.empty()) {
            while (rootNode != null) {
                stack1.push(rootNode);
                stack2.push(0);
                rootNode = rootNode.leftNode;
            }

            while (!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.print(stack1.pop().data + "   ");
            }

            if (!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                rootNode = stack1.peek();
                rootNode = rootNode.rightNode;
            }
        }
    }


    /**
     * 建立二叉树
     *
     * @param treeNode
     */
    void createTree(TreeNode treeNode) {

    }
}
