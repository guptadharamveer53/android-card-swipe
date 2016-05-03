package com.muckabout.cardswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author lydialim on 02/05/2016.
 */
public class AppSectionDetailsPagerAdapter extends FragmentPagerAdapter {

    private int mSize = 3;

    public AppSectionDetailsPagerAdapter(FragmentManager fm, int size) {
        super(fm);
        mSize = size;
    }

    @Override
    public Fragment getItem(int i) {
        return CreditDetailFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Section " + (position + 1);
    }

}