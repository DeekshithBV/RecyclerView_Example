package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    ArrayList<ContactModel> arrContacts = new ArrayList<ContactModel>();
//    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifecycle", "MainActivity onCreate: ");
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onResume: ");


        /*cardView = findViewById(R.id.cardView);
        cardView.setRadius(15.0f);
        cardView.setCardElevation(20.0f);
        cardView.setCardBackgroundColor(2);
        cardView.setUseCompatPadding(true);*/

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"Raman1","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"Ramya2","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"deekshi3","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"ganesh4","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"karthi5","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"Ram6","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"Raj7","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"kaman8","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"shiva9","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"Raman10","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"lalli11","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"veeresh12","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"Ravi13","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"Roopa14","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"Raji15","7658965346"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"Rama16","7658965346"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);


    }


//    public void toastMessage(View view){
//        TextView textView = findViewById(R.id.txtName);
//        String append = textView.getText().toString();
//        Toast.makeText(this, "Clicked up on "+append, Toast.LENGTH_SHORT).show();
//    }
@Override
protected void onStart() {
    super.onStart();
    Log.d("lifecycle", "MainActivity onStart: ");
}

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "MainActivity onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "MainActivity onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "MainActivity onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "MainActivity onDestroy: ");
    }

}
