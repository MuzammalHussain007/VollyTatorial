package com.example.vollytatorial;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Mysigalton {
    private static Mysigalton minstance=null;
    private RequestQueue mRequestQueue;
    private static Context mcontext;

    private Mysigalton(Context mcontext)
    {
        this.mcontext=mcontext;
        mRequestQueue=getRequestQueue();
    }


    public RequestQueue getRequestQueue()

    {
        if (mRequestQueue==null)
        {
            mRequestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
            return mRequestQueue;
        }
        return null;
    }

    public static synchronized Mysigalton getInstance(Context mcontext)
    {
        if (minstance==null)
        {
            minstance= new Mysigalton(mcontext);
            return minstance;
        }
        return null;
    }
    public<T> void addtoRequestQueue(Request<T> request)
    {
        mRequestQueue.add(request);
    }
}
