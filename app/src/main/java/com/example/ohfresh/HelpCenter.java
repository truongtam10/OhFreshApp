package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class HelpCenter extends AppCompatActivity {

    ListView lvQuestion;
    ImageButton btnBack;
    String[] questions;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        linkViews();
        loadData();
        addEvents();
    }

    private void linkViews() {
        lvQuestion = findViewById(R.id.lvQuestion);
        btnBack = findViewById(R.id.btnBack);
    }

    private void loadData() {
        questions = getResources().getStringArray(R.array.questions);
        adapter = new ArrayAdapter<String>(HelpCenter.this, android.R.layout.simple_list_item_1,questions);
        lvQuestion.setAdapter(adapter);
    }

    private void addEvents() {
        lvQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HelpCenter.this, HelpDetail.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}