package com.example.emre.gg;

import java.util.ArrayList;

public class Orders {

    private String userName;
    private String orderDescription;
    private int image;

    public Orders() {
    }

    public Orders(int image, String userName, String orderDescription) {
        this.image= image;
        this.userName = userName;
        this.orderDescription = orderDescription;

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<Orders> getData() {
        ArrayList<Orders> ordersList = new ArrayList<Orders>();
        int ordersImages[] = {R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile, R.drawable.rounded_profile};
        String[] ordersNames = {"Geleceği Yazanlar", "Paycell", "Tv+", "Dergilik", "Bip", "GNC", "Hesabım", "Sim", "LifeBox", "Merhaba Umut", "Yaani", "Hayal Ortağım", "Goller Cepte", "Piri"};

        for (int i = 0; i < ordersImages.length; i++) {
            Orders temp = new Orders();
            temp.setImage(ordersImages[i]);
            temp.setUserName(ordersNames[i]);
            temp.setOrderDescription("Turkcell \n dasdsadsadsadsadsadnsajkdsajkdadsadnaslndnasnldalnsdlaslndsandlnandlsandndsndnndsandlsadnsdsansdandsnadsnndls\n3 \n4 \n5\n6\n7sdasdadasdsadadsfghfddfdfdngnsnlngnngnnnssnsnnsgsdlnssnsnlgnl");

            ordersList.add(temp);

        }


        return ordersList;


    }

}



