package com.example.wechatpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewPager2 viewPager;

    private LinearLayout llChat , llContacts , llFind , llProfile;
    private ImageView ivChat , ivContacts , ivFind , ivProfile , ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();
        initTabView();
    }

    private void initTabView() {
        llChat = findViewById(R.id.id_tab_chat);
        llChat.setOnClickListener(this);
        llContacts = findViewById(R.id.id_tab_mail_list);
        llContacts.setOnClickListener(this);
        llFind = findViewById(R.id.id_tab_found);
        llFind.setOnClickListener(this);
        llProfile = findViewById(R.id.id_tab_mine);
        llProfile.setOnClickListener(this);
        ivChat = findViewById(R.id.tab_iv_chat);
        ivContacts = findViewById(R.id.tab_iv_mail_list);
        ivFind = findViewById(R.id.tab_iv_found);
        ivProfile = findViewById(R.id.tab_iv_mine);

        ivChat.setSelected(true);
        ivCurrent=ivChat;
    }

    private void initPager() {
        viewPager = findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我"));
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        ivCurrent.setSelected(false);
        switch (position){
//            case R.id.id_tab_chat:
//                viewPager.setCurrentItem(0);
            case 0:
                ivChat.setSelected(true);
                ivCurrent=ivChat;
                break;
//            case R.id.id_tab_mail_list:
//                viewPager.setCurrentItem(1);
            case 1:
                ivContacts.setSelected(true);
                ivCurrent=ivContacts;
                break;
//            case R.id.id_tab_found:
//                viewPager.setCurrentItem(2);
            case 2:
                ivFind.setSelected(true);
                ivCurrent=ivFind;
                break;
//            case R.id.id_tab_mine:
//                viewPager.setCurrentItem(3);
            case 3:
                ivProfile.setSelected(true);
                ivCurrent=ivProfile;
                break;
        }
    }

    private void clickChangTab(int position){
        switch (position){
            case R.id.id_tab_chat:
                viewPager.setCurrentItem(0);
                break;
            case R.id.id_tab_mail_list:
                viewPager.setCurrentItem(1);
                break;
            case R.id.id_tab_found:
                viewPager.setCurrentItem(2);
                break;
            case R.id.id_tab_mine:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onClick(View view) {
//        changeTab(view.getId());
        clickChangTab(view.getId());
    }
}