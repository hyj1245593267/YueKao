package com.example.a123.yuekao.ApapterModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a123.yuekao.Model.Student;
import com.example.a123.yuekao.R;

import java.util.List;

/**
 * Created by 123 on 2017/5/4.
 */

public class Main2listAdapter extends BaseAdapter {
    private List<Student> list;
    private Context context;

    public Main2listAdapter(List<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.main2listitem,null);
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.content= (TextView) convertView.findViewById(R.id.content);
            holder.price= (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getId()+"");
        holder.content.setText(list.get(position).getContent());
        return convertView;
    }
    class ViewHolder{
        TextView name;
        TextView content;
        TextView price;
    }
}
