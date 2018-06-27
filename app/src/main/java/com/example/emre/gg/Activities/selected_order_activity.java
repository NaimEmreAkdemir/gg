package com.example.emre.gg.Activities;

import android.content.DialogInterface;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emre.gg.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class selected_order_activity extends AppCompatActivity {


    private  TextView selected_order_first_price;
    private  TextView selected_order_description;
    private  EditText order_edittext;
    private  Spinner  spinner;
    private  String received_isWinner_data;
    private  LinearLayout winner;
    int a = 1;
    Boolean is_Winner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_order);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.dummy_name)+" "+getString(R.string.selected_order));
        is_Winner = false;

        selected_order_first_price = (TextView) findViewById(R.id.selected_order_first_price);
        selected_order_first_price.setText("5"+" TL");                                                                           //seçilen sipariş fiyatı burada değiştirilecek

        selected_order_description = (TextView) findViewById(R.id.selected_order_description);
        selected_order_description.setText("dsadasdsadadbasjdjsa\ndsadasdasdasdad\n\n\ndsadas3213131\n\n\n\n\n\ndsdasdasdasda"); //seçilen sipariş bilgisi burada değiştirilecek
        selected_order_description.setMovementMethod(new ScrollingMovementMethod());

        winner = (LinearLayout) findViewById(R.id.winner);

        spinner = (Spinner) findViewById(R.id.selected_order_spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             //   Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_LONG);
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                received_isWinner_data = "TRUE"; //silinecek test amaçlı yazıldı
                                winner.setVisibility(View.VISIBLE);//---
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                received_isWinner_data = "FALSE"; //silinecek test amaçlı yazıldı
                                winner.setVisibility(View.INVISIBLE); //---
                                break;
                        }
                    }
                };

                if (a != 1){
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(selected_order_activity.this);
                builder.setMessage(spinner.getSelectedItem().toString()+" "+ getString(R.string.order_alert_dialog)).setPositiveButton(R.string.yes, dialogClickListener)
                        .setNegativeButton(R.string.no, dialogClickListener).show();
                a=2;
                }
                a++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /*
    private void setIs_Winner(){
        // servera bağlan, kullanıcı kazanmışsa true döndür
        // kazanmamışsa false
        if (received_isWinner_data.equals("TRUE")){
            final Boolean is_Winner = Boolean.TRUE;
        }
        else {
            final Boolean is_Winner = Boolean.FALSE;
        }
    }
    */
}
