package com.a101nehasim.tomer.controller.tools;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.a101nehasim.tomer.model.beckend.DB_manager;
import com.a101nehasim.tomer.model.database.Buyer_MySql;
import com.a101nehasim.tomer.model.database.Finals_101;
import com.a101nehasim.tomer.model.database.Seller_MySql;
import com.a101nehasim.tomer.model.entity.Buyer;
import com.a101nehasim.tomer.model.entity.Customer;
import com.a101nehasim.tomer.model.entity.Seller;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Adir on 3/17/2018.
 */

public class DatabaseConnection {
    //TODO: add ProgressBar to long action.
    public static class BuyerRegisterAsync extends AsyncTask<Buyer, ProgressBar, Void> {
        WeakReference<Context> mContext;
        DB_manager mDB_connection;

        public BuyerRegisterAsync(Context context, Buyer_MySql DB_connection) {
            mContext = new WeakReference<>(context);
            mDB_connection = DB_connection;

        }

        @Override
        protected Void doInBackground(Buyer... buyers) {
            Context context = mContext.get();
            // ----------------- Send to data base -----------------------
            long id = mDB_connection.addUser(buyers[0]);
            buyers[0].setId(id);
            //-------------- Shared Preferences  - save in the app ---------------
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Context context = mContext.get();
            Toast.makeText(context, "Buyer added!", Toast.LENGTH_LONG).show();
        }
    }

    public static class SellerRegisterAsync extends AsyncTask<Seller, ProgressBar, Void> {
        WeakReference<Context> mContext;
        DB_manager mDB_connection;

        public SellerRegisterAsync(Context context, Seller_MySql DB_connection) {
            mContext = new WeakReference<>(context);
            mDB_connection = DB_connection;

        }

        @Override
        protected Void doInBackground(Seller... sellers) {
            // ----------------- Send to data base -----------------------
            long id = mDB_connection.addUser(sellers[0]);
            sellers[0].setId(id);
            sellers[0].getHouse().setId(id);
            //-------------- Shared Preferences  - save in the app ---------------
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Context context = mContext.get();
            Toast.makeText(context, "Seller added!", Toast.LENGTH_LONG).show();
        }
    }

    public static class CustomersListAsync extends AsyncTask<Void, ProgressBar, ArrayList<Customer>> {
        ArrayList<Customer> customers;
        DB_manager customers_Sql;
        Handler.Callback mHandler;



        public CustomersListAsync(DB_manager db_manager, Handler.Callback handler) {
            customers_Sql = db_manager;
            mHandler =  handler;
        }



        @Override
        protected ArrayList<Customer> doInBackground(Void... voids) {
            ArrayList<Customer> customers = (ArrayList<Customer>) customers_Sql.getList();
            return customers;
        }

        @Override
        protected void onPostExecute(ArrayList<Customer> customers) {
            super.onPostExecute(customers);
            this.customers = customers;
            Bundle bundle = new Bundle();
            bundle.putBoolean(Finals_101.App.ACTIVE_ADAPTER,true);
            Message message = Message.obtain();
            message.setData(bundle);
            mHandler.handleMessage(message);
        }

        @Override
        protected void onProgressUpdate(ProgressBar... values) {
            super.onProgressUpdate(values);
        }


        public ArrayList<Customer> getValue() {
            return (ArrayList<Customer>) customers;
        }
    }
}
