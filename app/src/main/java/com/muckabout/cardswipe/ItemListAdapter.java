package com.muckabout.cardswipe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muckabout.cardswipe.Model.Item;
import com.muckabout.cardswipe.ViewHolder.HeaderListViewHolder;
import com.muckabout.cardswipe.ViewHolder.ItemListViewHolder;
import com.muckabout.cardswipe.ViewHolder.ListViewHolder;

import java.util.List;

/**
 * @author lydialim on 01/05/2016.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM   = 1;

    private List<Item> mItemList;

    public ItemListAdapter (List<Item> dataList) {
        mItemList = dataList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            // Create a new view.
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_card, parent, false);

            //inflate your layout and pass it to view holder
            return new HeaderListViewHolder(v);
        }

        // Create a new view.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_detail_card, parent, false);
        //inflate your layout and pass it to view holder
        return new ItemListViewHolder(v);
    }

    @Override
    public void onBindViewHolder (ListViewHolder holder, int position) {

        if (holder instanceof ItemListViewHolder) {
            Item item = getItem(position);
            ItemListViewHolder vh = (ItemListViewHolder) holder;
            vh.setContext(item);

        } else if (holder instanceof HeaderListViewHolder) {
            HeaderListViewHolder vh = (HeaderListViewHolder) holder;
            vh.setContext("ELIGIBLE PURCHASES");
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount () {
        return mItemList.size() + 1;
    }

    @Override
    public int getItemViewType (int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }

    private Item getItem (int position) {
        return mItemList.get(position - 1);
    }
}