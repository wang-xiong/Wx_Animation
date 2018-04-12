package com.baidu.duer.dcs.wx_animation.Wx;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 *LayoutInflater的作用：内部是利用pull解析
 *每一个视图的绘制分为三个阶段：onMeasure(), onLayout(), onDraw()
 *自定义View分为三种：
 * 自绘控件:重写onDraw()方法，见MyView1
 * 组合控件：例如TitleView
 * 继承控件: 例如MyListView
 *
 *
 */



public class Main3Activity extends Activity {
    private LinearLayout root_layout;
    private MyListView myListView;
    private MyAdapter myAdapter;
    private List<String> contentList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
      /*  root_layout = (LinearLayout) findViewById(R.id.root_layout);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View buttonLayout = layoutInflater.inflate(R.layout.button_layout, null);
        root_layout.addView(buttonLayout);*/
        initList();
        myListView = (MyListView) findViewById(R.id.my_listView);
        myListView.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                myAdapter.notifyDataSetChanged();;
            }
        });
        myAdapter = new MyAdapter(this, 0, contentList);
        myListView.setAdapter(myAdapter);
    }
    private void initList() {
        contentList.add("Content Item 1");
        contentList.add("Content Item 2");
        contentList.add("Content Item 3");
        contentList.add("Content Item 4");
        contentList.add("Content Item 5");
        contentList.add("Content Item 6");
        contentList.add("Content Item 7");
        contentList.add("Content Item 8");
        contentList.add("Content Item 9");
        contentList.add("Content Item 10");
        contentList.add("Content Item 11");
        contentList.add("Content Item 12");
        contentList.add("Content Item 13");
        contentList.add("Content Item 14");
        contentList.add("Content Item 15");
        contentList.add("Content Item 16");
        contentList.add("Content Item 17");
        contentList.add("Content Item 18");
        contentList.add("Content Item 19");
        contentList.add("Content Item 20");
    }
}
