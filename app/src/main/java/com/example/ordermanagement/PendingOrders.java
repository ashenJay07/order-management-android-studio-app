package com.example.ordermanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordermanagement.adapter.OrderAdapter;
import com.example.ordermanagement.model.Order;

import java.util.ArrayList;

public class PendingOrders extends AppCompatActivity {

    RecyclerView orderRcyView;
    ArrayList<Order> resultSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);

        orderRcyView = (RecyclerView) findViewById(R.id.orderRcyView);
        LinearLayoutManager mL = new LinearLayoutManager(this);
        orderRcyView.setLayoutManager(mL);

        Cursor cursor = new DBOrder(this).getdata();

        while (cursor.moveToNext()) {
            Order order = new Order(cursor.getString(0), cursor.getInt(1), cursor.getDouble(2), cursor.getDouble(3), cursor.getString(4), cursor.getString(5),cursor.getString(6),cursor.getString(7));

//            Log.i("test", cursor.getString(0)) ;
//            Log.i("test", String.valueOf(cursor.getInt(1))) ;
//            Log.i("test", String.valueOf(cursor.getDouble(2))) ;
//            Log.i("test", String.valueOf(cursor.getDouble(3))) ;
//            Log.i("test", cursor.getString(4)) ;
//            Log.i("test", cursor.getString(5)) ;
//            Log.i("test", cursor.getString(6)) ;
//            Log.i("test", cursor.getString(7)) ;
//            Log.i("test", cursor.getString(8)) ;

            resultSet.add(order);

        }

        OrderAdapter orderAdapter = new OrderAdapter(resultSet);
        orderRcyView.setAdapter(orderAdapter);

    }
}