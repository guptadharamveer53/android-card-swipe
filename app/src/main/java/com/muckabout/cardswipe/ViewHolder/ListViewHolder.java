package com.muckabout.cardswipe.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author lydialim on 02/05/2016.
 */
public abstract class ListViewHolder<T>  extends RecyclerView.ViewHolder {

    public ListViewHolder (View itemView) {
        super(itemView);
    }

    abstract void setContext(T data);
}
