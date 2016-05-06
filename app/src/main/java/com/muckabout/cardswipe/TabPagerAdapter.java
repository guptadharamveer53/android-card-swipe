package com.muckabout.cardswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * @author lydialim on 03/05/2016.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int mNumberOfTabs;

    public TabPagerAdapter (FragmentManager fm, int numOfTabs) {
        super(fm);

        mNumberOfTabs = numOfTabs;
    }

    @Override
    public CharSequence getPageTitle (int position) {
        return "Tab " + position;
    }

    @Override
    public Fragment getItem (int position) {
        switch (position) {
            case 0:
                TabOneFragment tab1 = new TabOneFragment();
                return tab1;
            case 1:
                TabCreditFragment tab2 = new TabCreditFragment();
                return tab2;
            case 2:
                TabThreeFragment tab3 = new TabThreeFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return mNumberOfTabs;
    }
}
