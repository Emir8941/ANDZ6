package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText etTitle, etDescription;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etTitle =findViewById(R.id.et_title);
        etDescription =findViewById(R.id.et_description);
        btnSave =findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
            if (!title.isEmpty()&&!description.isEmpty()){
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("description",description);
                setResult(RESULT_OK,intent);
                Log.e("TAG","onClick"+title+description);
                finish();
            }else {
                etTitle.setError("Введите title");
                etDescription.setError("Введите Desc");
            }
            }
        });


    }
}