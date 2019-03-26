package com.example.jsj.datastructuredemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jsj.datastructuredemo.My.LinkedList.MergeLinkedList;
import com.example.jsj.datastructuredemo.My.LinkedList.MyLinkedList;
import com.example.jsj.datastructuredemo.My.LinkedList.bean.Data;
import com.example.jsj.datastructuredemo.My.LinkedList.bean.Node;
import com.example.jsj.datastructuredemo.structures.Tree.BinaryTree.BinaryNode;
import com.example.jsj.datastructuredemo.structures.Tree.BinaryTree.BinarySearchTree;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testPreList();
        testLinkedReversal();
//        initView();
//        mergeLinkedList();
    }

    /**
     * 先根遍历
     */
    private void testPreList() {
        String[] preList = {"A", "B", "D", "G", "C", "E", "F", "H"};
        String[] inList = {"D", "G", "B", "A", "E", "C", "H", "F"};
        //构建二叉树结构数据
        BinarySearchTree<String> cbtree = new BinarySearchTree<String>(preList, inList, true);
        Log.d("", "树的结构如下:");
        cbtree.print();
        //先根遍历二叉树
//        Log.d("先根遍历:", cbtree.preOrder());
//        Log.d("中根遍历:", cbtree.inOrder());
//        Log.d("后根遍历:", cbtree.postOrder());

        //从根节点开始
        Log.d("先根遍历:", preOrder(cbtree.getRoot()));
//        Log.d("阶乘:", String.valueOf(factorial(10)));

    }


    /**
     * 先根遍历
     * 遍历规则 根节点 左子树 右子树
     *
     * @param node
     */
    private String preOrder(BinaryNode<String> node) {
        StringBuilder sb = new StringBuilder();
        //终止条件是遍历到节点为null
        if (node != null) {
            //先根节点
            sb.append(node.data).append(",");
            //左子树
            sb.append(preOrder(node.left));

            //右子树
            sb.append(preOrder(node.right));
        }

        return sb.toString();
    }

    /**
     * 中根遍历
     * 遍历规则 先左子树 根节点 右子树
     *
     * @param node
     * @return
     */
    private String inOrder(BinaryNode<String> node) {

        StringBuilder sb = new StringBuilder();
        //终止条件node为null
        if (node != null) {
            //先左子树
            sb.append(inOrder(node.left));
            //再根节点
            sb.append(node.data).append(",");
            //再右子树
            sb.append(inOrder(node.right));
        }

        return sb.toString();
    }


    /**
     * 后根遍历
     * 遍历规则 先左子树 再右子树 根节点
     *
     * @param node
     * @return
     */
    private String postOrder(BinaryNode<String> node) {

        StringBuilder sb = new StringBuilder();
        //结束条件 node等于null
        if (node != null) {
            //先左子树
            sb.append(postOrder(node.left));
            //再右子树
            sb.append(postOrder(node.right));
            //最后根节点
            sb.append(node.data).append(",");
        }

        return sb.toString();
    }


    private long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    /**
     * 测试
     */
    public void test() {
        Integer pre[] = {1, 2, 4, 7, 3, 5, 8, 9, 6};
        Integer in[] = {4, 7, 2, 1, 8, 5, 9, 3, 6};

        String[] preList = {"A", "B", "D", "G", "C", "E", "F", "H"};
        String[] inList = {"D", "G", "B", "A", "E", "C", "H", "F"};
        String[] postList = {"G", "D", "B", "E", "H", "F", "C", "A"};
        /**
         * 先根遍历:A,B,D,G,C,E,F,H
         * 中根遍历:D,G,B,A,E,C,H,F
         * 后根遍历:G,D,B,E,H,F,C,A
         */
        //先根/中根
//        BinarySearchTree<String> cbtree = new BinarySearchTree<>(preList,inList,true);
        //后根/中根
        BinarySearchTree<String> cbtree = new BinarySearchTree<String>(postList, inList, false);
//        BinarySearchTree<String> cbtree = new BinarySearchTree<>();
//        cbtree.printTree(cbtree.root);
//        BinarySearchTree<Integer> cbtree = new BinarySearchTree<>();
//        cbtree.insert(10);
//        cbtree.insert(40);
//        cbtree.insert(2);
//        cbtree.insert(90);
//        cbtree.insert(11);
//        cbtree.insert(9);
//        cbtree.insert(30);
//        cbtree.insert("A");
//        cbtree.insert("B");
//        cbtree.insert("C");
//        cbtree.insert("D");
//        cbtree.insert("E");
//        cbtree.insert("F");
        System.out.println("先根遍历:" + cbtree.preOrder());
//        System.out.println("非递归先根遍历:"+cbtree.preOrderTraverse());
        System.out.println("中根遍历:" + cbtree.inOrder());
//        System.out.println("非递归中根遍历:"+cbtree.inOrderTraverse());
        System.out.println("后根遍历:" + cbtree.postOrder());
//        System.out.println("非递归后根遍历:"+cbtree.postOrderTraverse());
//        System.out.println("查找最大结点(根据搜索二叉树):"+cbtree.findMax());
//        System.out.println("查找最小结点(根据搜索二叉树):"+cbtree.findMin());
//        System.out.println("判断二叉树中是否存在E:"+cbtree.contains("E"));
//        System.out.println("删除的结点返回根结点:"+cbtree.remove("E",cbtree.root).data);
//
//        System.out.println("findNode->"+cbtree.findNode("D",cbtree.root).data);
//        System.out.println("删除E结点:先根遍历:" + cbtree.preOrder());
        System.out.println("树的结构如下:");
        cbtree.print();

    }

    /**
     * 快速排序
     *
     * @param arr
     * @param start 开始下标
     * @param end   结束下标
     */
    private void quicksort(int[] arr, int start, int end) {

        /**
         * 基准值，一般是第一个
         */
        int key = arr[start];


        /**
         * 循环条件：直到start >= end
         */
        while (start < end) {

            //首先右后往前比较
            if (arr[end] < key) {//如果后面的值小于基准值，进行交换，将较小的数放到左侧
                arr[start] = arr[end];
                arr[end] = key;
            } else {//当后面的数大于参照值，那就继续往前寻找比参照值小的
                end--;
            }
        }
    }

    /**
     * 测试链表翻转
     */
    private void testLinkedReversal() {
        Node head = new Node();
        Data data = new Data();
        data.age = 0;
        head.data = data;

        Node node1 = new Node();
        Data data1 = new Data();
        data1.age = 1;
        node1.data = data1;

        Node node2 = new Node();
        Data data2 = new Data();
        data2.age = 2;
        node2.data = data2;

        Node node3 = new Node();
        Data data3 = new Data();
        data3.age = 3;
        node3.data = data3;

        Node node4 = new Node();
        Data data4 = new Data();
        data4.age = 4;
        node4.data = data4;

        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;

        Node nodeOld = head;
        while (null != nodeOld) {
            Log.e("age ===", nodeOld.data.age + "");
            nodeOld = nodeOld.nextNode;
        }


//        Node newNode = new MyLinkedList().LinkedReversal(head);
        Node newNode = new MyLinkedList().LinkedReversal3(head);

        Node nodeNew = newNode;
        while (null != nodeNew) {
            Log.e("age ===", nodeNew.data.age + "");
            nodeNew = nodeNew.nextNode;
        }
    }

    private void initView() {
        Button btnOne = (Button) findViewById(R.id.btn_one);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(MainActivity.this, ActivityOne.class);
//                startActivity(intent);
            }
        });
        Button btnTwo = (Button) findViewById(R.id.btn_two);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 合并有序链表
     */
    private void mergeLinkedList() {
        Node head = new Node();
        Data data = new Data();
        data.age = 1;
        head.data = data;

        Node node1 = new Node();
        Data data1 = new Data();
        data1.age = 3;
        node1.data = data1;

        Node node2 = new Node();
        Data data2 = new Data();
        data2.age = 7;
        node2.data = data2;

        Node node3 = new Node();
        Data data3 = new Data();
        data3.age = 9;
        node3.data = data3;

        Node node4 = new Node();
        Data data4 = new Data();
        data4.age = 22;
        node4.data = data4;

        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;

        //2
        Node head2 = new Node();
        Data data21 = new Data();
        data21.age = 2;
        head2.data = data21;

        Node node22 = new Node();
        Data data22 = new Data();
        data22.age = 5;
        node22.data = data22;

        Node node23 = new Node();
        Data data23 = new Data();
        data23.age = 8;
        node23.data = data23;

        Node node24 = new Node();
        Data data24 = new Data();
        data24.age = 10;
        node24.data = data24;

        Node node25 = new Node();
        Data data25 = new Data();
        data25.age = 11;
        node25.data = data25;

        head2.nextNode = node22;
        node22.nextNode = node23;
        node23.nextNode = node24;
        node24.nextNode = node25;


        Node newLinkedList = MergeLinkedList.merge(head, head2);

        Node temp = newLinkedList;
        while (null != temp) {
            Log.e("age ===", temp.data.age + "");
            temp = temp.nextNode;
        }

    }


}
