package com.example.shareprefrerence2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Activity extends AppCompatActivity implements View.OnClickListener,dat {
    static final String SHARED_PREFERENCES_NAME="620woaini";
    private Button bttEnter;
    private Button bttCancle;
    private EditText header_edit;
    private EditText content_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);
        bttEnter=findViewById(R.id.btt_enter);
        bttCancle=findViewById(R.id.btt_cancle);
        header_edit=findViewById(R.id.header_edit);
        content_edit=findViewById(R.id.content_edit);
        bttEnter.setOnClickListener(this);
        bttCancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btt_enter: {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int pos = sharedPreferences.getInt("count", 0);
                editor.putString("header" + pos, header_edit.getText().toString());
                editor.putString("content" + pos, content_edit.getText().toString());
                editor.putInt("count", pos + 1);
                editor.apply();
                intent = new Intent(Add_Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btt_cancle: {
                intent = new Intent(Add_Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            }

        }
    }
}
