package com.popper.daw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.popper.daw.R;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.bean.RemakeBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.List;

public class RemakeAdapter extends RecyclerView.Adapter<RemakeAdapter.RemakeViewHolder> {
    private List<RemakeBean> list;
    private Context context;
    private ManagerDetailListener callback;

    public RemakeAdapter(List<RemakeBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public RemakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.remake_item_layout, parent, false);
        RemakeViewHolder orderViewHolder = new RemakeViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RemakeViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName()+list.get(position).getTime());
        holder.info.setText("物料名称:      "+list.get(position).getInfo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClickListener (ManagerDetailListener clickListener){
        this.callback=clickListener;
    }

    class RemakeViewHolder extends RecyclerView.ViewHolder{
        private TextView name,info;
        public RemakeViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.remakeOne);
            info=itemView.findViewById(R.id.remakeInfo);
        }
    }
}
