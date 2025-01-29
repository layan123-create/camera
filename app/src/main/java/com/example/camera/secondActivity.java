package com.example.camera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

public class secondActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button BackButton;
    private TextView image;
    private String details;
    private ImageView imageView;
    private Bitmap imageBitmap;
    private bundle extras;
    private String name,surname,cam,address,de;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        changePictureButton = findViewById(R.id.buttonChange);
        changePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            }
        });
        details = findViewById(R.id.textViewD);
        BackButton = findViewById(R.id.buttonBack);
        imageView = findViewById(R.id.imageView);
        
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        surname = intent.getStringExtra("surname");
        cam = intent.getStringExtra("phone");
        address = intent.getStringExtra("address");

        details = "Name: " + name + "\nSurname: " + surname + "\nCam: " + cam + "\nAddress: " + address;
        details.setText(de);
        imageBitmap = (Bitmap) intent.getParcelableExtra("image");
        if (imageBitmap != null) {
            imageView.setImageBitmap(imageBitmap);

        }
    }
    puplic void back(View view)
    {
        finish();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            extras=data.getExtras();
            imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
