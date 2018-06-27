package com.example.emre.gg.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emre.gg.Entities.Orders;
import com.example.emre.gg.Adapters.OrdersAdapter;
import com.example.emre.gg.R;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView neworder;
    RecyclerView recyclerView;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    neworder.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);


                    return true;

                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    neworder.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:
                 //   mTextMessage.setText(R.string.title_notifications);
                    neworder.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);

        OrdersAdapter ordersAdapter = new OrdersAdapter(this, Orders.getData());
        recyclerView.setAdapter(ordersAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        mTextMessage = (TextView) findViewById(R.id.message);
        neworder = (ImageView) findViewById(R.id.neworder);
        neworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),new_order_activity.class);
                startActivity(i);
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
