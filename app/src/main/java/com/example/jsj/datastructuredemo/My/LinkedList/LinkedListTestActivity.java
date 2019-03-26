package com.example.jsj.datastructuredemo.My.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jsj.datastructuredemo.My.LinkedList.bean.SingleNode;
import com.example.jsj.datastructuredemo.R;
import com.example.jsj.datastructuredemo.structures.Queue.LinkedQueue;

public class LinkedListTestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_tast);

        Queue queue = new Queue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Log.e("LinkedListTestActivity", "queue list");
        queue.iteration();//遍历显示

        SingleNode node = queue.pull();
        Log.e("LinkedListTestActivity", "pull node ==" + node.data);

        Log.e("LinkedListTestActivity", "queue list");
        queue.iteration();//遍历显示
    }
}
