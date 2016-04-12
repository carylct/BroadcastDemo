package com.example.administrator.mytest20176_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by LCT
 * Time:2016/4/7 14:30.
 * Annotation：动态注册广播
 */
public class SendMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout=new LinearLayout(this);
        Button button=new Button(this);
        layout.addView(button);
        button.setGravity(Gravity.CENTER);
        button.setText("发送");
        setContentView(layout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.ACTION_NAME);
                mIntent.putExtra("yaner", "发送广播，相当于在这里传送数据");
                sendBroadcast(mIntent);
            }
        });
    }
}
