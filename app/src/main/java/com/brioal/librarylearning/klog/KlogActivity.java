package com.brioal.librarylearning.klog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.brioal.librarylearning.R;
import com.socks.library.KLog;

public class KlogActivity extends AppCompatActivity {
    private String json = "{\"errorMsg\":null,\"data\":[{\"name\":\"123\",\"id\":1500430807872,\"userid\":1500428042066},{\"name\":\"456\",\"id\":1500430807899,\"userid\":1500428042066},{\"name\":\"未分类\",\"id\":1500430807845,\"userid\":1500428042066}],\"success\":false}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_klog);
    }

    public void log1(View view) {
        KLog.e();
    }

    public void log2(View view) {
        KLog.e("Test Error");
    }

    public void log3(View view) {
        KLog.e("Klog", "Test Error");
    }

    public void log4(View view) {
        System.out.println(json);
        Log.e("Klog", json);
        KLog.json(json);
    }

    public void log5(View view) {
        KLog.json("Klog",json);
    }
}
