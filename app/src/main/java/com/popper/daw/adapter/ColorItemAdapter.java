package com.popper.daw.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.popper.daw.R;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.List;

public class ColorItemAdapter extends RecyclerView.Adapter<ColorItemAdapter.ColorItemHolder> {
    private List<String> list;
    private Context context;
    private ManagerDetailListener callback;

    public ColorItemAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ColorItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.color_item_layout, parent, false);
        ColorItemHolder orderViewHolder = new ColorItemHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorItemHolder holder, int position) {
        holder.name.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemOnClick(view);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("SelectAdapter",list.size()+"");
        return list.size();
    }


    public void setOnItemClickListener (ManagerDetailListener clickListener){
        this.callback=clickListener;
    }

    class ColorItemHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public ColorItemHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.colorName);
        }
    }
}
