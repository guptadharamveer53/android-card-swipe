package com.muckabout.cardswipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author lydialim on 03/05/2016.
 */
public class TabCreditFragment extends Fragment implements FragmentInteractionListener {

    private final static int NUM_CATEGORIES = 3;

    private AppSectionsPagerAdapter mPagerAdapter;
    private AppSectionDetailsPagerAdapter mDetailPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    CustomViewPager mMasterViewPager;
    CustomViewPager mDetailViewPager;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.tab_two_fragment, container, false);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mPagerAdapter = new AppSectionsPagerAdapter(getFragmentManager(), NUM_CATEGORIES);
        mDetailPagerAdapter = new AppSectionDetailsPagerAdapter(getFragmentManager(), NUM_CATEGORIES);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mMasterViewPager = (CustomViewPager) view.findViewById(R.id.card_pager);
        mMasterViewPager.setClipToPadding(false);
        mMasterViewPager.setPageMargin(12);
        mMasterViewPager.setPagingEnabled(true);

        mDetailViewPager = (CustomViewPager) view.findViewById(R.id.card_detail_pager);
        mDetailViewPager.setPagingEnabled(false);

        // setup pager adapter
        mMasterViewPager.setAdapter(mPagerAdapter);
        mMasterViewPager.addOnPageChangeListener(new MasterViewPagerListener());

        mDetailViewPager.setAdapter(mDetailPagerAdapter);

        // attempting to disabled scrolling
        mDetailViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                return true;
            }
        });

        return view;
    }


    @Override
    public void onFragmentInteraction (int page) {

    }

    private class MasterViewPagerListener extends ViewPager.SimpleOnPageChangeListener {

        @Override
        public void onPageSelected (int position) {
            mDetailViewPager.setCurrentItem(mMasterViewPager.getCurrentItem());
        }
    }
}
