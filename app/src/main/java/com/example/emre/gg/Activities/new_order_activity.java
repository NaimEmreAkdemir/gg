package com.example.emre.gg.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.emre.gg.R;


public class new_order_activity extends AppCompatActivity {


    private  TextView cancel_order;
    private  TextView accept_order;
    private  EditText order_edittext;
    private  Spinner  spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.ordercard);
        order_edittext = (EditText) findViewById(R.id.order_edittext);
        order_edittext.setText("");
        spinner = (Spinner) findViewById(R.id.spinner);

        cancel_order = (TextView) findViewById(R.id.cancel_order);
        cancel_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        accept_order = (TextView) findViewById(R.id.accept_order);
        accept_order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String data_value = order_edittext.getText().toString();
                String price_value = spinner.getSelectedItem().toString();
               // finish();
            Log.d("Açıklama Yazısı",data_value);
            Log.d("Fiyat (TL)",price_value);
            }
        });



    }
}
