package com.example.cardview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment2 extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        Log.d("frag2","oncreateView");
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("frag2","ondestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("frag2","onpause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("frag2","onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("frag2","onstart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("frag2","oncreate");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("frag2","onattach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("frag2","ondetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("frag2","ondestroyView");
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("frag2","onActCreated");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("frag2","onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("frag2","onSaveInstance");
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        Log.d("frag2","onStartActivity");
    }
}