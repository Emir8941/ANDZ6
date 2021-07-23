package com.example.lesson6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    List<TaskModel> list;

    public RecyclerAdapter(List<TaskModel> list) {
        this.list = list;
    }
    public void addTask(TaskModel model){
        this.list.add(model);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent ,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
       holder.txtTitle.setText(list.get(position).getTitle());
       holder.txtDescription.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescription;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
        txtTitle = itemView.findViewById(R.id.item_title_txt);
        txtDescription = itemView.findViewById(R.id.item_description_txt);
        }
    }
}
