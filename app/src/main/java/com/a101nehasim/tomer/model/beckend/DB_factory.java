package com.a101nehasim.tomer.model.beckend;

import com.a101nehasim.tomer.model.database.Buyer_MySql;
import com.a101nehasim.tomer.model.database.Seller_MySql;

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
