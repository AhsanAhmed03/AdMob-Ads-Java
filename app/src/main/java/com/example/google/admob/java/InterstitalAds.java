package com.example.google.admob.java;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;

public class InterstitalAds {

    public static AdManagerInterstitialAd adManagerInterstitialAd;

    public static void loadInterstital(Context context, Activity activity){

        Log.e("InterstitalAds","Load Interstital Ad Method");

        AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();

        AdManagerInterstitialAd.load(context, AppAdsId.INTERSTITAL_ID,
                adRequest, new AdManagerInterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e("InterstitalAds","Interstital Failed to Load: "+loadAdError.getMessage());
            }

            @Override
            public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                super.onAdLoaded(adManagerInterstitialAd);
                Log.e("InterstitalAds","Interstital Loaded...");
                adManagerInterstitialAd = interstitialAd;
            }
        });
    }

    public static void showInterstital(Context context, Activity activity){

        if (adManagerInterstitialAd != null){

            adManagerInterstitialAd.show(activity);
            adManagerInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                    Log.e("InterstitalAds","Interstital Ad Clicked...");
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    Log.e("InterstitalAds","Interstital Ad Dismissed...");
                    adManagerInterstitialAd = null;
                    loadInterstital(context, activity);
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    Log.e("InterstitalAds","Interstital Ad Failed to Show: "+adError.getMessage());
                    adManagerInterstitialAd = null;
                    loadInterstital(context, activity);
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                    Log.e("InterstitalAds","Interstital Ad Impression Counted ");

                }

                @Override
                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();
                    Log.e("InterstitalAds","Interstital Ad Shown FullScreen");

                }
            });
        }else{
            Log.e("InterstitalAds","Interstital Ad is Null...");
            loadInterstital(context, activity);
        }
    }
}
