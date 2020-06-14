package com.example.movizo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.movizo.Firebase.MyDatabaseRef;
import com.example.movizo.Horizontal_Recyclerview.Horizontal_Adapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Landing_Page extends AppCompatActivity {

    private Horizontal_Adapter horizontal_adapter;


    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            Log.d("UUUUUU",dataSnapshot.toString());
            PopularMovie popularMovie= dataSnapshot.getValue(PopularMovie.class);
            horizontal_adapter.addpropularMovies(popularMovie);

        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {


        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing__page);

        horizontal_adapter = new Horizontal_Adapter(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(horizontal_adapter);
        MyDatabaseRef.getInstance().getMovie_Ref().addChildEventListener(childEventListener);
    }
}
