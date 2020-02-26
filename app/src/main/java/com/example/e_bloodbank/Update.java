package com.example.e_bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Update extends AppCompatActivity {

    EditText e1_phoneno;
    Spinner s1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        e1_phoneno=findViewById(R.id.phno);
        s1=findViewById(R.id.updatespinner);

    }

    public void update(View view) {

    }
}
