package com.muckabout.cardswipe.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.muckabout.cardswipe.Model.Item;
import com.muckabout.cardswipe.R;

/**
 * @author lydialim on 01/05/2016.
*
 * Provide a reference to the type of views that you are using (custom ViewHolder)
 *
 */
public class ItemListViewHolder extends ListViewHolder<Item> {

    protected TextView vTitle;
    protected TextView vDate;
    protected TextView vPrice;

    public ItemListViewHolder (View v) {
        super(v);

        vTitle = (TextView) v.findViewById(R.id.tvTitle);
        vDate = (TextView) v.findViewById(R.id.tvDate);
        vPrice = (TextView) v.findViewById(R.id.tvPrice);
    }

    /**
     * Sets the view context information
     * @param data
     */
    @Override
    public void setContext (Item data) {
        vTitle.setText(data.title);
        vDate.setText(data.date);
        vPrice.setText(data.price);
    }
}
