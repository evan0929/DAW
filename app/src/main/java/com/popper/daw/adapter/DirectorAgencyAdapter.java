package com.popper.daw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.popper.daw.R;
import com.popper.daw.bean.DirectorOrderBean;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.ManagerItemBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class DirectorAgencyAdapter extends RecyclerView.Adapter<DirectorAgencyAdapter.DirectorAgencyViewHolder> {
    private List<DirectorOrderBean> list;
    private Context context;
    private ManagerDetailListener callback;
    private List<ManagerItemBean> itemList=new ArrayList<>();

    public DirectorAgencyAdapter(List<DirectorOrderBean> list, Context context, List<ManagerItemBean> itemList) {
        this.list = list;
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DirectorAgencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.director_item_layout, parent, false);
        DirectorAgencyViewHolder managerAgencyViewHolder = new DirectorAgencyViewHolder(view);
        return managerAgencyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorAgencyViewHolder holder, int position) {
        holder.mTime.setText(list.get(position).getTime());
        holder.mName.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemOnClick(view);
            }
        });
//        holder.mItemOrderView.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.mItemOrderView.setLayoutManager(linearLayoutManager);

        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(context,R.drawable.custom2_divider));
        holder.mItemOrderView.addItemDecoration(divider);

        ManagerItemAdapter myAdapter = new ManagerItemAdapter(itemList,context);
        myAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                callback.onItemOnClick(view);
            }
        });
        holder.mItemOrderView.setAdapter(myAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClickListener (ManagerDetailListener clickListener){
        this.callback=clickListener;
    }

    class DirectorAgencyViewHolder extends RecyclerView.ViewHolder{
        private TextView mName,mTime;
        private RecyclerView mItemOrderView;
        public DirectorAgencyViewHolder(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.pName);
            mTime=itemView.findViewById(R.id.pTime);
            mItemOrderView=itemView.findViewById(R.id.itemOrderView);
        }
    }
}
