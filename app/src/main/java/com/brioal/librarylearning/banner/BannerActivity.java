package com.brioal.librarylearning.banner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.brioal.bannerview.BannerBean;
import com.brioal.bannerview.BannerView;
import com.brioal.bannerview.LineIndexView;
import com.brioal.bannerview.OnBannerClickListener;
import com.brioal.bannerview.PicConfig;
import com.brioal.librarylearning.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerActivity extends AppCompatActivity {

    @BindView(R.id.banner_bannerView1)
    BannerView mBannerView1;
    @BindView(R.id.banner_bannerView2)
    BannerView mBannerView2;

    private Toast mToast;
    List<BannerBean> list1 = new ArrayList<>();
    List<BannerBean> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_banner);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        list1.clear();
        list1.add(new BannerBean("http://img2.niutuku.com/desk/1208/1510/ntk-1510-24060.jpg", "图片1", "231"));
        list1.add(new BannerBean("http://img2.niutuku.com/desk/1212/2236/2236-ntk35334.jpg", "图片2", "1231"));
        list1.add(new BannerBean("http://img2.niutuku.com/desk/130220/56/56-niutuku.com-261.jpg", "图片3", "3123"));
        list1.add(new BannerBean("http://bizhi.zhuoku.com/2013/08/22/zhuoku/zhuoku050.jpg", "图片4", "3123"));
        list1.add(new BannerBean("http://img2.niutuku.com/desk/130220/37/37-niutuku.com-927.jpg", "图片5", "12312"));

        list2.clear();
        list2.add(new BannerBean("http://img2.niutuku.com/desk/1207/1005/ntk122731.jpg", "图片1", "231"));
        list2.add(new BannerBean("http://img2.niutuku.com/desk/1208/2150/ntk-2150-41037.jpg", "图片2", "1231"));
        list2.add(new BannerBean("http://bizhi.zhuoku.com/2010/03/28/jingxuan/jingxuan099.jpg", "图片3", "3123"));
        list2.add(new BannerBean("http://bizhi.zhuoku.com/2013/05/27/zhuoku/zhuoku189.jpg", "图片4", "3123"));
        list2.add(new BannerBean("http://www.3dmgame.com/uploads/allimg/1401", "图片5", "12312"));
    }

    private void initView() {
        //Banner1
//        DefaultIndexView defaultIndexView = new DefaultIndexView(BannerActivity.this);
//        defaultIndexView.setPointSize(8).setColorNormal(Color.BLACK).setColorSelect(Color.RED);
//        mBannerView1.initViewPager(list1, 900, new OnBannerClickListener() {
//            @Override
//            public void click(BannerBean bannerBean, int i) {
//                showToast("点击了" + bannerBean.getIndex());
//            }
//        }).initIndex(defaultIndexView).setGallery(true).build(getSupportFragmentManager());
        //Banner2
        PicConfig.FAILED_PIC = R.mipmap.ic_default_pic;
        mBannerView2.initViewPager(list2, 2000, new OnBannerClickListener() {
            @Override
            public void click(BannerBean bean, int position) {
                showToast(position + "");
            }
        })
                .initIndex(new LineIndexView(this, 9).setLineColor(Color.RED)).setGallery(true)
                .build(getSupportFragmentManager());
    }

    private void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
