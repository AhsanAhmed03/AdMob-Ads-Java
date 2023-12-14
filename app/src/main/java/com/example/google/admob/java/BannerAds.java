package com.example.google.admob.java;

import android.content.Context;

import androidx.annotation.NonNull;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class BannerAds {

    public static void createBanner(Context context, ShimmerFrameLayout bannerAdLayout,
                                    int value){

        AdView adview = new AdView(context);
        AdRequest adRequest = new AdRequest.Builder().build();

        if (bannerAdLayout.getChildCount() > 0){
            bannerAdLayout.removeAllViews();
        }

        switch (value){
            case 1:
                bannerAdLayout.setMinimumHeight(AdSize.BANNER.getHeight());
                adview.setAdSize(AdSize.BANNER);
                adview.setAdUnitId(AppAdsId.BANNER_AD_ID);
                adview.loadAd(adRequest);
                break;

            case 2:
                bannerAdLayout.setMinimumHeight(AdSize.MEDIUM_RECTANGLE.getHeight());
                adview.setAdSize(AdSize.MEDIUM_RECTANGLE);
                adview.setAdUnitId(AppAdsId.BANNER_AD_ID);
                adview.loadAd(adRequest);
                break;

            case 3:
                bannerAdLayout.setMinimumHeight(AdSize.LARGE_BANNER.getHeight());
                adview.setAdSize(AdSize.LARGE_BANNER);
                adview.setAdUnitId(AppAdsId.BANNER_AD_ID);
                adview.loadAd(adRequest);
                break;
        }

        adview.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                bannerAdLayout.hideShimmer();
                bannerAdLayout.addView(adview);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });
    }
}
