package com.example.administrator.recyclerviewactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btn_add;
    private Button btn_delete;
    private Button btn_list;
    private Button btn_grid;
    private Button btn_flow;
    private RecyclerView recyclerView;
    private TextView textView;
    private TextView tv_title;
    private ArrayList<String> datas;
    private MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        //设置RecyclerView的适配器
        adapter = new MyRecyclerViewAdapter(MainActivity.this,datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i=0; i<100; i++){
            datas.add("content");
        }//准备数据集合
    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete=(Button) findViewById(R.id.btn_deleta);
        btn_list=(Button) findViewById(R.id.btn_List);
        btn_grid=(Button) findViewById(R.id.btn_grid);
        btn_flow=(Button) findViewById(R.id.btn_flow);
        recyclerView = (RecyclerView) findViewById( R.id.recyclerview);
        tv_title = (TextView) findViewById( R.id.tv_title );
        tv_title.setText( "RecyclerView" );
        //设置点击事件
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener( this );
        btn_list.setOnClickListener( this );
        btn_grid.setOnClickListener( this );
        btn_flow.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.btn_add:
               adapter.addData(0,"New_Content");
               recyclerView.scrollToPosition(0);
               break;
               case R.id.btn_deleta:
                   adapter.removeData(0);
                   break;
               case R.id.btn_List:
                   recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                   break;
               case  R.id.btn_grid:
                   //设置grid类型效果
                   recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2,GridLayoutManager.HORIZONTAL,false));
break;
               case R.id.btn_flow:
                   //设置瀑布流类型效果
                   recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                   break;
           }
    }
}
