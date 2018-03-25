package com.a101nehasim.tomer.model.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.a101nehasim.tomer.model.beckend.DB_manager;
import com.a101nehasim.tomer.model.entity.Buyer;
import com.a101nehasim.tomer.model.entity.Customer;

import java.util.List;

/**
 * Created by Adir on 3/15/2018.
 */

public class BuyerList implements DB_manager {
    List<Buyer> buyers;

    @Override
    public boolean isExist(String email, String password) {
        return false;
    }

    @Override
    public long addUser(Customer buyer) {
        buyers.add((Buyer) buyer);
        return buyer.getId();
    }

    @Override
    public boolean removeUser(long id) {
        Buyer buyer = null;
        for (Buyer item : buyers) {
            if (item.getId() == id)
                buyer = item;
        }
        if (buyer != null) {
            buyers.remove(buyer);
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
    public List<? extends Customer> getList() {
        return buyers;
    }

    @Override
    public long getMaxId() {
        return 0;
    }

}
