package com.popper.daw.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.popper.daw.R;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.ManagerItemBean;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.bean.OrderListBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class ManagerAgencyAdapter extends RecyclerView.Adapter<ManagerAgencyAdapter.ManagerAgencyViewHolder> {
    private List<OrderListBean> list;
    private Context context;
    private ManagerDetailListener callback;
    private List<ManagerItemBean> itemList=new ArrayList<>();

    public ManagerAgencyAdapter(List<OrderListBean> list, Context context,List<ManagerItemBean> itemList) {
        this.list = list;
        this.context = context;
        this.itemList = itemList;
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
        holder.mJName.setText(list.get(position).getProjectName());
        holder.mName.setText(list.get(position).getOrderName());
        holder.mCity.setText(list.get(position).getProjectProvince());
        holder.mLevel.setText(list.get(position).getEmergency());
        holder.mMoney.setText(list.get(position).getOrderId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback!=null){
                    callback.onItemOnClick(view);
                }
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
                if (callback!=null){
                    callback.onItemOnClick(view);
                }
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

    class ManagerAgencyViewHolder extends RecyclerView.ViewHolder{
        private TextView mJName,mMoney,mName,mCity,mLevel;
        private RecyclerView mItemOrderView;
        public ManagerAgencyViewHolder(@NonNull View itemView) {
            super(itemView);
            mJName=itemView.findViewById(R.id.jName);
            mMoney=itemView.findViewById(R.id.money);
            mName=itemView.findViewById(R.id.name);
            mCity=itemView.findViewById(R.id.city);
            mLevel=itemView.findViewById(R.id.level);
            mItemOrderView=itemView.findViewById(R.id.itemOrderView);
        }
    }
}
