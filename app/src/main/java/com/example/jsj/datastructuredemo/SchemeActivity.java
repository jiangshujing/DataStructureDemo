package com.example.jsj.datastructuredemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by jiangshujing on 2018/1/24.
 */

public class SchemeActivity extends Activity {

    /**
     * 商品id
     */
    private String mGoodId;

    //商户id
    private int mSellerId;

    /**
     * 0是生活 1是商城
     */
    private int isMall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        //从Scheme 获取商家信息
        String action = intent.getAction();
        String scheme = intent.getScheme();
        Uri uri = intent.getData();
//        LogUtils.d("action:" + action);
//        LogUtils.d("scheme:" + scheme);
//        LogUtils.d("uri:" + uri);
        if (null != uri) {
            mGoodId = uri.getQueryParameter("good_id");
            //商户id
            mSellerId = Integer.parseInt(uri.getQueryParameter("seller_id"));
            isMall = Integer.parseInt(uri.getQueryParameter("isMall"));
//            LogUtils.d("good_id:" + mGoodId);
//            LogUtils.d("seller_id:" + mSellerId);
//            LogUtils.d("isMall:" + isMall);
            Intent intent1;
            if (isMall == 0) {
                intent1 = new Intent(SchemeActivity.this, SortTestActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putInt(Constant.SELLER_ID, mSellerId);
//                bundle.putInt(Constant.GOODS_ID, mGoodId);
//                intent1.putExtra(Constant.SELLER_ID, mSellerId);//商户id
//                intent1.putExtra(Constant.GOODS_ID, Integer.valueOf(mGoodId).intValue());//商品id
            } else {
                intent1 = new Intent(SchemeActivity.this, SortTestActivity.class);
//                intent1.putExtra(Constant.SELLER_ID, mSellerId);//商户id
//                intent1.putExtra(Constant.GOODS_ID, Integer.valueOf(mGoodId).intValue());//商品id
            }
            startActivity(intent1);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        LogUtils.d("onNewIntent");
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}