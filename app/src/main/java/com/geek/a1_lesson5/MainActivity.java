package com.geek.a1_lesson5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     FragmentManager fragmentManager;
     FragmentTransaction transaction;
     private  boolean isVisible=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.first_layout,new ChangeFragment());
        transaction.commit();
        TextFragment textFragment = (TextFragment)fragmentManager.findFragmentById(R.id.second_layout);
        if(textFragment != null){
            if(textFragment.isVisible()){
                isVisible = true;
            }
        }


    }
    public void displayDetails(String title, String subTitle) {

        if (isVisible) {
            TextFragment fragment = (TextFragment) fragmentManager.findFragmentById(R.id.second_layout);
            assert fragment != null;
            fragment.showText(title, subTitle);

        } else {
            Intent intent = new Intent(this, Details_Activity.class);
            intent.putExtra("title", title);
            intent.putExtra("subTitle", subTitle);
            startActivity(intent);
        }

    }
}