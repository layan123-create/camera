package com.example.camera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private EditText nameIn;
    private EditText surnameIn;
    private String camIn;
    private EditText addressIn;
    private Button confirmButton,changePictureButton;
    private String name,surname,cam,address;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nameIn = findViewById(R.id.editName);
        surnameIn = findViewById(R.id.editSurName);
        camIn = String.valueOf(findViewById(R.id.editNum));
        addressIn = findViewById(R.id.editAdd);
        confirmButton = findViewById(R.id.buttonConfirm);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameIn.getText().toString();
                surname = surnameIn.getText().toString();
                camIn=camIn.getText().toString();
                address = addressIn.getText().toString();

                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                intent.putExtra("phone", cam);
                intent.putExtra("address", address);
                startActivity(intent);
            }
        });

    }

}