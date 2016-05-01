package com.muckabout.cardswipe;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author lydialim on 02/05/2016.
 */
public class SectionFragment extends Fragment {

    // can be replace with enum type
    private final static String POSITION_PARAM = "pos";

    private int mPosition = 1;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CategoryFragment.
     */
    public static SectionFragment newInstance (int position) {
        SectionFragment fragment = new SectionFragment();
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
        final View view = inflater.inflate(R.layout.fragment_section, container, false);

        CardView card = (CardView) view.findViewById(R.id.main_card_view);
        card.setCardBackgroundColor(getCardColor(mPosition));

        return view;
    }

    private int getCardColor (int position) {
        if (position == 1) {
            return Color.rgb(63, 81, 181);
        }

        if (position == 2) {
            return Color.rgb(156, 39, 176);
        }

        return Color.rgb(0,150,136);
    }
}
