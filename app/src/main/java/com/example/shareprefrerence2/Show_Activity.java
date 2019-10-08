package com.example.shareprefrerence2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_Activity extends AppCompatActivity implements dat, View.OnClickListener {
    private TextView headerShow;
    private TextView contentShow;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_);
        headerShow=findViewById(R.id.header_show);
        contentShow=findViewById(R.id.content_show);
        back=findViewById(R.id.imgBack);
        Bundle bundle=getIntent().getExtras();
        headerShow.setText(arrayList.get(bundle.getInt("position")).getHeader());
        contentShow.setText(arrayList.get(bundle.getInt("position")).getContent());
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Show_Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
