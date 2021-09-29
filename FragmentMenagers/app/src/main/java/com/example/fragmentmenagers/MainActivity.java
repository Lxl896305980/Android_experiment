package com.example.fragmentmenagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.btn_1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.btn_2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_1:
                Bundle bundle = new Bundle();
                bundle.putString("message" , "ACE");
                BlankFragment1 bf = new BlankFragment1();
                bf.setArguments(bundle);
                bf.setFragmentCallback(new IFragmentCallback() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this ,msg,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "I'm from activity";
                        //return null;
                    }
                });
                replaceFrangment(bf);
                break;
            case R.id.btn_2:
                replaceFrangment(new ItemFragment());
        }
    }

    //动态切换fragment
    private void replaceFrangment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentlayout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}