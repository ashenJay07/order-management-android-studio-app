package com.example.ordermanagement;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceAnOrder extends AppCompatActivity {

    //initialize variables
    EditText material, quantity, siteName, siteAddress, unitPrice, deliveryDate;
    Button insert, view;
    DBOrder DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_an_order);

        //EditTexts UI
        material = findViewById(R.id.material_ui);
        quantity = findViewById(R.id.quantity_ui);
        unitPrice = findViewById(R.id.unitPrice_ui);
        siteName = findViewById(R.id.siteName_ui);
        siteAddress = findViewById(R.id.siteAddress_ui);
        siteAddress = findViewById(R.id.siteAddress_ui);
        deliveryDate = findViewById(R.id.deliveryDate_ui);

        //Buttons UI
        insert = findViewById(R.id.placeOrderBtn);
        view = findViewById(R.id.viewOrderBtn);

        //initialize Database
        DB = new DBOrder(this);

    }

    public void insert_Data(View v) {
        String materialTXT = material.getText().toString();
        int quantityINT = Integer.parseInt(quantity.getText().toString());
        double unitPriceDOUBLE = Double.parseDouble(unitPrice.getText().toString());
        double totBudgetDOUBLE = quantityINT * unitPriceDOUBLE;
        String siteNameTXT = siteName.getText().toString();
        String siteAddressTXT = siteAddress.getText().toString();
        String deliveryDateTXT = deliveryDate.getText().toString();
        String orderStatus = "";

        if (totBudgetDOUBLE < 100000) {
            orderStatus = "Approved";
        } else {
            orderStatus = "Pending";
        }

//        Log.i("test", materialTXT);
//        Log.i("test", Integer.toString(quantityINT));
//        Log.i("test", Double.toString(unitPriceDOUBLE));
//        Log.i("test", Double.toString(totBudgetDOUBLE));
//        Log.i("test", siteNameTXT);
//        Log.i("test", siteAddressTXT);
//        Log.i("test", deliveryDateTXT);
//        Log.i("test", orderStatus);


        Boolean checkInsertData = DB.placeNewOrder(materialTXT, quantityINT, unitPriceDOUBLE, totBudgetDOUBLE, siteNameTXT, siteAddressTXT, deliveryDateTXT, orderStatus);


        if (checkInsertData)
            Toast.makeText(PlaceAnOrder.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(PlaceAnOrder.this, "Order Declined", Toast.LENGTH_SHORT).show();

        DB.close();
    }

    public void view_Data(View v) {
        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            Toast.makeText(PlaceAnOrder.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Material: " + res.getString(0) + "\n");
            buffer.append("Quantity: " + res.getString(1) + "\n");
            buffer.append("Unit Price: " + res.getString(2) + "\n");
            buffer.append("Total Budget: " + res.getString(3) + "\n");
            buffer.append("Site Name: " + res.getString(4) + "\n");
            buffer.append("Site Address: " + res.getString(5) + "\n");
            buffer.append("Delivery Date: " + res.getString(6) + "\n");
            buffer.append("Order Status: " + res.getString(7) + "\n\n");
        }

        //alert pop-up for viewing all data
        AlertDialog.Builder builder = new AlertDialog.Builder(PlaceAnOrder.this);
        builder.setCancelable(true);
        builder.setTitle("Placed Orders");
        builder.setMessage(buffer.toString());
        builder.show();

        DB.close();
    }

}