package com.popper.daw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.popper.daw.R;
import com.popper.daw.bean.ManagerAgencyBean;

import java.util.List;

public class ManagerAgencyAdapter extends RecyclerView.Adapter<ManagerAgencyAdapter.ManagerAgencyViewHolder> {
    private List<ManagerAgencyBean> list;
    private Context context;

    public ManagerAgencyAdapter(List<ManagerAgencyBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ManagerAgencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_item_layout, parent, false);
        ManagerAgencyViewHolder managerAgencyViewHolder = new ManagerAgencyViewHolder(view);
        return managerAgencyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerAgencyViewHolder holder, int position) {
        holder.mJName.setText(list.get(position).getjName());
        holder.mTime.setText(list.get(position).getTime());
        holder.mName.setText(list.get(position).getName());
        holder.numberProgressBar.setProgress(list.get(position).getProgress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "正在开发中。。。", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ManagerAgencyViewHolder extends RecyclerView.ViewHolder{
        private TextView mJName,mTime,mName;
        private NumberProgressBar numberProgressBar;
        public ManagerAgencyViewHolder(@NonNull View itemView) {
            super(itemView);
            mJName=itemView.findViewById(R.id.jName);
            mTime=itemView.findViewById(R.id.time);
            mName=itemView.findViewById(R.id.name);
            numberProgressBar=itemView.findViewById(R.id.number_progress_bar);
        }
    }
}
