package com.a101nechasim.tomer.controller;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.a101nechasim.tomer.R;
import com.a101nechasim.tomer.controller.tools.Listeners;
import com.a101nechasim.tomer.model.beckend.DB_factory;
import com.a101nechasim.tomer.model.beckend.DB_manager;


public class BuyerRegistrationFrag extends Fragment {
    DB_manager buyers= DB_factory.buyerListInstance();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etFloor;
    private EditText etMinValue;
    private EditText etMaxValue;
    private TextView tvElevator;
    private Switch sElevator;
    private RelativeLayout llsPrivate;
    private TextView tvPrivate;
    private Switch sPrivate;
    private SeekBar sbMinRooms;
    private EditText etMinRooms;
    private SeekBar sbMaxRooms;
    private EditText etMaxRooms;
    private SeekBar sbFloor;
    private SeekBar sbMinValue;
    private SeekBar sbMaxValue;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-03-17 20:32:27 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        View v = getView();
        etName = (EditText)v.findViewById( R.id.etName );
        etPhone = (EditText)v.findViewById( R.id.etPhone );
        etEmail = (EditText)v.findViewById( R.id.etEmail );
        etMinValue = v.findViewById(R.id.etMinValue);
        etMaxValue = v.findViewById(R.id.etMaxValue);
        etFloor = v.findViewById(R.id.etFloor);
        tvElevator = (TextView)v.findViewById( R.id.tvElevator );
        sElevator = (Switch)v.findViewById( R.id.sElevator );
        tvPrivate = (TextView)v.findViewById( R.id.tvPrivate );
        sPrivate = (Switch)v.findViewById( R.id.sPrivate );
        sbMinRooms = (SeekBar)v.findViewById( R.id.sbMinRooms);
        etMinRooms = v.findViewById(R.id.etMinRooms);
        sbMaxRooms = (SeekBar)v.findViewById( R.id.sbMaxRooms);
        etMaxRooms = v.findViewById(R.id.etMaxRooms);
        sbFloor = (SeekBar)v.findViewById( R.id.sbFloor );
        sbMinValue = (SeekBar)v.findViewById( R.id.sbMinValue );
        sbMaxValue = (SeekBar)v.findViewById( R.id.sbMaxValue );
        Listeners.attachEdittextToSeekbar(sbMinRooms,etMinRooms);
        Listeners.attachEdittextToSeekbar(sbMaxRooms,etMaxRooms);
        Listeners.attachEdittextToSeekbar(sbFloor,etFloor);
        Listeners.attachEdittextToSeekbar(sbMinValue,etMinValue);
        Listeners.attachEdittextToSeekbar(sbMaxValue,etMaxValue);




    }


    private OnFragmentInteractionListener mListener;

    public BuyerRegistrationFrag() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new  instance of fragment BuyerRegistrationFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyerRegistrationFrag newInstance(String param1, String param2) {
        BuyerRegistrationFrag fragment = new BuyerRegistrationFrag();
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
        return inflater.inflate(R.layout.buyer_registration_fragment, container, false);
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
