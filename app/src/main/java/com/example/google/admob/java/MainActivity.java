package com.example.google.admob.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this);

        ShimmerFrameLayout bannerAdLayout = findViewById(R.id.banner_shimmer);

        Button simple_banner_btn = findViewById(R.id.simple_banner_button);
        Button rectangle_banner_btn = findViewById(R.id.medium_rectangle_banner_button);
        Button large_banner_btn = findViewById(R.id.large_banner_button);
        Button recycler_view_btn = findViewById(R.id.recyclerView_button);

        InterstitalAds.loadInterstital( MainActivity.this);

        recycler_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        simple_banner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BannerAds.createBanner(MainActivity.this,bannerAdLayout,1);
            }
        });

        rectangle_banner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BannerAds.createBanner(MainActivity.this,bannerAdLayout,2);
            }
        });

        large_banner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BannerAds.createBanner(MainActivity.this,bannerAdLayout,3);
            }
        });
    }
}