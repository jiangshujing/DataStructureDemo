package com.example.jsj.datastructuredemo.My.LinkedList;

import com.example.jsj.datastructuredemo.My.LinkedList.bean.Node;

/**
 * Created by jiangshujing on 2018/3/19.
 * 合并两个有序链表
 */

public class MergeLinkedList {


    public static Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        //新的链表
        Node result;

        if (a.data.age < b.data.age) {
            result = a;
            result.nextNode = merge(a.nextNode, b);
        } else {
            result = b;
            result.nextNode = merge(b.nextNode, a);
        }

        return result;

    }
}
