package com.example.jsj.datastructuredemo.My.LinkedList;

import android.util.Log;

import com.example.jsj.datastructuredemo.My.LinkedList.bean.SingleNode;

/**
 * 单链表实现队列
 */
public class Queue {

    private SingleNode first;//队头指针，指向队头节点
    private SingleNode last;//队尾指针，指向队尾节点

    private int size;//记录队列长度

    public Queue() {
        first = last = null;//初始位置头和尾都是 null
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    /**
     * 向对尾添加元素
     */
    public void add(int data) {
        //构建新节点
        SingleNode newNode = new SingleNode();
        newNode.data = data;

        //特殊情况处理，如果头结点就是尾节点
        if (size == 0) {
            first = newNode;
            last = first;
            size++;
            return;
        }

        last.nextNode = newNode;//连接指针
        last = newNode;//现在的最后一个节点就是新添加的这个
        size++;
    }

    /**
     * 从队头取元素
     */
    public SingleNode pull() {

        if (isEmpty()) {
            return null;
        }

        SingleNode node = first;

        //新的头部
        first = first.nextNode;
        size--;

        return node;
    }

    public void iteration() {
        SingleNode head = first;
        while (head != null) {
            Log.e("item = ", String.valueOf(head.data));
            head = head.nextNode;
        }
    }
}
