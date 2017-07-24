package com.brioal.librarylearning.bottomlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brioal.bottomtab.entity.TabEntity;
import com.brioal.bottomtab.interfaces.OnTabSelectedListener;
import com.brioal.bottomtab.view.BottomLayout;
import com.brioal.librarylearning.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomLayoutActivity extends AppCompatActivity {

    @BindView(R.id.bottom_btn_add)
    Button mBtnAdd;
    @BindView(R.id.bottom_tablayout)
    BottomLayout mTablayout;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_bottom_layout);
        ButterKnife.bind(this);
        initAction();
        initView();
    }

    private void initAction() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTablayout != null) {
                    mTablayout.setNews(10, 0);
                    mTablayout.setNews(10, 1);
                    mTablayout.setNews(10, 2);
                    mTablayout.setNews(10, 3);
                    mTablayout.setNews(10, 4);
                }
            }
        });
    }

    private void initView() {
        List<TabEntity> list = new ArrayList<>();
        list.add(new TabEntity(R.mipmap.icon_1, "推荐"));
        list.add(new TabEntity(R.mipmap.icon_2, "游戏"));
        list.add(new TabEntity(R.mipmap.icon_3, "软件"));
        list.add(new TabEntity(R.mipmap.icon_4, "应用圈"));
        list.add(new TabEntity(R.mipmap.icon_5, "管理"));
        mTablayout.setList(list);
        mTablayout.setColorNormal(Color.parseColor("#000000"));
        mTablayout.setColorSelect(getResources().getColor(R.color.colorAccent));
        mTablayout.setNews(10, 0);
        mTablayout.setNews(10, 1);
        mTablayout.setNews(10, 2);
        mTablayout.setNews(10, 3);
        mTablayout.setNews(10, 4);
        mTablayout.setSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int i) {
                mTablayout.cleanNews(i);
                showToast(i + "");
            }
        });
    }

    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(BottomLayoutActivity.this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
