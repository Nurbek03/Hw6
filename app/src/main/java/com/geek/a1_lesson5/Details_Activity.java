package com.geek.a1_lesson5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Details_Activity extends AppCompatActivity {
   String title,subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deteils_activity);
        Intent intent = getIntent();
            title = intent.getStringExtra("title");
            subtitle = intent.getStringExtra("subTitle");
            if (title!= null && subtitle!=null){
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                TextFragment textFragment = TextFragment.newInstance(title,subtitle);
                transaction.commit();
            } else Toast.makeText(this,"something gone wrong",Toast.LENGTH_LONG).show();

    }
}