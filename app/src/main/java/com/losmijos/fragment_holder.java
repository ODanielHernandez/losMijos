package com.losmijos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.io.Serializable;

public class fragment_holder extends AppCompatActivity implements tab_1.OnFragmentInteractionListener,tab_2.OnFragmentInteractionListener,Serializable {

    static Integer value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_holder);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        Bundle extras = this.getIntent().getExtras();
        value = extras.getInt("id");


        Toast.makeText(this,String.valueOf(valorFragmento.myvalue),Toast.LENGTH_SHORT).show();

        /*Bundle bundle = new Bundle();
        bundle.putString("ids", String.valueOf(value));
        Fragment myFrag = new tab_1();
        myFrag.setArguments(bundle);*/

        /*Fragment fragment = new tab_1();
        fragment.setArguments(bundle);
        fm.beginTransaction()
                .replace(placeholder, fragment, tabId)
                .commit();
*/

        //New tabs here
        tabLayout.addTab(tabLayout.newTab().setText("Mochila"));
        tabLayout.addTab(tabLayout.newTab().setText("Plan de contingencia"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public static class valorFragmento{
        public static Integer myvalue = value;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
