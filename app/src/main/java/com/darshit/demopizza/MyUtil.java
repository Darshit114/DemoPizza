package com.darshit.demopizza;

public class MyUtil {

    public static final String PREFNAME = "DATA";
    public static final String PREFKEY = "USERI";
    public static final String DB_NAME = "Student.db";
    public static final String TABLE_NAME = "student";
    public static final String TABLE_NAME_CART = "cart";


    public static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
            "FNAME VARCHAR NOT NULL, " +
            "LNAME VARCHAR NOT NULL, " +
            "USERNAME VARCHAR NOT NULL, " +
            "PASSWORD VARCHAR NOT NULL)";

    public  static final String CREATE_QUERY_CART = "CREATE TABLE " + TABLE_NAME_CART + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
            "ITEM_NAME VARCHAR, " +
            "USER_ID INTEGER, " +
            "QTY INTEGER," +
            "NUM VARCHAR," +
            "ADDR VARCHAR)";

    public static final String COL_1 = "FNAME";
    public static final String COL_2 = "LNAME";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "PASSWORD";
    public static final String COL_9 = "ITEM_NAME";
    public static final String COL_10 = "QTY";
    public static final String COL_11 = "NUM";
    public static final String COL_12 = "ADDR";


}
