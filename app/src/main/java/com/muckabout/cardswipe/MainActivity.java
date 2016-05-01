package com.muckabout.cardswipe;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends FragmentActivity  implements FragmentInteractionListener {

    private final static int NUM_CATEGORIES = 3;

    private AppSectionsPagerAdapter mPagerAdapter;
    private AppSectionDetailsPagerAdapter mDetailPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    CustomViewPager mMasterViewPager;
    CustomViewPager mDetailViewPager;

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager(), NUM_CATEGORIES);
        mDetailPagerAdapter = new AppSectionDetailsPagerAdapter(getSupportFragmentManager(), NUM_CATEGORIES);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mMasterViewPager = (CustomViewPager) findViewById(R.id.card_pager);
        mMasterViewPager.setClipToPadding(false);
        mMasterViewPager.setPageMargin(12);
        mMasterViewPager.setPagingEnabled(true);

        mDetailViewPager = (CustomViewPager) findViewById(R.id.card_detail_pager);
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
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This is called when the Home (Up) button is pressed in the action bar.
                // Create a simple intent that starts the hierarchical parent activity and
                // use NavUtils in the Support Package to ensure proper handling of Up.
                Intent upIntent = new Intent(this, MainActivity.class);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is not part of the application's task, so create a new task
                    // with a synthesized back stack.
                    TaskStackBuilder.from(this)
                            // If there are ancestor activities, they should be added here.
                            .addNextIntent(upIntent)
                            .startActivities();
                    finish();
                } else {
                    // This activity is part of the application's task, so simply
                    // navigate up to the hierarchical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction (int page) {

    }

    private class MasterViewPagerListener extends ViewPager.SimpleOnPageChangeListener {

        private int mScrollState = ViewPager.SCROLL_STATE_IDLE;

        @Override
        public void onPageSelected (int position) {
            mDetailViewPager.setCurrentItem(mMasterViewPager.getCurrentItem());
        }
    }
}
