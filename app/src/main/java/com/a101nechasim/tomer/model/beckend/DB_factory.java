package com.a101nechasim.tomer.model.beckend;

import com.a101nechasim.tomer.model.database.BuyerList;
import com.a101nechasim.tomer.model.database.Buyer_MySql;
import com.a101nechasim.tomer.model.database.Finals_101;
import com.a101nechasim.tomer.model.database.SellerList;
import com.a101nechasim.tomer.model.database.Seller_MySql;
import com.a101nechasim.tomer.model.entity.Buyer;
import com.a101nechasim.tomer.model.entity.Seller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adir on 3/14/2018.
 */

public class DB_factory {
    private static DB_manager buyerList;
    private static DB_manager sellerList;


    public static DB_manager buyerListInstance() {
        if (buyerList == null)
            buyerList = new Buyer_MySql();
        return buyerList;
    }

    public static DB_manager sellerListInstance() {
        if (sellerList == null)
            sellerList = new Seller_MySql();
        return sellerList;
    }


}
