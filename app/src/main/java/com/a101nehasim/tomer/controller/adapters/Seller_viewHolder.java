package com.a101nehasim.tomer.controller.adapters;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.a101nehasim.tomer.R;
import com.a101nehasim.tomer.model.entity.Customer;
import com.a101nehasim.tomer.model.entity.Seller;

/**
 * Created by Adir on 3/21/2018.
 */

public class Seller_viewHolder implements ViewHolder_101{
    TextView tvName;
    TextView tvValue;
    TextView tvAddress;

    public Seller_viewHolder() {
    }
    @Override
    public void SetViewHolder(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvValue = itemView.findViewById(R.id.tvValue);
        tvAddress = itemView.findViewById(R.id.tvAddress);
    }

    @Override
    public ViewHolder_101 create() {
        return new Seller_viewHolder();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void insertDetailsToView(Customer customer){
        Seller seller = (Seller) customer;
        tvName.setText(seller.getName());
        tvAddress.setText(seller.getHouse().getAddress());
        tvValue.setText(seller.getPrice()+"");
    };

}
