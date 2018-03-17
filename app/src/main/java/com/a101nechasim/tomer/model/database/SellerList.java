package com.a101nechasim.tomer.model.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.a101nechasim.tomer.model.beckend.DB_manager;
import com.a101nechasim.tomer.model.entity.Customer;
import com.a101nechasim.tomer.model.entity.Seller;

import java.util.List;

/**
 * Created by Adir on 2/20/2018.
 */

public class SellerList implements DB_manager {
    List<Seller> sellers;

    @Override
    public boolean isExist(String email, String password) {
        return false;
    }

    @Override
    public long addUser(Customer seller) {
        sellers.add((Seller) seller);
        return seller.getId();
    }

    @Override
    public boolean removeUser(long id) {
        Seller seller = null;
        for (Seller item : sellers) {
            if (item.getId() == id)
                seller = item;
        }
        if (seller != null) {
            sellers.remove(seller);
            return true;
        }
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
        return sellers;
    }

    @Override
    public long getMaxId() {
        return 0;
    }
}
