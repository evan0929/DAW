package com.popper.daw.activity.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.popper.daw.R;
import com.popper.daw.activity.distribute.FactoryActivity;
import com.popper.daw.activity.distribute.TrackActivity;

public class  MaterialsActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mReturn;
    private TextView distribute,mTrackNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .fitsSystemWindows(true)
                .init();
        initView();

    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mReturn=findViewById(R.id.close);
        mTitle.setText("物料详情");
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        distribute=findViewById(R.id.distribute);
        distribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MaterialsActivity.this, FactoryActivity.class));
            }
        });
        mTrackNum=findViewById(R.id.trackNum);
        mTrackNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MaterialsActivity.this, TrackActivity.class));

            }
        });
    }
}