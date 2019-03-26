package com.example.jsj.datastructuredemo.My.Stack;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/1/25.
 * 栈元素
 */

public class StackType {

    String Tag = StackType.class.getSimpleName();

    /**
     * 栈结构的最大长度
     */
    int MAXLEN = 50;
    Data[] data = new Data[MAXLEN];

    /**
     * 栈顶序号
     */
    int top;

    /**
     * 初始化栈
     *
     * @return
     */
    public StackType init() {
        StackType stackTop = new StackType();
        if (stackTop != null) {
            stackTop.top = 0; //设置栈顶为0，为0说明是空栈
            return stackTop;  //返回指向栈的引用
        }
        return null;
    }

    /**
     * 判断栈是否为空栈
     *
     * @return
     */
    public boolean isEmpty(StackType s) {
        boolean isEmpty = false;
        if (s.top == 0) {//如果栈顶0说明是空栈
            isEmpty = true;
        }
        return isEmpty;
    }

    /**
     * 判断栈是否已满
     *
     * @param s
     * @return
     */
    public boolean isFull(StackType s) {
        boolean isFll = false;
        if (s.top == MAXLEN) {
            isFll = true;
        }
        return isFll;
    }

    /**
     * 清空栈
     *
     * @param s
     */
    public void clearStack(StackType s) {
        s.top = 0;
    }

    /**
     * 释放所占内存
     *
     * @param s
     */
    public void free(StackType s) {
        if (s != null)
            s = null;
    }

    /**
     * 入栈
     *
     * @param s
     * @return
     */
    public int push(StackType s, Data data) {
        //判断栈中是否还有地方
        if (s.top + 1 > MAXLEN) {
            Log.d(Tag, "栈溢出");
            return 0;
        }
        s.data[++s.top] = data;
        return 1;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Data pop(StackType s) {

        //判断是否为空栈
        if (isEmpty(s)) {
            Log.d(Tag, "为空栈");
            return null;
        } else {
            return s.data[s.top--];//更改栈顶序号，并返回栈顶元素(数据元素)
        }
    }

    /**
     * 读取栈顶数据
     *
     * @param s
     * @return
     */
    public Data peek(StackType s) {
        if (isEmpty(s)) {
            Log.d(Tag, "空栈");
            return null;
        } else {
            return s.data[s.top];
        }
    }



}
