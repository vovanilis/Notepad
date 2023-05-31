package com.example.a13052023.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a13052023.R;
import com.example.a13052023.viewmodel.DatabaseHelper;

public class UpdateActivity extends AppCompatActivity {
    EditText title, description;
    Button update_note, delete_note;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        update_note = findViewById(R.id.update_note);
        delete_note = findViewById(R.id.delete_note);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("description"));
        id = intent.getStringExtra("id");

        update_note.setOnClickListener(listener);
        delete_note.setOnClickListener(listener);
    }

    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!TextUtils.isEmpty(title.getText().toString()) &&
                    !TextUtils.isEmpty(description.getText().toString())) {
                DatabaseHelper database = new DatabaseHelper(UpdateActivity.this);
                switch (v.getId()) {
                    case R.id.update_note:
                        database.updateNotes(title.getText().toString(),
                                description.getText().toString(), id);
                        break;
                    case R.id.delete_note:
                        database.deleteSingleItem(id);
                        break;
                }
                startActivity(new Intent(UpdateActivity.this, TwoActivity.class));
            } else {

            }
        }
    };
}