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
import com.popper.daw.bean.RemakeBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.List;

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.SelectViewHolder> {
    private List<String> list;
    private Context context;
    private ManagerDetailListener callback;

    public SelectAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public SelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.factory_item_layout, parent, false);
        SelectViewHolder orderViewHolder = new SelectViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectViewHolder holder, int position) {
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

    class SelectViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public SelectViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
