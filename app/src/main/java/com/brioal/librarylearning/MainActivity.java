package com.brioal.librarylearning;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brioal.adtextviewlib.entity.AdEntity;
import com.brioal.adtextviewlib.view.ADTextView;
import com.brioal.circleimage.CircleImageView;
import com.brioal.librarylearning.banner.BannerActivity;
import com.brioal.librarylearning.bottomlayout.BottomLayoutActivity;
import com.brioal.librarylearning.klog.KlogActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_iv_head)
    CircleImageView mIvHead;
    @BindView(R.id.main_btn_klog)
    Button mBtnKlog;
    @BindView(R.id.main_btn_bottomTabLayout)
    Button mBtnTabLayout;
    @BindView(R.id.main_btn_banner)
    Button mBtnBanner;
    @BindView(R.id.main_adTextView)
    ADTextView mAdTextView;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initAction();
        initView();
    }


    private void initView() {
        //Glide使用
        Glide.with(MainActivity.this).load("http://img3.duitang.com/uploads/item/201606/27/20160627131933_tR8jV.jpeg").into(mIvHead);
        //AdTextView
        List<AdEntity> adList = new ArrayList<>();
        adList.add(new AdEntity("测试前缀1", "测试后缀1", "1231"));
        adList.add(new AdEntity("测试前缀2", "测试后缀2", "1232"));
        adList.add(new AdEntity("测试前缀3", "测试后缀3", "1233"));
        adList.add(new AdEntity("测试前缀4", "测试后缀4", "1234"));
        adList.add(new AdEntity("测试前缀5", "测试后缀5", "1235"));
        adList.add(new AdEntity("测试前缀6", "测试后缀6", "1236"));

        mAdTextView.setTexts(adList);
        mAdTextView.setFrontColor(Color.RED);
        mAdTextView.setBackColor(Color.BLACK);
        mAdTextView.setSpeed(3);
        mAdTextView.setInterval(1000);
        mAdTextView.setOnItemClickListener(new ADTextView.OnItemClickListener() {
            @Override
            public void onClick(String s) {
                showToast(s);
            }
        });
    }

    private void initAction() {
        //Klog
        mBtnKlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KlogActivity.class));
            }
        });
        //TabLayout
        mBtnTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BottomLayoutActivity.class));
            }
        });
        //Banner
        mBtnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
            }
        });
    }

    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    private long mCurrentTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mCurrentTime < 2000) {
            //第二次按下 并且2秒之内
            super.onBackPressed();
        } else {
            //第一次按下 / 或者离前一次超过2秒
            showToast("再按一次退出键退出");
            mCurrentTime = System.currentTimeMillis();
        }
    }
}
