package com.muckabout.cardswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
 * sections of the app.
 */
public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

    private int mSize = 3;

    public AppSectionsPagerAdapter(FragmentManager fm, int size) {
        super(fm);
        mSize = size;
    }

    @Override
    public Fragment getItem(int i) {
        return CreditSectionFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Section " + (position + 1);
    }

    @Override
    public float getPageWidth (int position) {
        return 0.97f;
    }

}