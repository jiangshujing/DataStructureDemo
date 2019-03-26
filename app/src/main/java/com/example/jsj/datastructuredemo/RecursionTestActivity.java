package com.example.jsj.datastructuredemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jsj.datastructuredemo.My.RecursionTest;
import com.example.jsj.datastructuredemo.My.sort.SortTest;

/**
 * Created by jiangshujing on 2018/1/24.
 * 测试递归
 */

public class RecursionTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        int arr[] = {1,1,1,1,1,1,1,1,1,0,1};
        Log.e("RecursionTestActivity  ", "假币的index 为：" + RecursionTest.falseCoin(arr, 0, arr.length - 1));
        Log.e("RecursionTestActivity  ", "一年后兔子的对数 为：" + RecursionTest.fibonacci(12));


    }
}
