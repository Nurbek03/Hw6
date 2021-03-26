package com.geek.a1_lesson5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.MainViewHolder> {
    ArrayList<RecyclerModel> list;
    Context context;
    private IFragment listener;

    public RecyclerAdapter(ArrayList<RecyclerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder( LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title_textView,subTitle_textView;
        RecyclerModel model;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title_textView = itemView.findViewById(R.id.item_txt_title);
            subTitle_textView = itemView.findViewById(R.id.item_txt_subTitle);
        }

        public void onBind(RecyclerModel recyclerModel) {
            this.model = recyclerModel;
            title_textView.setText(model.getTitle());
            subTitle_textView.setText(model.getSub_title());
        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.displayDetails(model.getTitle(),model.getSub_title());
            }
        }
    }
    public void setOnclickListener(IFragment iFragment){
        this.listener = iFragment;
    }
}
