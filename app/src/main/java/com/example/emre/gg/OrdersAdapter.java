package com.example.emre.gg;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tchzafer on 21/03/2018.
 */

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    ArrayList<Orders> mOrdersList;
    LayoutInflater inflater;

    public OrdersAdapter(Context context, ArrayList<Orders> orders) {
        inflater = LayoutInflater.from(context);
        this.mOrdersList = orders;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.order_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Orders selectedOrders = mOrdersList.get(position);
        holder.setData(selectedOrders, position);

    }

    @Override
    public int getItemCount() {
        return mOrdersList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nickname, order_description,order_price;;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            nickname = (TextView) itemView.findViewById(R.id.nickname);
            order_description = (TextView) itemView.findViewById(R.id.order_description);
            image = (ImageView) itemView.findViewById(R.id.image);
            order_price = (TextView) itemView.findViewById(R.id.order_price);
            order_price.setOnClickListener(this);  //gereksiz

        }

        public void setData(Orders selectedOrders, int position) {

            this.nickname.setText(selectedOrders.getUserName());
            this.order_description.setText(selectedOrders.getOrderDescription());
            this.image.setImageResource(selectedOrders.getImage());


        }


        @Override
        public void onClick(View v) {


        }


    }
}

