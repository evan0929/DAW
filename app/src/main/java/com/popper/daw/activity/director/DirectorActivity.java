package com.popper.daw.activity.director;

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
import com.popper.daw.fragment.DirectorAgencyFragment;
import com.popper.daw.fragment.DirectorDoneFragment;

public class DirectorActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mAccount,mScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .init();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("待办列表", DirectorAgencyFragment.class)
                .add("已办列表", DirectorDoneFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        initView();
    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mTitle.setText("标题xxxxx");
        mAccount=findViewById(R.id.goAccount);
        mAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mScan=findViewById(R.id.scan);
        mScan.setVisibility(View.VISIBLE);
        mScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}