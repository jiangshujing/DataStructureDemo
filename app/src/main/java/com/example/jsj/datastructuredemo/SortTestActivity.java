package com.example.jsj.datastructuredemo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jsj.datastructuredemo.My.sort.SortTest;

import java.util.UUID;

/**
 * Created by jiangshujing on 2018/1/24.
 * 测试排序
 */

public class SortTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        int arr[] = {20, 9, 11, 6, 3, 13};
        int n = arr.length;
//        SortTest.insertSort(arr, n);
//        SortTest.sort(arr);
//        SortTest.quickSort(arr, 0, arr.length-1);
        SortTest.quickSort1(arr, 0, arr.length-1);

        Log.e("SortTest  ", "insertSort 最终排序结果：");
        for (int i = 0; i < n; i++) {
            Log.e("SortTest ", arr[i] + "");
        }
    }
}
