package com.example.administrator.mytest20176_4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * 只有在当前接收类没有被销毁时才会接收到消息
     * 在销毁activity时要在onDestroy取消注册广播
     */
    public static final String ACTION_NAME = "动态发送广播";
    /**
     * 发送静态的广播
     * app安装成功后就会注册，也可以注册监听一些系统的广播如：
     * Intent.ACTION_BOOT_COMPLETED //系统启动完成
     * Intent.ACTION_MEDIA_MOUNTED //SD卡挂载
     * Intent.ACTION_MEDIA_UNMOUNTED //SD卡卸载
     *Intent.ACTION_USER_PRESENT//解除锁屏
     * ConnectivityManager.CONNECTIVITY_ACTION//网络状态变化
     *
     * 也可以注册自定义的广播
     */
    public static final String ACTION_STATIC_NAME = "static_broadcast";
    private Button mBtnMsgEvent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        Button button = new Button(this);
        layout.addView(button);
        button.setGravity(Gravity.CENTER);
        button.setText("去发送动态的广播发送");

        Button button1 = new Button(this);
        layout.addView(button1);
        button1.setGravity(Gravity.CENTER);
        button1.setText("发送一个静态的广播");

        setContentView(layout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this, SendMessageActivity.class);
                startActivity(inten);
                finish();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.ACTION_NAME);
                mIntent.putExtra("yaner", "发送静态的广播，相当于在这里传送数据");
                sendBroadcast(mIntent);
            }
        });
        registerBoradcastReceiver();
    }

    /**
     * 注册广播
     */
    public void registerBoradcastReceiver() {
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction(ACTION_NAME);
        registerReceiver(mBroadcastReceiver, myIntentFilter);
    }

    public BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ACTION_NAME)) {
                Bundle bundle = intent.getExtras();
                String data = bundle.getString("yaner");
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 移除广播注册
         * 目的是回收内存
         */
        unregisterReceiver(mBroadcastReceiver);
    }
}
