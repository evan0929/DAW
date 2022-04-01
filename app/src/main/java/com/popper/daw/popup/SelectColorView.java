package com.popper.daw.popup;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.popper.daw.R;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.activity.manager.MaterialsActivity;
import com.popper.daw.adapter.ColorItemAdapter;
import com.popper.daw.adapter.OrderAdapter;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

import razerdp.basepopup.BasePopupWindow;

public class SelectColorView extends BasePopupWindow {
    private EditText mColorInput;
    private RecyclerView mColorView;
    private List<String> mList=new ArrayList<>();
    private Context mContext;

    public SelectColorView(Context context,List<String> list) {
        super(context);
        setContentView(R.layout.select_color_layout);
        this.mContext=context;
        this.mList=list;
        initView();

    }



    private void initView(){
        mColorInput=findViewById(R.id.input);
        mColorView=findViewById(R.id.colorView);
        mColorView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mColorView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(mContext,R.drawable.custom2_divider));
        mColorView.addItemDecoration(divider);

        ColorItemAdapter colorItemAdapter=new ColorItemAdapter(mList,mContext);

        colorItemAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {

            }
        });
        mColorView.setAdapter(colorItemAdapter);
    }

    @Override
    protected Animator onCreateShowAnimator() {
        return super.onCreateShowAnimator();
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return super.onCreateDismissAnimation();
    }
}
