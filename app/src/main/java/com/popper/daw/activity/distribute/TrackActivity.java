package com.popper.daw.activity.distribute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.popper.daw.R;

public class TrackActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .fitsSystemWindows(true)
                .init();
        initData();
        initView();
    }

    private void initData() {


    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mReturn=findViewById(R.id.close);
        mTitle.setText("物流信息");
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}