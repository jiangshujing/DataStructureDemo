package com.example.jsj.datastructuredemo.My.Queue;

/**
 * 用数组实现的队列
 * 顺序队列
 */
public class ArrayQueue {
    //数组：items,数组大小：n
    private String[] items;
    private int n = 0;
    //head 表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;


    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队 -- 插入到尾部
    public boolean enqueue(String item) {
        //如果 tail==n 表示队列已经满了
        if (tail == n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }


    /**
     * 入队 -- 插入到尾部 (解决数据搬移问题)
     * 思路 ：当队列的 tail 指针移动到数组的最右边后，如果有新的数据入队，我们可以将 head 到 tail之间的数据，整体搬移到数组中 0 到 tail-head 的位置
     * @param item
     * @return
     */
    public boolean enqueueNew(String item) {
        //如果 tail==n 表示队列已经满了
        if (tail == n) {
            //tail ==n && head==0 ,表示整个队列都占满了
            if (head == 0) return false;
            //数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            //搬移完之后重新更新head 和 tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }


    //出队 --从头部取
    public String dequeue() {
        //如果head==tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }
}
