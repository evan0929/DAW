package com.popper.daw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.gyf.immersionbar.ImmersionBar;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.popper.daw.R;
import com.popper.daw.activity.account.AccountActivity;
import com.popper.daw.fragment.ManagerAgencyFragment;
import com.popper.daw.fragment.ManagerDoneFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTitle;
    private ImageView mAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .init();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("待办列表", ManagerAgencyFragment.class)
                .add("我的已办", ManagerDoneFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        initView();
    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mAccount=findViewById(R.id.goAccount);
        mAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AccountActivity.class));
            }
        });
    }
}