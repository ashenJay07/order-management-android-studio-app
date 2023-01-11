package com.example.ordermanagement;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StaffInterface extends AppCompatActivity {

    Button view, approve;
    DBOrder DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_interface);

        view = findViewById(R.id.viewOrderBtn);
        approve = findViewById(R.id.approveOrderBtn);

        DB = new DBOrder(this);

        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffInterface.this, PendingOrders.class));
            }
        });

    }

    public void view_Data(View v) {
        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            Toast.makeText(StaffInterface.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(StaffInterface.this);
        builder.setCancelable(true);
        builder.setTitle("Placed Orders");
        builder.setMessage(buffer.toString());
        builder.show();

        DB.close();
    }

}