package com.darshit.demopizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    ArrayList<cartItem> list;

    public DatabaseHelper(Context context) {
        super(context, MyUtil.DB_NAME, null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MyUtil.CREATE_QUERY);
        sqLiteDatabase.execSQL(MyUtil.CREATE_QUERY_CART);

}
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + MyUtil.TABLE_NAME);
    }

    public boolean addUser(String fname, String lname, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyUtil.COL_1, fname);
        contentValues.put(MyUtil.COL_2, lname);
        contentValues.put(MyUtil.COL_3, username);
        contentValues.put(MyUtil.COL_4, password);
        long result = db.insert(MyUtil.TABLE_NAME, null, contentValues);
        if (result == -1)

            return false;
        else
            return true;
    }
    public boolean addItem(int USER_ID, String pname, String pqty, String num, String addr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyUtil.COL_9, pname);
        contentValues.put("USER_ID", USER_ID);
        contentValues.put(MyUtil.COL_10, pqty);
        contentValues.put(MyUtil.COL_11, num);
        contentValues.put(MyUtil.COL_12, addr);
        long result = db.insert(MyUtil.TABLE_NAME_CART, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public void Delete(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        String qurry = "DELETE FROM " + MyUtil.TABLE_NAME_CART + " where ITEM_NAME = '" + s +"'";
        db.rawQuery(qurry,null);
    }


    public boolean updateItem(String uname,String pname,String pqty,String num,String addr){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyUtil.COL_9, pname);
        contentValues.put(MyUtil.COL_10, pqty);
        contentValues.put(MyUtil.COL_11, num);
        contentValues.put(MyUtil.COL_12, addr);

        long result = db.update(MyUtil.TABLE_NAME,contentValues,"USERNAME="+uname,null);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = " SELECT " + MyUtil.COL_3 + "," + MyUtil.COL_4 + " FROM " + MyUtil.TABLE_NAME + " WHERE " + MyUtil.COL_3 + " = '" + username + "' and " + MyUtil.COL_4 + " = '" + password + "' ";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, null);
        } catch (Exception e) {
            return null;
        }
        return cursor;
    }

    /*public Cursor getItem(String pname,String pqty,String num,String addr){

        SQLiteDatabase db = this.getReadableDatabase();
       // String sql = " SELECT " + MyUtil.COL_9 + "," + MyUtil.COL_10 + MyUtil.COL_11 + MyUtil.COL_12 + " FROM " + MyUtil.TABLE_NAME_ITEM + " WHERE " + MyUtil.COL_3  +" = '" + username  + "'";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, null);
        } catch (Exception e) {
            return null;
        }
        return cursor;
    }*/

    public boolean validateUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(MyUtil.TABLE_NAME,
                new String[]{MyUtil.COL_3, MyUtil.COL_4}, "username=? and password=?", new String[]{username, password}, null, null, null);
         return  (cursor != null && cursor.getCount() > 0);
    }


    public int getUSerid(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String qurry = "select ID from student where "+MyUtil.COL_3 +" = '" + username + "' and "+ MyUtil.COL_4 + " = '"+password+"'";
        Cursor cursor = db.rawQuery(qurry,null);
        if (cursor.moveToFirst()){
                //if you not need the loop you can remove that

               return cursor.getInt(cursor.getColumnIndex("ID"));
            }
        return 0;
    }

    public Cursor getCartData(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = " SELECT * FROM " + MyUtil.TABLE_NAME_CART + " WHERE USER_ID = " + id;
        Cursor cursor ;
        try {
            cursor = db.rawQuery(sql, null);

        } catch (Exception e) {
            return null;
        }
        return cursor;
    }

}
