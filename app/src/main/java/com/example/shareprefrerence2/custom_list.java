package com.example.shareprefrerence2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class custom_list extends ArrayAdapter implements dat {
    private Context context;
    private int resource;
    private ArrayList<Keep> arrayKeep;
    public custom_list(Context context, int resource, ArrayList<Keep> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrayKeep=objects;
    }
    public class ViewHolder{
        TextView header;
        TextView content;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        viewHolder.header=convertView.findViewById(R.id.header);
        viewHolder.content=convertView.findViewById(R.id.content);
        convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.header.setText(arrayKeep.get(position).getHeader());
        viewHolder.content.setText(arrayKeep.get(position).getContent());

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context,"alooo",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return convertView;
    }

}
