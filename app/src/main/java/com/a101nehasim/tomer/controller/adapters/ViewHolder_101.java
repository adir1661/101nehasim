package com.a101nehasim.tomer.controller.adapters;

import android.view.View;

import com.a101nehasim.tomer.model.entity.Customer;

/**
 * Created by Adir on 3/21/2018.
 */

public interface ViewHolder_101  {

    public abstract void insertDetailsToView(Customer customer);
    public abstract void SetViewHolder (View itemView);
    public abstract ViewHolder_101 create();
}
