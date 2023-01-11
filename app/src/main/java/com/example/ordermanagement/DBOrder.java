package com.example.ordermanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOrder extends SQLiteOpenHelper {

    public DBOrder(Context context) {
        super(context, "OrderDetails.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table OrderDetails(material TEXT, quantity INTEGER, " +
                "unitPrice REAL, totBudget REAL, siteName TEXT, siteAddress TEXT, deliveryDate TEXT, orderStatus TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists OrderDetails");
    }

    public Boolean placeNewOrder(String material, int quantity, double unitPrice, double totBudget, String siteName, String siteAddress, String deliveryDate, String orderStatus)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("material", material);
        contentValues.put("quantity", quantity);
        contentValues.put("unitPrice", unitPrice);
        contentValues.put("totBudget", totBudget);
        contentValues.put("siteName", siteName);
        contentValues.put("siteAddress", siteAddress);
        contentValues.put("deliveryDate", deliveryDate);
        contentValues.put("orderStatus", orderStatus);

        long result = DB.insert("OrderDetails", null, contentValues);

        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from OrderDetails ", null);
        return cursor;
    }

}