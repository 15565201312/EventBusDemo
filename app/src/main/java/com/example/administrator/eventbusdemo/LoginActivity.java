package com.example.administrator.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.but_send_message)
    Button butSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        //发送数据
        initData();
    }

    private void initData() {

       butSendMessage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               MessageBean messageBean = new MessageBean();
               messageBean.setTime(11);
               messageBean.setContent("测试内容1");
               messageBean.setSelect(false);
               List<String> mlist = new ArrayList<>();

               for (int i = 1; i <10; i++) {
                   mlist.add("测试"+i);
               }
               messageBean.setMlist(mlist);
               MessageBean.User user = new MessageBean.User();
               user.setUsetName("张三");
               user.setUserPsw("123213");
               //添加发送
               EventBus.getDefault().post(messageBean);
               finish();
           }
       });
    }
}
