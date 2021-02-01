package com.example.aggiefeed;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class PostClient {
    public static final String url = "https://aggiefeed.ucdavis.edu/api/v1/activity/public?s=0&l=25";
    private AsyncHttpClient asyncHttpClient;

    public PostClient(){
        asyncHttpClient = new AsyncHttpClient();
    }

    public void getPosts(JsonHttpResponseHandler jsonHttpResponseHandler){
        asyncHttpClient.get(url, jsonHttpResponseHandler);
    }

}
