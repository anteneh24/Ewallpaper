package com.atech.ewallpaper;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    GridView mgriGridView;
    Integer[] mImageArray={R.drawable.cat,R.drawable.circule,R.drawable.female,
    R.drawable.parrotsnow,R.drawable.redsnowfal,R.drawable.remain,R.drawable.cow,R.drawable.illusion,R.drawable.imaginery,R.drawable.rotation,
    R.drawable.world};
    Intent cat,circule,daytime,parrotsnow,redsnow,fear,female,illusion,imaginery,rotation,cow;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        mgriGridView= (GridView) findViewById(R.id.gridImageView);
        mgriGridView.setAdapter(new ImageAdapter(getApplicationContext()));
        cat = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        cat.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.Cat.class));

        circule = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        circule.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.Circule.class));

        daytime = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        daytime.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.world.class));

        cow = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        cow.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.cow.class));

        parrotsnow = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        parrotsnow.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.Parrot.class));

        redsnow = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        redsnow.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.RedSnow.class));
        fear = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        fear.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.Fear.class));
        female = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        female.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.female.class));
        illusion = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        illusion.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.illusion.class));
        imaginery = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        imaginery.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.rotation.class));
        rotation = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        rotation.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, com.atech.ewallpaper.rotation.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.i("bbb", "The interstitial wasn't loaded yet.");
        }

    }
    public class ImageAdapter extends BaseAdapter{
        Context context;

        public ImageAdapter(Context context){
            this.context=context;
        }
        public int getCount(){return mImageArray.length;}

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ImageView GridImageView;
            if (view==null){
                GridImageView=new ImageView(context);
                GridImageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
                GridImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            else{
                GridImageView=(ImageView)view;
            }

            GridImageView.setImageResource(mImageArray[i]);
            GridImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mImageArray[i]==R.drawable.cat){
                        startActivity(cat);
                    }else if (mImageArray[i]==R.drawable.redsnowfal){
                        startActivity(redsnow);

                    } else if (mImageArray[i]==R.drawable.parrotsnow){
                        startActivity(parrotsnow);

                    }else if (mImageArray[i]==R.drawable.world){
                        startActivity(daytime);

                    }else if (mImageArray[i]==R.drawable.circule){
                        startActivity(circule);

                    }else if (mImageArray[i]==R.drawable.remain){
                        startActivity(fear);

                    }else if (mImageArray[i]==R.drawable.cow){
                        startActivity(cow);

                    }else if (mImageArray[i]==R.drawable.female){
                        startActivity(female);

                    }else if (mImageArray[i]==R.drawable.illusion){
                        startActivity(illusion);

                    }else if (mImageArray[i]==R.drawable.imaginery){
                        startActivity(imaginery);

                    }else if (mImageArray[i]==R.drawable.rotation){
                        startActivity(rotation);

                    }
                }
            });


            return GridImageView;
        }
    }
}
