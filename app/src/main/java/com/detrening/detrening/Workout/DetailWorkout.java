package com.detrening.detrening.Workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.detrening.detrening.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import pl.droidsonroids.gif.GifImageView;

public class DetailWorkout extends AppCompatActivity {
    TextView judul, deskripsi;
    GifImageView gifGerakan;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_workout);
        setTitle("Detail Workout");

        judul = (TextView) findViewById(R.id.detailJudul);
        deskripsi = (TextView) findViewById(R.id.detailDeskripsi);
        gifGerakan = (GifImageView) findViewById(R.id.detailGif);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent i = getIntent();
 //       String url= i.getStringExtra("gambar");

        int gifger = getIntent().getIntExtra("gambar", 1);
      //  gifGerakan.setImageDrawable(getResources().getDrawable(gifger));
        Glide.with(this).load(gifger).into(gifGerakan);
        judul.setText(getIntent().getStringExtra("nama"));
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
