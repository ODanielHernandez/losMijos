package com.losmijos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    int numTabs;

    public PageAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                tab_1 tab1 = new tab_1();
                return tab1;
            case 1:
                tab_2 tab2 = new tab_2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
