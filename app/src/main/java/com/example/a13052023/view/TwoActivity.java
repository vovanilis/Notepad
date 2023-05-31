package com.example.a13052023.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.a13052023.R;
import com.example.a13052023.model.Notebook;
import com.example.a13052023.viewmodel.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageButton fabAdd;
    List<Notebook> notesList;
    DatabaseHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        recyclerView = findViewById(R.id.recycle_list);
        fabAdd = findViewById(R.id.fabAdd);
        notesList = new ArrayList<>();
        database = new DatabaseHelper(this);
    }
}