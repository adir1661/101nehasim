package com.a101nehasim.tomer.controller;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.a101nehasim.tomer.R;
import com.a101nehasim.tomer.controller.adapters.HousesRecycleAdapter;
import com.a101nehasim.tomer.controller.adapters.Seller_viewHolder;
import com.a101nehasim.tomer.controller.tools.DatabaseConnection;
import com.a101nehasim.tomer.model.beckend.DB_factory;
import com.a101nehasim.tomer.model.beckend.DB_manager;
import com.a101nehasim.tomer.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BrowseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment implements Handler.Callback{
    DB_manager DB_sellers = DB_factory.sellerListInstance();

    SearchView svFilter;
    HousesRecycleAdapter housesRecycleAdapter;
    private RecyclerView recyclerView;
    List<Customer> customers = new ArrayList<>();
    Seller_viewHolder sellerViewHolder;
    DatabaseConnection.CustomersListAsync customersAsync;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BrowseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrowseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrowseFragment newInstance(String param1, String param2) {
        BrowseFragment fragment = new BrowseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_of_houses, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        svFilter.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                housesRecycleAdapter.getFilter().filter(newText);
                housesRecycleAdapter.notifyDataSetChanged();
                return true;
            }
        });



        customersAsync = new DatabaseConnection.CustomersListAsync(DB_sellers,this);
        customersAsync.execute();




    }

    @Override
    public void onResume() {
        super.onResume();

    }


    private void findViews() {
        View v = getView();
        svFilter= v.findViewById(R.id.svFilter);
        recyclerView =v.findViewById(R.id.rvListOfHouses);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean handleMessage(Message msg) {
        customers = customersAsync.getValue();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        sellerViewHolder = new Seller_viewHolder();
        housesRecycleAdapter = new HousesRecycleAdapter(getActivity(),R.layout.result_item,customers,sellerViewHolder);


        recyclerView.setAdapter(housesRecycleAdapter);
        return false;
    }

}
