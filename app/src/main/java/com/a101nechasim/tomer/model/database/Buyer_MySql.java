package com.a101nechasim.tomer.model.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.a101nechasim.tomer.model.beckend.DB_manager;
import com.a101nechasim.tomer.model.entity.Buyer;
import com.a101nechasim.tomer.model.entity.Customer;
import com.a101nechasim.tomer.model.entity.Seller;

import java.io.IOException;
import java.util.List;

/**
 * Created by Adir on 3/15/2018.
 */

public class Buyer_MySql implements DB_manager {
    private final String webURL = "http://101nehasim.tech/databse/";
    @Override
    public boolean isExist(String email, String password) {
        return false;
    }

    @Override
    public long addUser(Customer buyer) {
        long id = 0;
        try {
            ContentValues contentValues;
            contentValues = CV_tools.buyerToContentValues((Buyer) buyer);
            String str = HttpTools.POST(webURL + "insertBuyer.php", contentValues);
            id = Long.parseLong(str);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return id;      }

    @Override
    public boolean removeUser(long id) {
        return false;
    }

    @Override
    public Cursor getAllUsers() {
        return null;
    }

    @Override
    public boolean updateUser(long id, ContentValues values) {
        return false;
    }

    @Override
    public List<? extends Customer> getUsersList() {
        return null;
    }

    @Override
    public long getMaxId() {
        return 0;
    }
}
