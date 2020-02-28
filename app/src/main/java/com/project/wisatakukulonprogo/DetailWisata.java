package com.project.wisatakukulonprogo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailWisata extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Wisata wisataditerima = getIntent().getParcelableExtra("key");
        ImageView gamabar = (ImageView)findViewById(R.id.img_item_photo);
        TextView name = (TextView)findViewById(R.id.tv_item_name);
        TextView deskripsi = (TextView)findViewById(R.id.content_detail);
        TextView lokasi = (TextView)findViewById(R.id.content_lokasi);
       

        Glide.with(this).load(wisataditerima.getPhoto())
                .apply(new RequestOptions().override(350, 350)).into(gamabar);
        name.setText(wisataditerima.getName());
        deskripsi.setText(wisataditerima.getDeskripsi());
        lokasi.setText(wisataditerima.getLokasi());

        Log.i("photo", wisataditerima.getPhoto());
        Log.i("deskripsi", wisataditerima.getDeskripsi());
    }
}
