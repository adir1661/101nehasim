package com.a101nehasim.tomer.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.a101nehasim.tomer.model.entity.Customer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adir on 3/21/2018.
 */

public class HousesRecycleAdapter extends RecyclerView.Adapter<HousesRecycleAdapter.ViewHolder> implements Filterable {
    private List<Customer> itemList = new ArrayList<>();
    private List<Customer> filterList = new ArrayList<>();
    private int itemId;
    private WeakReference<Context> mContext;
    ViewHolder_101 mViewHolder_101;


    public HousesRecycleAdapter(Context context, int layoutId, List<Customer> customerList, ViewHolder_101 viewHolder_101) {
        this.itemList.addAll(customerList);
        this.mContext = new WeakReference<>(context);
        filterList.addAll(itemList);
        itemId = layoutId;
        mViewHolder_101 = viewHolder_101;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext.get())
                .inflate(itemId, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer customer = filterList.get(position);
        holder.viewHolder_101Instance().insertDetailsToView(customer);
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    //---------------------------------------------------filter--------------------------------------
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                filterList.clear();
                String str = (String) constraint;
                for (Customer customer : itemList) {
                    if (customer.getName().toLowerCase().contains(str.toLowerCase()))// condtition here: if the word in the searchView included in seller name
                        filterList.add(customer);
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }
//---------------------------------------------------viewholder--------------------------------------

    class ViewHolder extends RecyclerView.ViewHolder {
        private ViewHolder_101 viewHolder_101;

        public ViewHolder(View itemView) {
            super(itemView);
            viewHolder_101Instance();
            viewHolder_101.SetViewHolder(itemView);
        }

        public ViewHolder_101 viewHolder_101Instance() {
            if (viewHolder_101==null)
            {
                viewHolder_101 = mViewHolder_101.create();
            }
            return viewHolder_101;
        }
    }

}
