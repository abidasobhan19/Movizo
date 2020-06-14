package com.example.movizo.Firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyDatabaseRef {

    private static final String Movie_Ref="Movies";
//    private static final String PRODUCTS_REF="products";


    private static MyDatabaseRef instance;

    private FirebaseDatabase database;

    private MyDatabaseRef() {
        this.database  = FirebaseDatabase.getInstance();
    }

    public static MyDatabaseRef getInstance() {
        if (instance == null) {
            instance = new MyDatabaseRef();
        }
        return instance;
    }

    public DatabaseReference getMovie_Ref() {
        return database.getReference().child(Movie_Ref);
    }


}
