package com.example.fragmentmenagers;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class BlankFragment1 extends Fragment {

    private static final String TAG = "BlankFragment1";
    private View mRootview;

    private IFragmentCallback fragmentCallback;
    public void setFragmentCallback(IFragmentCallback callback){
        fragmentCallback = callback;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        String string = bundle.getString("message");
        Log.d(TAG, "onCreat: " + string);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreatView: ");

        if(mRootview == null){
            mRootview = inflater.inflate(R.layout.fragment_blank, container, false);
        }
        Button btn = mRootview.findViewById(R.id.btn_3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentCallback.sendMsgToActivity("I'm from fragment");
                String msg = fragmentCallback.getMsgFromActivity("null");
                Toast.makeText(BlankFragment1.this.getContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });
        return mRootview;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}