package com.a101nechasim.tomer.controller.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.a101nechasim.tomer.model.beckend.DB_manager;
import com.a101nechasim.tomer.model.database.Buyer_MySql;
import com.a101nechasim.tomer.model.database.CV_tools;
import com.a101nechasim.tomer.model.database.Finals_101;
import com.a101nechasim.tomer.model.entity.Buyer;

import java.lang.ref.WeakReference;

/**
 * Created by Adir on 3/17/2018.
 */

public class DatabaseConnection {
    public static class RegisterAsync extends AsyncTask<Buyer, ProgressBar, Void> {
        WeakReference<Context> mContext;
        DB_manager mDB_connection;
        RegisterAsync (Context context, Buyer_MySql DB_connection){
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
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor =  sharedPreferences.edit();
            editor.putLong(Finals_101.Buyer.ID , buyers[0].getId());
            editor.putString(Finals_101.Buyer.NAME, buyers[0].getName());
            editor.apply();
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Context context = mContext.get();
            Toast.makeText(context, "Buyer added!", Toast.LENGTH_LONG).show();
        }
    }
}
