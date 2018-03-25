package com.a101nehasim.tomer.controller;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.a101nehasim.tomer.R;
import com.a101nehasim.tomer.controller.tools.DatabaseConnection;
import com.a101nehasim.tomer.model.beckend.DB_factory;
import com.a101nehasim.tomer.model.beckend.DB_manager;
import com.a101nehasim.tomer.model.database.Seller_MySql;
import com.a101nehasim.tomer.model.entity.House;
import com.a101nehasim.tomer.model.entity.Seller;
import com.adirabargil.adirstools.ui.Listeners;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SellerRegisterationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SellerRegisterationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellerRegisterationFragment extends Fragment {
    DB_manager sellers= DB_factory.sellerListInstance();
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etAddress;
    private TextView tvElevator;
    private Switch sElevator;
    private TextView tvPrivate;
    private Switch sPrivate;
    private SeekBar sbRooms;
    private EditText etRooms;
    private SeekBar sbFloor;
    private EditText etFloor;
    private SeekBar sbValue;
    private EditText etValue;
    Button bAddToDatabase;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-03-20 20:41:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        View v = getView();
        etName = (EditText)v.findViewById( R.id.etName );
        etPhone = (EditText)v.findViewById( R.id.etPhone );
        etEmail = (EditText)v.findViewById( R.id.etEmail );
        etAddress = (EditText)v.findViewById( R.id.etAddress );
        tvElevator = (TextView)v.findViewById( R.id.tvElevator );
        sElevator = (Switch)v.findViewById( R.id.sElevator );
        tvPrivate = (TextView)v.findViewById( R.id.tvPrivate );
        sPrivate = (Switch)v.findViewById( R.id.sPrivate );
        sbRooms = (SeekBar)v.findViewById( R.id.sbRooms );
        etRooms = (EditText)v.findViewById( R.id.etRooms );
        sbFloor = (SeekBar)v.findViewById( R.id.sbFloor );
        etFloor = (EditText)v.findViewById( R.id.etFloor );
        sbValue = (SeekBar)v.findViewById( R.id.sbValue );
        etValue = (EditText)v.findViewById( R.id.etValue );

        bAddToDatabase = v.findViewById(R.id.bAddToDatabase);
        bAddToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSellerToDatabase();
            }
        });
        Listeners.attachEdittextToSeekbar(getActivity(),sbFloor,etFloor,0);
        Listeners.attachEdittextToSeekbar(getActivity(),sbRooms,etRooms,1);
        Listeners.attachEdittextToSeekbar(getActivity(),sbValue,etValue,500);


    }

    private void sendSellerToDatabase() {
        Seller seller = new Seller();
        seller.setPrice(sbValue.getProgress());
        seller.setCellphone(etPhone.getText().toString());
        seller.setEmail(etEmail.getText().toString());
        seller.setName(etName.getText().toString());
        House house = new House();
        house.setPrivateHouse(sPrivate.isChecked());
        house.setCurrentFloor(sbFloor.getProgress());
        house.setElevator(sElevator.isChecked());
        house.setAddress(etAddress.getText().toString());
        house.setRooms(sbRooms.getProgress());
        seller.setHouse(house);
        DatabaseConnection.SellerRegisterAsync registerAsync = new DatabaseConnection.SellerRegisterAsync(getActivity().getApplicationContext(), (Seller_MySql) sellers);
        registerAsync.execute(seller);
    }


    private OnFragmentInteractionListener mListener;

    public SellerRegisterationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SellerRegisterationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SellerRegisterationFragment newInstance(String param1, String param2) {
        SellerRegisterationFragment fragment = new SellerRegisterationFragment();
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
        return inflater.inflate(R.layout.seller_registration_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
