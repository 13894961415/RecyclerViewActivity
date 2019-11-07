package com.example.administrator.recyclerviewactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/11/7.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHodler>{

    private Context contest;
    private  ArrayList <String> datas;



    public MyRecyclerViewAdapter( Context context, ArrayList <String> datas) {
        this.contest= context;
        this.datas=datas;
    }



    //    相当于getview方法中创建view和viewHolder


    @Override
    public MyViewHodler onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = View.inflate( contest,R.layout.item_recyclerview,null );
        return new MyViewHodler( itemView );

    }

//    相当于getview绑定数据部分的代码
//数据和view绑定

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler Hodler, int position) {
//        根据位置等到对应的数据
        String data = datas.get( position );

    }


//得到总条数

    @Override
    public int getItemCount() {
        return datas.size();
    }
    //添加数据
    public void addData(int position, String data) {
        datas.add(position,data);
        notifyItemInserted(position);


    }


    //移除数据
    public void removeData(int position) {
        datas.remove( position );
//        刷新适配器
        notifyItemRemoved( position );
    }


    class  MyViewHodler extends  RecyclerView.ViewHolder{
        private ImageView iv_icon;
        private TextView tv_title;

        public MyViewHodler(@NonNull View itemView) {
            super( itemView );
            iv_icon = (ImageView) itemView.findViewById( R.id.ic_icon);
            tv_title = (TextView)itemView.findViewById( R.id.tv_title );
        }
    }
}
