package com.example.e_bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        Intent i=new Intent(this,Login.class);
        startActivity(i);

    }

    public void bloodbankinap(View view) {
        Intent i=new Intent(this,BloodBankInaAp.class);
        startActivity(i);
    }

    public void receiver(View view) {
        Intent i=new Intent(this,Receiver.class);
        startActivity(i);
    }


    public void bloodcampaign(View view) {
        Intent i=new Intent(this,BloodCampaign.class);
        startActivity(i);
    }
}
