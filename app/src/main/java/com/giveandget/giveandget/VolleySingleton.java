package com.giveandget.giveandget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Tavish on 23-Jul-16.
 */
public class VolleySingleton {
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader imageLoader;

    private VolleySingleton(Context context) {
        mRequestQueue= Volley.newRequestQueue(context.getApplicationContext());
        imageLoader= new ImageLoader(mRequestQueue,new ImageLoader.ImageCache()
        {
            private LruCache<String,Bitmap> cache= new LruCache<>((int)Runtime.getRuntime().freeMemory()/1024);

            @Override
            public Bitmap getBitmap(String url)
            {
                return cache.get(url);
            }
            public void putBitmap(String url,Bitmap bitmap)
            {
                cache.put(url,bitmap);
            }
        });
    }

    public static VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
