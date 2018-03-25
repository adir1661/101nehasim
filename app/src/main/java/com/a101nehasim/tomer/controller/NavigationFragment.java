package com.a101nehasim.tomer.controller;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.a101nehasim.tomer.R;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NavigationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NavigationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavigationFragment extends Fragment implements View.OnClickListener {
    private static final int GET_PDF_CODE = 1;
    private Button bSearch;
    private Button bAddBuyer;
    private Button bAddSeller;
    private Button bSignAContect;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NavigationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NavigationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NavigationFragment newInstance(String param1, String param2) {
        NavigationFragment fragment = new NavigationFragment();
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
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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


    private void findViews() {
        View v = getView();
        bSearch = (Button) v.findViewById(R.id.bSearch);
        bAddBuyer = (Button) v.findViewById(R.id.bAddBuyer);
        bAddSeller = (Button) v.findViewById(R.id.bAddSeller);
        bSignAContect = v.findViewById(R.id.bSignAContract);

        bSearch.setOnClickListener(this);
        bAddBuyer.setOnClickListener(this);
        bAddSeller.setOnClickListener(this);
        bSignAContect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == bSearch) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            BrowseFragment fragment = new BrowseFragment();
            fragmentTransaction.replace(R.id.navigation_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (v == bAddBuyer) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            BuyerRegistrationFrag fragment = new BuyerRegistrationFrag();
            fragmentTransaction.replace(R.id.navigation_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (v == bAddSeller) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            SellerRegisterationFragment fragment = new SellerRegisterationFragment();
            fragmentTransaction.replace(R.id.navigation_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (v == bSignAContect) {
            getDocument();
        }
    }

    private void getDocument() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, GET_PDF_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
//            Uri fileuri = data.getData();
//            String docFilePath = getFileNameByUri(getActivity().getBaseContext(), fileuri);

        }
    }
    private String getFileNameByUri(Context context, Uri uri) {
        String filepath = "";//default fileName
        File file;
        if (uri.getScheme().toString().compareTo("content") == 0) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{android.provider.MediaStore.Images.ImageColumns.DATA, MediaStore.Images.Media.ORIENTATION}, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

            cursor.moveToFirst();

            String mImagePath = cursor.getString(column_index);
            cursor.close();
            filepath = mImagePath;

        } else if (uri.getScheme().compareTo("file") == 0) {
            try {
                file = new File(new URI(uri.toString()));
                if (file.exists())
                    filepath = file.getAbsolutePath();

            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            filepath = uri.getPath();
        }
        return filepath;
    }

}
