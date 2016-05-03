package com.muckabout.cardswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muckabout.cardswipe.Model.Item;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author lydialim on 02/05/2016.
 */
public class CreditDetailFragment extends Fragment {

    // can be replace with enum type
    private final static String POSITION_PARAM = "pos";

    private RecyclerView        mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    private int mPosition = 1;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CategoryFragment.
     */
    public static CreditDetailFragment newInstance (int position) {
        CreditDetailFragment fragment = new CreditDetailFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION_PARAM);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.credit_detail_fragment, container, false);
        final FragmentActivity activity = getActivity();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.card_detail_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // should be coming from a source
        List<Item> sampleData = createSampleData(10);

        // specify an adapter
        ItemListAdapter mVerticalAdapter = new ItemListAdapter(sampleData);
        mRecyclerView.setAdapter(mVerticalAdapter);

        return view;
    }

    private List<Item> createSampleData (int size) {
        List<Item> result = new ArrayList<>();

        int min = 35;
        int max = 350;

        Random r = new Random();

        for (int i = 1; i <= size; i++) {
            Item d = new Item();
            d.title = "Muck #" + i;
            d.date = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault()).format(new Date());

            int price = r.nextInt(max - min + 1) + min;
            d.price = "$" + Integer.toString(price);

            result.add(d);
        }

        return result;
    }
}
