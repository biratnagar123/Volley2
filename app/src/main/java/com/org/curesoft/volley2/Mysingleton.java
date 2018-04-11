package com.org.curesoft.volley2;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Prabin kumar mallick on 31-03-2018.
 */

public class Mysingleton
{
    private static Mysingleton mMysingleton;
    private static RequestQueue mRequestQueue;
    private static Context mCtx;

    private Mysingleton(Context context){
        mCtx=context;
        mRequestQueue=getRequestQueue();
    }

   public static synchronized Mysingleton getInstance(Context context)
   {
      if(mMysingleton==null) {
          mMysingleton=new Mysingleton(context);
      }
      return mMysingleton;
   }

    public RequestQueue getRequestQueue()
    {
      if(mRequestQueue==null) {
          mRequestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());

      }
      return mRequestQueue;
    }
    public<T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }
}
