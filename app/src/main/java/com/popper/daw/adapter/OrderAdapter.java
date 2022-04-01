package com.popper.daw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.popper.daw.R;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<OrderBean> list;
    private Context context;
    private ManagerDetailListener callback;
    private boolean isShow=false;

    public OrderAdapter(List<OrderBean> list, Context context,boolean isShow) {
        this.list = list;
        this.context = context;
        this.isShow = isShow;
    }


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_item_layout, parent, false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.code.setText(list.get(position).getCode());
        holder.number.setText(list.get(position).getNumber()+"");
        holder.money.setText(list.get(position).getMoney()+"");
        holder.price.setText(list.get(position).getPrice()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback!=null){
                    callback.onItemOnClick(view);
                }
            }
        });
        if (isShow){
            holder.mIsShow.setVisibility(View.VISIBLE);
        }else {
            holder.mIsShow.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClickListener (ManagerDetailListener clickListener){
        this.callback=clickListener;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{
        private TextView code,name,number,money,price;
        private CheckBox mIsShow;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            code=itemView.findViewById(R.id.materialsNumber);
            name=itemView.findViewById(R.id.materialsName);
            money=itemView.findViewById(R.id.materialsMoney);
            number=itemView.findViewById(R.id.materialsNum);
            price=itemView.findViewById(R.id.materialsPrice);
            mIsShow=itemView.findViewById(R.id.selectItem);
        }
    }
}
