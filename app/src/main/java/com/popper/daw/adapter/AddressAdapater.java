package com.popper.daw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.popper.daw.R;
import com.popper.daw.bean.AddressBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapater extends RecyclerView.Adapter<AddressAdapater.AddressViewHolder> {
    private List<AddressBean> mList=new ArrayList<>();
    private Context mContext;
    private ManagerDetailListener callback;

    public AddressAdapater(List<AddressBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.address_item_layout, parent, false);
        AddressViewHolder addressViewHolder = new AddressViewHolder(view);
        return addressViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        holder.mName.setText(mList.get(position).getName());
        holder.mAddress.setText(mList.get(position).getAddress());
        holder.mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemOnClick(view);
            }
        });
    }

    public void setOnItemClickListener (ManagerDetailListener clickListener){
        this.callback=clickListener;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class AddressViewHolder extends RecyclerView.ViewHolder{
        private TextView mName,mAddress;
        private LinearLayout mEdit;
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.name);
            mAddress=itemView.findViewById(R.id.address);
            mEdit=itemView.findViewById(R.id.editAddress);
        }
    }
}
