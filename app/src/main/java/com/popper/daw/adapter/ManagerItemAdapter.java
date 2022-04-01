package com.popper.daw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.popper.daw.R;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.ManagerItemBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class ManagerItemAdapter extends RecyclerView.Adapter<ManagerItemAdapter.ManagerItemViewHolder> {
    private List<ManagerItemBean> list;
    private Context context;
    private ManagerDetailListener callback;

    public ManagerItemAdapter(List<ManagerItemBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ManagerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.manager_item_layout, parent, false);
        ManagerItemViewHolder managerAgencyViewHolder = new ManagerItemViewHolder(view);
        return managerAgencyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerItemViewHolder holder, int position) {
        holder.mName.setText(list.get(position).getName());
        holder.mProgress.setProgress(list.get(position).getProgress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemOnClick(view);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClickListener (ManagerDetailListener clickListener){
        this.callback=clickListener;
    }

    class ManagerItemViewHolder extends RecyclerView.ViewHolder{
        private TextView mName;
        private NumberProgressBar mProgress;
        public ManagerItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.name);
            mProgress=itemView.findViewById(R.id.progress);
        }
    }
}
