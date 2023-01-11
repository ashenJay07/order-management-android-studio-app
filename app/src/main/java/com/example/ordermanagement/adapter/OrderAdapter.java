package com.example.ordermanagement.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordermanagement.R;
import com.example.ordermanagement.model.Order;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.orderViewHolder> {

    ArrayList<Order> resultSet;

    public OrderAdapter(ArrayList<Order> resultSet) {
        this.resultSet = resultSet;
    }


    @NonNull
    @Override
    public orderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.placed_order, parent, false);

        return new orderViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull orderViewHolder holder, int position) {

        holder.material.setText(resultSet.get(position).getMaterial());
        holder.quantity.setText(resultSet.get(position).getQuantity());
        holder.unitPrice.setText(resultSet.get(position).getUnitPrice() + "0");
        holder.totBudget.setText(resultSet.get(position).getTotBudget() + "0");
        holder.siteName.setText(resultSet.get(position).getSiteName());
        holder.siteAddress.setText(resultSet.get(position).getSiteAddress());
        holder.deliveryDate.setText(resultSet.get(position).getDeliveryDate());
        holder.orderStatus.setText(resultSet.get(position).getOrderStatus());



    }

    @Override
    public int getItemCount() {
        return resultSet.size();
    }

    class orderViewHolder extends RecyclerView.ViewHolder {

        TextView material, quantity, unitPrice, totBudget, siteName, siteAddress, deliveryDate, orderStatus;

        public orderViewHolder(@NonNull View itemView) {
            super(itemView);

            material = (TextView) itemView.findViewById(R.id.matRcyId);
            quantity = (TextView) itemView.findViewById(R.id.quantityRcyId);
            unitPrice = (TextView) itemView.findViewById(R.id.quantityRcyId2);
            totBudget = (TextView) itemView.findViewById(R.id.quantityRcyId3);
            siteName = (TextView) itemView.findViewById(R.id.quantityRcyId4);
            siteAddress = (TextView) itemView.findViewById(R.id.quantityRcyId5);
            deliveryDate = (TextView) itemView.findViewById(R.id.quantityRcyId6);
            orderStatus = (TextView) itemView.findViewById(R.id.quantityRcyId7);

        }
    }

}
