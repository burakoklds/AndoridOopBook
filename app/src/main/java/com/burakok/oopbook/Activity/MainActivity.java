package com.burakok.oopbook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.burakok.oopbook.Adapter.CustomAdapter;
import com.burakok.oopbook.Model.Simpson;
import com.burakok.oopbook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView); //ListView Id'yi yakalıyoruz

        //Simpson objelerini olusturuyoruz
        Simpson homer = new Simpson("Homer Simpson" , "Nuclear", R.drawable.homer);
        Simpson lisa = new Simpson("Lisa Simpson" , "Student", R.drawable.lisa);
        Simpson bart = new Simpson("Bart Simpson" , "Student", R.drawable.barth);

        //Simpson objelerini bir list'e ekliyoruz
        final ArrayList<Simpson> simpsonList = new ArrayList<>();
        simpsonList.add(homer);
        simpsonList.add(lisa);
        simpsonList.add(bart);

        //Olusturdugumuz customAdaptor Clasını new'leyip simpsonList'i ve Activiy'i gönderiyoruz
        CustomAdapter customAdapter = new CustomAdapter(simpsonList , MainActivity.this);
        listView.setAdapter(customAdapter); //MainActiviy'deki listView'e customAdaptor'ı ekliyoruz

        //listView'de tıklanan item'ı alacagız
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class); //MainAcitivity'den DetailActivity'e gidecegiz
                intent.putExtra("selectedSimpson" , simpsonList.get(position));
                startActivity(intent);
            }
        });
    }
}