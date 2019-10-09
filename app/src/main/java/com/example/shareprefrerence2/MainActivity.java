package com.example.shareprefrerence2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements dat, View.OnClickListener {
    static final String SHARED_PREFERENCES_NAME="620woaini";
    private custom_list customList;
    private ListView listView;
    private ImageView imgAdd;
    private TextView count_keep;
    public Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_item);
        listView.setClipToOutline(true);
        imgAdd=findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(this);
        count_keep=findViewById(R.id.count_keep);
        //vấn đề nằm đây : setOnItemClickListener
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent = new Intent(MainActivity.this, Show_Activity.class);
                 Bundle bundle = new Bundle();
                 bundle.putInt("position", i);
                 intent.putExtras(bundle);
                 startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Alo", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    public void getData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME,MODE_PRIVATE);
        int count=sharedPreferences.getInt("count",0);
        for(int i=0;i<count;i++)
        {
            Keep keep_temp=new Keep(sharedPreferences.getString("header"+i,""),sharedPreferences.getString("content"+i,""),0);
            arrayList.add(keep_temp);
            count_keep.setText(sharedPreferences.getInt("count",0)+"");
        }
    }
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,Add_Activity.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        Log.d("A","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("A","onStop");
        arrayList.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("A","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("A","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("A","onResume");
        getData();
        customList= new custom_list(MainActivity.this,R.layout.custom_item,arrayList);
        listView.setAdapter(customList);
        Collections.reverse(arrayList);
        super.onResume();
    }
    @Override
    protected void onRestart() {
        Log.d("A","onRestart");
        super.onRestart();
    }

}
