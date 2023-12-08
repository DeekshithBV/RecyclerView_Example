package com.example.cardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifecycle", "SecondaryActivity onCreate: ");
        setContentView(R.layout.activity_secondary);
        tv = findViewById(R.id.Name);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String rec = bundle.getString("Name");
            Log.e("Deek", "onCreate: " + rec);
            String num = bundle.getString("Number");
            tv.setText(rec + "\n" + num);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "SecondaryActivity onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "SecondaryActivity onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", " SecondaryActivity onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "SecondaryActivity onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "SecondaryActivity onDestroy: ");
    }
}