package com.burakok.oopbook.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.burakok.oopbook.Model.Simpson;
import com.burakok.oopbook.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Simpson> {

    private ArrayList<Simpson> simpsons;
    private Activity context;

    public  CustomAdapter(ArrayList<Simpson> simpsons , Activity context) {
        super(context, R.layout.custom_view , simpsons);
        this.simpsons = simpsons;
        this.context = context;
    }

    @NonNull
    @Override  //CustomAdapter ile CustomView'i birbirine baglıyoruz
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater(); //main activity'de gosterilmesini saglıyor
        View customView = layoutInflater.inflate(R.layout.custom_view , null,true);

        TextView nameView = customView.findViewById(R.id.customTextView);//CustomView layout'undan customTextView id'yi yakalabiliyor
        nameView.setText(simpsons.get(position).getName()); //nameView listesindeki isimleri alıyoruz

        return customView;
    }
}
