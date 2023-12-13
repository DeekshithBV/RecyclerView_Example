package com.example.cardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    Button firstFragmentBtn, secondFragmentBtn, thirdFragmentBtn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifecycle", "SecondaryActivity onCreate: ");
        setContentView(R.layout.activity_secondary);

        firstFragmentBtn = findViewById(R.id.btn1);
        secondFragmentBtn = findViewById(R.id.btn2);
        thirdFragmentBtn = findViewById(R.id.btn3);

        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new fragment1());
            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                replaceFragment(new fragment2());
            }
        });

        thirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new fragment3());
            }
        });

        tv = findViewById(R.id.Name);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String rec = bundle.getString("Name");
            Log.e("Deek", "onCreate: " + rec);
            String num = bundle.getString("Number");
            tv.setText(rec + "\n" + num);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
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

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "SecondaryActivity onStop: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("lifecycle","SecondaryActivity onSaveInstanceState");
    }
}