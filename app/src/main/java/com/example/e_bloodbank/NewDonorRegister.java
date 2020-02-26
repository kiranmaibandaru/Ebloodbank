package com.example.e_bloodbank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class NewDonorRegister extends AppCompatActivity {
    EditText et_1, et_3, et_4, et_5, et_7, et_8,et_9;
    Spinner s1,s2,s3;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_donor_register);
        iv = findViewById(R.id.image);
        if(!checkpermission()){
            requstpermission();
        }
        et_1 = findViewById(R.id.fullname);
        s2 = findViewById(R.id.districts);
        s3 = findViewById(R.id.blood);
        s1 = findViewById(R.id.gender);
        et_3 = findViewById(R.id.dob);
        et_4 = findViewById(R.id.phoneno);
        et_5 = findViewById(R.id.alternatephoneno);
        et_7 = findViewById(R.id.address);
        et_8 = findViewById(R.id.lasttimeblooddonates);
        et_9 = findViewById(R.id.password);
    }

    public void opengallery(View view) {
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(i, 22);

        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 22) {
                if (resultCode == RESULT_OK) {
                    Uri u = data.getData();
                    iv.setImageURI(u);
                }
            } else if (requestCode == 44) {
                if (resultCode == RESULT_OK) {
                    Bitmap b = (Bitmap) data.getExtras().get("data");
                    iv.setImageBitmap(b);

                }
            }

        }


        public void opencamera(View view) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, 44);

        }

        public void requstpermission() {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA

            }, 66);

        }

        public boolean checkpermission() {
            int read = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            int write = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            int camea = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            return read == PackageManager.PERMISSION_GRANTED &&
                    write == PackageManager.PERMISSION_GRANTED &&
                    camea == PackageManager.PERMISSION_GRANTED;

        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            if (requestCode==66){
                if (grantResults.length>0&&
                        grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "permission are granted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "permission are dinied", Toast.LENGTH_SHORT).show();

                }
            }
        }
        public void sumbit(View view) {
            String fullname = et_1.getText().toString();
            String gender = s1.getSelectedItem().toString();
            String districts = s2.getSelectedItem().toString();
            String dob = et_3.getText().toString();
            String phoneno = et_4.getText().toString();
            String alternatephoneno = et_5.getText().toString();
            String bloodgroup = s3.getSelectedItem().toString();
            String address = et_7.getText().toString();
            String lasttimeblooddonates = et_8.getText().toString();
            String Password = et_9.getText().toString();
            if (fullname.isEmpty() || gender.isEmpty() || dob.isEmpty() || phoneno.isEmpty() || alternatephoneno.isEmpty() || bloodgroup.isEmpty() ||
                    address.isEmpty() || lasttimeblooddonates.isEmpty() || Password.isEmpty() || districts.isEmpty()) {
                Toast.makeText(this, "plese enter details", Toast.LENGTH_SHORT).show();
            } else {

            }
        }
}
