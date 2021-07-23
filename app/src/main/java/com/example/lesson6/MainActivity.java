package com.example.lesson6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    Button btnOpenSecondScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_items);
        btnOpenSecondScreen = findViewById(R.id.btn_open_second_screen);
        List<TaskModel> list = new ArrayList<>();
        adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);


        btnOpenSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK)
            if (data != null) {
                TaskModel taskModel = new TaskModel(data.getStringExtra("title"), data.getStringExtra("description"));
                Toast.makeText(this, "" + data.getStringExtra("title")
                        + data.getStringExtra("description"), Toast.LENGTH_SHORT).show();
                adapter.addTask(taskModel);


            }
    }
}