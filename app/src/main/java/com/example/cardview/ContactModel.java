package com.example.cardview;

import android.widget.Toast;

public class ContactModel {
    int img;
    String name, number;

    public ContactModel(int img,String name,String number){
        this.name=name;
        this.number=number;
        this.img=img;
    }
}

