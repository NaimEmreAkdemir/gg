package com.example.emre.gg.Adapters;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.emre.gg.Activities.selected_order_activity;
import com.example.emre.gg.Entities.Orders;
import com.example.emre.gg.R;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by tchzafer on 21/03/2018.
 */

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    ArrayList<Orders> mOrdersList;
    LayoutInflater inflater;
    private Context mContext;


    public OrdersAdapter(Context context, ArrayList<Orders> orders) {
        inflater = LayoutInflater.from(context);
        this.mOrdersList = orders;
        mContext = context;
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
        LinearLayout order_card;
        TextView nickname, order_description,order_price;;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            nickname = (TextView) itemView.findViewById(R.id.nickname);
            order_description = (TextView) itemView.findViewById(R.id.order_description);
            image = (ImageView) itemView.findViewById(R.id.image);
            order_price = (TextView) itemView.findViewById(R.id.order_price);
            order_card = (LinearLayout) itemView.findViewById(R.id.order_card);
            order_card.setOnClickListener(this);
        }

        public void setData(Orders selectedOrders, int position) {

            this.nickname.setText(selectedOrders.getUserName());
            this.order_description.setText(selectedOrders.getOrderDescription());
            this.image.setImageResource(selectedOrders.getImage());


        }


        @Override
        public void onClick(View v) {
            Log.d("Tıklanma","x");
            Intent i = new Intent(mContext,selected_order_activity.class);
            mContext.startActivity(i);
        }


    }
}

