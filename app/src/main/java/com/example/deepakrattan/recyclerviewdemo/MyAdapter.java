package com.example.deepakrattan.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<SingleRow> singleRowArrayList;
    RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public MyAdapter(Context context, ArrayList<SingleRow> singleRowArrayList, RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pos) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, recyclerViewOnItemClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int pos) {
        SingleRow singleRow = singleRowArrayList.get(pos);
        String title = singleRow.getTitle();
        String desc = singleRow.getDesc();
        int image = singleRow.getImage();

        myViewHolder.txtTitle.setText(title);
        myViewHolder.txtDesc.setText(desc);
        myViewHolder.img.setImageResource(image);


    }

    @Override
    public int getItemCount() {
        return singleRowArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTitle, txtDesc;
        ImageView img;
        RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

        public MyViewHolder(@NonNull View itemView, RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            img = itemView.findViewById(R.id.img);
            this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            recyclerViewOnItemClickListener.onClick(view, getAdapterPosition());
        }
    }

}
