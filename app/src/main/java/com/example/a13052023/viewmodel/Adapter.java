package com.example.a13052023.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a13052023.R;
import com.example.a13052023.model.Notebook;
import com.example.a13052023.view.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private Context context;
    private Activity activity;
    private List<Notebook> notesList, newList;

    public Adapter(Context context, Activity activity, List<Notebook> notesList) {
        this.context = context;
        this.activity = activity;
        this.notesList = notesList;
        newList = new ArrayList<>(notesList);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notesList.get(position).getTitle());
        holder.description.setText(notesList.get(position).getDescription());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("title", notesList.get(position).getTitle());
                intent.putExtra("description", notesList.get(position).getDescription());
                intent.putExtra("id", notesList.get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, description;
        ConstraintLayout mLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            mLayout = itemView.findViewById(R.id.mLayout);
        }
    }
}
