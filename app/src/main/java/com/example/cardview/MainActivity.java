package com.example.cardview;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.widget.CheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedViewModel sharedViewModel;
    public TextView selItemCount;
    ArrayList<ContactModel> arrContacts = new ArrayList<ContactModel>();
    public CheckBox checkBoxSelectAll,checkBoxDeselect;

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifecycle", "MainActivity onCreate: ");
        setContentView(R.layout.activity_main);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        checkBoxSelectAll = findViewById(R.id.checkBoxSelectAll);
        selItemCount = findViewById(R.id.selectedItemCount);
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

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts,sharedViewModel);
        recyclerView.setAdapter(adapter);

        checkBoxSelectAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked && adapter.selectedPositions.size()!=arrContacts.size()){
                return;
            }
            Log.d("a","b");
            adapter.clearSelectedItems();
            // Check or uncheck all items based on the state of checkBoxSelectAll
            for (int i = 0; i < adapter.getItemCount(); i++) {
                Log.d("c","d");
                if (isChecked) {
                    Log.d("e","f");
                    adapter.selectItem(i);
                } else {
                    Log.d("g","h");
                    adapter.deselectItem(i);
                }
            }
            selItemCount.setText(String.valueOf(adapter.selectedPositions.size()));
            checkBoxSelectAll.setChecked(adapter.areAllItemsSelected());
            // Update the selected item count TextView
        });
        /*checkBoxDeselect.setOnCheckedChangeListener((buttonView, isChecked) -> {
            for (int i = 0; i < adapter.getItemCount(); i++){
                if (i==adapter.globalPosition){
                    adapter.deselectItem(i);
                    break;
                }
            }
        });*/
    }

    /*private RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);
    int selectedCount;
    public void updateSelectedItemCount() {
        adapter = new RecyclerContactAdapter(this,arrContacts);
//        recyclerView.setAdapter(adapter);
        if (adapter != null) {
            Log.d("cnt1","cnt2");
            selectedCount = adapter.getSelectedItemCount();
            Log.d("cnt3","cnt4");
            // Update the selected item count TextView
          //  ((TextView) findViewById(R.id.selectedItemCount)).setText("Selected: " + selectedCount);
            Log.d("cnt6","cnt5");
        }
    }*/


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

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "MainActivity onStop: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("lifecycle", "MainActivity onSaveInstanceState: ");
    }
}
