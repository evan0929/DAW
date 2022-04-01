package com.popper.daw.activity.colorist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.popper.daw.R;
import com.popper.daw.fragment.ApplyFragment;
import com.popper.daw.fragment.ColoristAgencyFragment;
import com.popper.daw.fragment.ColoristDoneFragment;
import com.popper.daw.fragment.ColoristFragment;

public class ColoristDetailActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorist_detail);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .init();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("申请信息", ApplyFragment.class)
                .add("调色师填写", ColoristFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        initData();
        initView();
    }

    private void initData() {


    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mReturn=findViewById(R.id.close);
        mTitle.setText("申请xxxx");
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}