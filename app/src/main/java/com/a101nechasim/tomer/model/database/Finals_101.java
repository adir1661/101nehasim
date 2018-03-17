package com.a101nechasim.tomer.model.database;

/**
 * Created by Adir on 3/14/2018.
 */

public class Finals_101 {
    public static class Buyer
    {
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String CELLPHONE = "cellphone";
        public static final String MIN_ROOMS = "min_rooms";
        public static final String MAX_ROOMS = "max_rooms";
        public static final String CURRENT_FLOOR = "current_floor";
        public static final String MIN_AREA = "min_area";
        public static final String MIN_VALUE = "min_value";
        public static final String MAX_VALUE = "max_value";
        public static final String ELEVATOR = "elevator";
        public static final String GARDEN = "garden";
        public static final String SUCA_GARDEN = "suca_garden";
        public static final String PRIVATE_HOUSE = "private_house";
    }
    public static class Seller
    {
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String CELLPHONE = "cellphone";
        public static final String PRICE = "price";
        public static final String HOUSE_ID = "house_id";
        public static class House
        {
            public static final String ID = "house_main_id";
            public static final String ROOMS = "rooms";
            public static final String FLOORS = "floors";
            public static final String CURRENT_FLOOR = "current_floor";
            public static final String AREA_METERS = "area";
            public static final String ELEVATOR = "elevator";
            public static final String ADDRESS = "address";
            public static final String SUCA_GARDEN = "suca_garden";
            public static final String PRIVATE_HOUSE = "private_house";
            public static final String GARDEN = "garden" ;
        }
    }

}
