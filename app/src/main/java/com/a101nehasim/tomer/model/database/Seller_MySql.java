package com.a101nehasim.tomer.model.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.a101nehasim.tomer.model.beckend.DB_manager;
import com.a101nehasim.tomer.model.entity.Customer;
import com.a101nehasim.tomer.model.entity.Seller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adir on 3/14/2018.
 */

public class Seller_MySql implements DB_manager {
    private final String webURL = "http://101nehasim.tech/database/";
    @Override
    public boolean isExist(String email, String password) {
        return false;
    }

    @Override
    public long addUser(Customer seller) {
        long id = 0;
        try {
            ContentValues contentValues = CV_tools.sellerToContentValues((Seller) seller);
            String str = HttpTools.POST(webURL + "insertSeller.php", contentValues);//TODO: create php directory for insert seller
            id = Long.parseLong(str);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return id;    }

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
    public List<? extends Customer> getList() {
        try {
            List<Seller> sellers = new ArrayList<>();
            String sellers_jsonString ;
            sellers_jsonString = HttpTools.GET(webURL+"getAllSellers.php");
            JSONArray sellers_JsonArray = new JSONObject(sellers_jsonString).getJSONArray("sellers");
            List<ContentValues> Houses_CV = new ArrayList<>();
            String houses_jsonString = HttpTools.GET(webURL + "getAllHouses.php");
            JSONArray House_jsonA = new JSONObject(houses_jsonString).getJSONArray("houses");
            for (int i = 0; i < House_jsonA.length(); i++) {
                JSONObject AMjsonObject = House_jsonA.getJSONObject(i);
                ContentValues ABContentValues = HttpTools.JsonToContentValues(AMjsonObject);
                Houses_CV.add(ABContentValues);
            }
            for (int i = 0; i < sellers_JsonArray.length(); i++) {
                JSONObject seller_JsonObject = sellers_JsonArray.getJSONObject(i);
                ContentValues seller_CV = HttpTools.JsonToContentValues(seller_JsonObject);
                Seller seller = new Seller();
                long _id = seller_CV.getAsLong(Finals_101.Seller.ID);

                boolean flag = false;
                for (ContentValues House_CV : Houses_CV) {
                    if (House_CV.getAsLong(Finals_101.Seller.House.ID) == _id) {
                        flag = true;
//                            ABitem.put(Finals.AboutMe.GENDER,userSeeker.getAboutMe().getGender().toString());
//                            ABitem.put(Finals.AboutMe.HEIGHT,userSeeker.getAboutMe().getHeight());
//                            ABitem.put(Finals.AboutMe.BIRTHDAY,userSeeker.getAboutMe().getBirthday().toString());
//TODO: oginize the database where aboutMe is aboutMe and user its user
                        seller_CV.putAll(House_CV);
                        seller = CV_tools.ContentValuesToSeller(seller_CV);
                        Houses_CV.remove(House_CV);
                        break;
                    } else {
                        seller = CV_tools.ContentValuesToSeller(seller_CV);
                    }
                    if (!flag)
                        throw new Exception("House ID isn't found!, there is a seller without an house , check databaseand delete unusful seller.");
                }
                sellers.add(seller);
            }
            return sellers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getMaxId() {
        return 0;
    }
}
