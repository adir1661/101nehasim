package com.a101nechasim.tomer.model.beckend;

import android.content.ContentValues;
import android.database.Cursor;

import com.a101nechasim.tomer.model.entity.Customer;

import java.util.List;

/**
 * Created by Adir on 3/14/2018.
 */

public interface DB_manager {
    public boolean isExist(String email, String password);

    long addUser(Customer user);

    public  boolean removeUser(long id);

    Cursor getAllUsers();

    boolean updateUser(long id, ContentValues values);

    List<? extends Customer> getUsersList();//"? extends User" this is a way to interface a list that

    long getMaxId();

}
