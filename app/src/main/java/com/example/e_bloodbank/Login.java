package com.example.e_bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et_phoneno, et_password;
    String uphone, upass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_phoneno = findViewById(R.id.phno);
        et_password = findViewById(R.id.loginpassword);
        uphone = getIntent().getStringExtra("phone number");
        upass = getIntent().getStringExtra("password");

    }

    public void login(View view) {
        Intent i = new Intent(this, Update.class);
        startActivity(i);

        if (et_phoneno.getText().toString().equals(uphone) &&
                et_password.getText().toString().equals(upass)) {
            Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();

    }



    public void NewDonorRegister1(View view) {
        Intent i = new Intent(this,NewDonorRegister .class);
        startActivity(i);
    }

}

