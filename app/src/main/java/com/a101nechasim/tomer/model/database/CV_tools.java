package com.a101nechasim.tomer.model.database;



import android.content.ContentValues;
import android.view.View;

import com.a101nechasim.tomer.model.entity.Buyer;
import com.a101nechasim.tomer.model.entity.House;
import com.a101nechasim.tomer.model.entity.Seller;



public class CV_tools {

//--------------------------------Seller tools------------------------------------
//                       -------CV---to---SELLER-----
    public static Seller ContentValuesToSeller(ContentValues contentValues) {
        Seller user = new Seller();
        user.setId(contentValues.getAsLong(Finals_101.Seller.ID));
        user.setCellphone(contentValues.getAsString(Finals_101.Seller.CELLPHONE));
        user.setEmail(contentValues.getAsString(Finals_101.Seller.EMAIL));
        user.setCellphone(contentValues.getAsString(Finals_101.Seller.CELLPHONE));
        user.setPrice(contentValues.getAsLong(Finals_101.Seller.PRICE));

        user.setHouse(ContentValuesToHouse(contentValues));

        return user;
    }
//                       -------CV---to---HOUSE-----
    public static House ContentValuesToHouse(ContentValues contentValues) {
        House house = new House();
        house.setId(contentValues.getAsLong(Finals_101.Seller.House.ID));
        house.setAddress(contentValues.getAsString(Finals_101.Seller.House.ADDRESS));
        house.setAreaMeters(contentValues.getAsInteger(Finals_101.Seller.House.AREA_METERS));
        house.setCurrentFloor(contentValues.getAsInteger(Finals_101.Seller.House.CURRENT_FLOOR));
        house.setRooms(contentValues.getAsInteger(Finals_101.Seller.House.ROOMS));
        house.setFloors(contentValues.getAsInteger(Finals_101.Seller.House.FLOORS));
        house.setElevator(contentValues.getAsBoolean(Finals_101.Seller.House.ELEVATOR));
        house.setGarden(contentValues.getAsBoolean(Finals_101.Seller.House.GARDEN));
        house.setSucaGarden(contentValues.getAsBoolean(Finals_101.Seller.House.SUCA_GARDEN));
        house.setPrivateHouse(contentValues.getAsBoolean(Finals_101.Seller.House.PRIVATE_HOUSE));
        return house;
    }
//                       -------CV---from---SELLER-----
    public static ContentValues sellerToContentValues(Seller seller) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Finals_101.Seller.ID, seller.getId());
        contentValues.put(Finals_101.Seller.PRICE, seller.getPrice());
        contentValues.put(Finals_101.Seller.CELLPHONE, seller.getCellphone());
        contentValues.put(Finals_101.Seller.EMAIL, seller.getEmail());
        contentValues.put(Finals_101.Seller.NAME, seller.getName());

        contentValues.putAll(HouseToContentValues(seller.getHouse()));

        return contentValues;
    }
//                       -------CV---from---HOUSE-----
    public static ContentValues HouseToContentValues(House house) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Finals_101.Seller.House.ADDRESS, house.getAddress());
        contentValues.put(Finals_101.Seller.House.ID, house.getId());
        contentValues.put(Finals_101.Seller.House.SUCA_GARDEN, house.containsSucaGarden());
        contentValues.put(Finals_101.Seller.House.PRIVATE_HOUSE, house.isPrivateHouse());
        contentValues.put(Finals_101.Seller.House.ELEVATOR, house.containsElevator());
        contentValues.put(Finals_101.Seller.House.CURRENT_FLOOR, house.getCurrentFloor());
        contentValues.put(Finals_101.Seller.House.FLOORS, house.getFloors());
        contentValues.put(Finals_101.Seller.House.ROOMS, house.getRooms());
        contentValues.put(Finals_101.Seller.House.AREA_METERS, house.getAreaMeters());
        contentValues.put(Finals_101.Seller.House.GARDEN, house.containsGarden());

        return contentValues;
    }
//--------------------------------Buyer tools-------------------------------------
    //                       -------CV---to---Buyer-----
    public static Buyer ContentValuesToBuyer(ContentValues contentValues) {
        Buyer buyer= new Buyer();
        buyer.setId(contentValues.getAsLong(Finals_101.Buyer.ID));
        buyer.setCellphone(contentValues.getAsString(Finals_101.Buyer.CELLPHONE));
        buyer.setEmail(contentValues.getAsString(Finals_101.Buyer.EMAIL));
        buyer.setCellphone(contentValues.getAsString(Finals_101.Buyer.CELLPHONE));
        buyer.setElevatorNecessary(contentValues.getAsBoolean(Finals_101.Buyer.ELEVATOR));
        buyer.setGarden(contentValues.getAsBoolean(Finals_101.Buyer.GARDEN));
        buyer.setPrivateHouseNecessary(contentValues.getAsBoolean(Finals_101.Buyer.PRIVATE_HOUSE));
        buyer.setSukaGarden(contentValues.getAsBoolean(Finals_101.Buyer.SUCA_GARDEN));
        buyer.setMaxRooms(contentValues.getAsInteger(Finals_101.Buyer.MAX_ROOMS));
        buyer.setMinRooms(contentValues.getAsInteger(Finals_101.Buyer.MIN_ROOMS));
        buyer.setMinAreaMeters(contentValues.getAsInteger(Finals_101.Buyer.MIN_AREA));
        return buyer;
    }

    public static ContentValues buyerToContentValues(Buyer buyer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Finals_101.Buyer.ID, buyer.getId());
        contentValues.put(Finals_101.Buyer.MIN_AREA, buyer.getMinAreaMeters());
        contentValues.put(Finals_101.Buyer.MIN_ROOMS, buyer.getMinRooms());
        contentValues.put(Finals_101.Buyer.MAX_ROOMS, buyer.getMaxRooms());
        contentValues.put(Finals_101.Buyer.SUCA_GARDEN, buyer.isSukaGarden());
        contentValues.put(Finals_101.Buyer.PRIVATE_HOUSE, buyer.isPrivateHouseNecessary());
        contentValues.put(Finals_101.Buyer.GARDEN, buyer.isGarden());
        contentValues.put(Finals_101.Buyer.ELEVATOR, buyer.isElevatorNecessary());
        contentValues.put(Finals_101.Buyer.CELLPHONE, buyer.getCellphone());
        contentValues.put(Finals_101.Buyer.CURRENT_FLOOR, buyer.getCurrentFloor());
        contentValues.put(Finals_101.Buyer.EMAIL, buyer.getEmail());
        contentValues.put(Finals_101.Buyer.MAX_VALUE, buyer.getMaxValue());
        contentValues.put(Finals_101.Buyer.MIN_VALUE, buyer.getMinValue());
        contentValues.put(Finals_101.Buyer.NAME, buyer.getName());
        return contentValues;
    }




//    public static Cursor SeekerListToCursor(List<UserSeeker> userlist) {
//        String[] columns = new String[]
//                {
//                        Finals.DB.User.ID,
//                        Finals.DB.User.NAME,
//                        Finals.DB.User.PASSWORD,
//                        Finals.DB.User.EMAIL,
//                        Finals.DB.User.CELLPHONE,
//                        Finals.DB.AboutMe.GENDER,
//                        Finals.DB.AboutMe.BIRTHDAY,
//                        Finals.DB.AboutMe.FREE_DESCRIPTION,
//                        Finals.DB.AboutMe.HEIGHT
//
//                };
//
//        MatrixCursor matrixCursor = new MatrixCursor(columns);
//
//        for (UserSeeker item : userlist) {
//            matrixCursor.addRow(new Object[]{item.getId(), item.getUserName(), item.getPassword(), item.getEmailAdress(), item.getCellPhone(),
//                    item.getAboutMe().getGender(), item.getAboutMe().getBirthday(), item.getAboutMe().getFreeDescription()});
//        }
//
//        return matrixCursor;
//    }
//
//    //-----------------------------------------private tools--------------------------------------------------
//
//    public static String arrayToString(String[] enums) {
//        String tmp = null;
//        for (int i = 0; i < enums.length; i++) {
//            tmp += enums[i] + "~";
//        }
//        return tmp;
//    }
//
//    public static String[] stringToArray(String str) {
//        String[] enums = str.split("~");
//        return enums;
//    }
//
//    //-------------------------------matchmaker tools----------------------------------
//    public static UserMatch contentValuesToUserMatch(ContentValues contentValues) {
//        UserMatch user = new UserMatch();
//        //-----------------------------------------UserMatch Values----------------------------
//
//        user.setId(contentValues.getAsLong(Finals.DB.User.ID));
//        user.setUserName(contentValues.getAsString(Finals.DB.User.NAME));
//        user.setPassword(contentValues.getAsString(Finals.DB.User.PASSWORD));
//        user.setEmailAdress(contentValues.getAsString(Finals.DB.User.EMAIL));
//        user.setCellPhone(contentValues.getAsString(Finals.DB.User.CELLPHONE));
//        user.setFirebaseToken(contentValues.getAsString(Finals.DB.User.FIREBASE_TOKEN));
//
//
//        //-----------------------------------------UserMatch.AboutMe Values----------------------------
//
//        user.getAboutMe().setGender(Enums.Gender.valueOf(contentValues.getAsString(Finals.DB.AboutMe.GENDER)));
//        user.getAboutMe().setBirthday(new DateBuilt(contentValues.getAsString(Finals.DB.AboutMe.BIRTHDAY)));
//        user.getAboutMe().setFreeDescription(contentValues.getAsString(Finals.DB.AboutMe.FREE_DESCRIPTION));
//
//        return user;
//    }
//
//    public static ContentValues userMatchToContentValues(UserMatch user) {
//
//        ContentValues contentValues = new ContentValues();
//
//        //-----------------------------------------UserMatch Values----------------------------
//
//        contentValues.put(Finals.DB.User.ID, user.getId());
//        contentValues.put(Finals.DB.User.NAME, user.getUserName());
//        contentValues.put(Finals.DB.User.PASSWORD, user.getPassword());
//        contentValues.put(Finals.DB.User.EMAIL, user.getEmailAdress());
//        contentValues.put(Finals.DB.User.CELLPHONE, user.getCellPhone());
//        contentValues.put(Finals.DB.User.FIREBASE_TOKEN, user.getFirebaseToken());
//
//
//        //-----------------------------------------UserMatch.AboutMe Values----------------------------
//
//        contentValues.put(Finals.DB.AboutMe.GENDER, user.getAboutMe().getGender().toString());
//        contentValues.put(Finals.DB.AboutMe.BIRTHDAY, user.getAboutMe().getBirthday().toString());
//        contentValues.put(Finals.DB.AboutMe.FREE_DESCRIPTION, user.getAboutMe().getFreeDescription());
//
//        return contentValues;
//    }
//
//    public ContentValues aboutMeSeekerToContentValues(AboutMe aboutMe) {
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(Finals.DB.AboutMe.STATUS, aboutMe.getGender().toString());
//        contentValues.put(Finals.DB.AboutMe.BIRTHDAY, aboutMe.getBirthday().toString());
//        contentValues.put(Finals.DB.AboutMe.FREE_DESCRIPTION, aboutMe.getFreeDescription());
//        return contentValues;
//    }
//
//    public static Cursor MatchmakerListToCursor(List<UserMatch> matchmakerList) {
//        String[] columns = new String[]
//                {
//                        Finals.DB.User.ID,
//                        Finals.DB.User.NAME,
//                        Finals.DB.User.PASSWORD,
//                        Finals.DB.User.EMAIL,
//                        Finals.DB.User.CELLPHONE,
//                        Finals.DB.AboutMe.GENDER,
//                        Finals.DB.AboutMe.BIRTHDAY,
//                        Finals.DB.AboutMe.FREE_DESCRIPTION
//
//                };
//
//        MatrixCursor matrixCursor = new MatrixCursor(columns);
//
//        for (UserMatch item : matchmakerList) {
//            matrixCursor.addRow(new Object[]{item.getId(), item.getUserName(), item.getPassword(), item.getEmailAdress(), item.getCellPhone(),
//                    item.getAboutMe().getGender(), item.getAboutMe().getBirthday(), item.getAboutMe().getFreeDescription()});
//        }
//        return matrixCursor;
//    }
}
