package com.example.jsj.datastructuredemo.My.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jsj.datastructuredemo.R;

/**
 * Created by jiangshujing on 2018/1/26.
 */

public class StackTestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_tast);
        StackType st = new StackType();
        //初始化栈
        st = st.init();

        //数据
        Data data = new Data();
        data.age = 10;
        data.name = "小明";

        //入栈
        st.push(st, data);
        Log.e("top num ", st.top + "");
    }
}
