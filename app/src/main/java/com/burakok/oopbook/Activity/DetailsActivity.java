package com.burakok.oopbook.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.burakok.oopbook.Model.Simpson;
import com.burakok.oopbook.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView = findViewById(R.id.imageView);
        TextView nameText = findViewById(R.id.nameText);
        TextView jobText = findViewById(R.id.jobText);

        Intent intent = getIntent(); //gonderilen bilgiler alınır
        Simpson selectedSimpson = (Simpson) intent.getSerializableExtra("selectedSimpson");//selectedSimpson adıyla yakalanır ve serialize edilir

        //selectedSimpson ile resim id ile yakalınır cozulur imageView'e set edilir
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources() ,selectedSimpson.getPictureId());
        imageView.setImageBitmap(bitmap);

        nameText.setText(selectedSimpson.getName());//isim set edilir
        jobText.setText(selectedSimpson.getJob());//iş set edilir
    }
}
