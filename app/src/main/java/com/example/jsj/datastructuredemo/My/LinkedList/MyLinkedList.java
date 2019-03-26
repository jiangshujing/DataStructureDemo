package com.example.jsj.datastructuredemo.My.LinkedList;

import android.util.Log;

import com.example.jsj.datastructuredemo.My.LinkedList.bean.Data;
import com.example.jsj.datastructuredemo.My.LinkedList.bean.Node;

/**
 * Created by jiangshujing on 2018/1/23.
 * 单链表
 */

public class MyLinkedList {

    String Tag = MyLinkedList.class.getSimpleName();

    /**
     * 追加尾节点
     *
     * @param head
     * @param nodeData return 返回链表的head
     */
    public Node addEndNode(Node head, Data nodeData) {
        //创建新节点
        Node newNode = new Node();
        if (newNode == null) {
            Log.d("Tag", "申请内存失败");
            return null;
        }

        newNode.data = nodeData;//设置尾节点的数据
        newNode.nextNode = null;//设置尾节点的引用，为null

        //处理特殊情况 --- 如果头结点就是尾节点
        if (head == null) {
            head = newNode;
            return head;
        }
        //要找到尾节点的位置
        Node tempNode = head; //保存临时Node
        while (tempNode != null) {
            tempNode = tempNode.nextNode;
        }

        tempNode.nextNode = newNode;//指向最后一个node
        return head;

    }


    /**
     * 添加节点到第一个位置
     *
     * @param head
     * @param nodeData
     */
    public Node addFirstNode(Node head, Data nodeData) {
        //创建新节点
        Node newNode = new Node();
        if (newNode == null) {
            Log.d(Tag, "申请内存失败");
            return null;
        }

        newNode.data = nodeData;//设置节点数据
        newNode.nextNode = head.nextNode;//指向头引用指向的节点
        head.nextNode = newNode;//头引用指向新节点
        return head;
    }


    /**
     * 查找节点
     *
     * @param head
     * @param key
     * @return
     */
    public Node findNode(Node head, String key) {

        Node tempNode = head;//存储临时节点
        while (tempNode != null) {//遍历所有节点
            if (tempNode.data.key == key || key.equals(tempNode.data.key)) {
                return tempNode;
            }
            tempNode = tempNode.nextNode;
        }
        return null;
    }

    /**
     * 插入节点到关键字findKey所在的节点后面
     *
     * @param head
     * @param findKey
     * @param nodeData
     * @return
     */
    public Node insertNode(Node head, String findKey, Data nodeData) {

        //创建新节点
        Node newNode = new Node();
        if (newNode == null) {
            Log.d(Tag, "申请内存失败");
            return null;
        }

        newNode.data = nodeData;//保存节点内存
        //查找要插入到哪个节点后面，通过key来查找节点
        Node findNode = findNode(head, findKey);
        if (findNode != null) {
            //进行插入节点
            newNode.nextNode = findNode.nextNode;//新节点所指向的节点是findNode节点所指向的
            findNode.nextNode = newNode; //更新findNode节点所指向的节点：应该指向新插入的节点
        } else {
            Log.d(Tag, "未找到插入的位置");
            newNode = null;//释放内存
        }

        return head;//返回头引用
    }

    /**
     * 删除节点
     *
     * @param head
     * @param key
     * @return
     */
    public int deleteNode(Node head, String key) {
        Node tempNode = head;
        Node beforeNode = head;
        while (tempNode != null) {//遍历链表
            if (tempNode.data.key.equals(key)) {
                //删除此节点，就是更改前一个节点的引用
                beforeNode.nextNode = tempNode.nextNode;
                return 1;
            } else {
                beforeNode = tempNode;
                tempNode = tempNode.nextNode;
            }
        }
        return 0;
    }


    /**
     * 链表的长度
     *
     * @param head
     * @return
     */
    public int size(Node head) {
        Node tempNode = head;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.nextNode;
        }

        return count;
    }


    /**
     * 链表翻转
     *
     * @return
     */
    public Node LinkedReversal(Node head) {

        Node pre = head;//前一个node
        Node cur = head.nextNode;//当前的node
        Node temp;//下一个node

        while (cur != null) {
            temp = cur.nextNode;

            //修改翻转后的指向
            cur.nextNode = pre;
            pre = cur;
            cur = temp;
        }

        head.nextNode = null;//头变成尾
        return pre;
    }

    //https://blog.csdn.net/fx677588/article/details/72357389
    public Node LinkedReversal3(Node head) {
        if (head == null || head.nextNode == null)       //链表为空直接返回，而H->next为空是递归基
            return head;

        Node p = head;
        Node newHead = null;//新链表的头指针

        while (p != null) { //一直迭代到链尾
            Node temp = p.nextNode; //暂存p下一个地址，防止变化指针指向后找不到后续的数
            p.nextNode = newHead; // 进行翻转
            newHead = p;  //新链表的头移动到p，扩长一步链表
            p = temp;     //p指向原始链表p指向的下一个空间
        }
        return newHead;
    }


    public Node LinkedReversal2(Node head) {
        if (head == null || head.nextNode == null)       //链表为空直接返回，而H->next为空是递归基
            return head;
        Node newHead = LinkedReversal2(head.nextNode); //一直循环到链尾
        head.nextNode.nextNode = head;                       //翻转链表的指向
        head.nextNode = null;                          //记得赋值NULL，防止链表错乱
        return newHead;                          //新链表头永远指向的是原链表的链尾
    }


    public Node ReverseList(Node head) {
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        if (head == null) return null;
        Node pre = null;
        Node next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while (head != null) {
        //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
        //如此就可以做到反转链表的效果
        //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.nextNode;
        //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.nextNode = pre;
        //head指向pre后，就继续依次反转下一个节点
        //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;

    }

}
