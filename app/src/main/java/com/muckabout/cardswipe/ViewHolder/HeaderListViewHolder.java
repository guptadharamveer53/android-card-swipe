package com.muckabout.cardswipe.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.muckabout.cardswipe.R;

/**
 * @author lydialim on 02/05/2016.
 */
public class HeaderListViewHolder extends ListViewHolder<String> {

    protected TextView vHeader;

    public HeaderListViewHolder (View v) {
        super(v);

        vHeader = (TextView) v.findViewById(R.id.tvSection);
    }

    @Override
    public void setContext (String data) {
        vHeader.setText(data);
    }
}
