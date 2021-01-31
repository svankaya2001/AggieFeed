package com.example.aggiefeed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Post {
    private String title;
    private String displayName;
    private String objectType;
    private String published;

    public String getTitle(){
        return title;
    }
    public String getDisplayName(){
        return displayName;
    }
    public String getObjectType(){
        return objectType;
    }
    public String getPublished(){
        return published;
    }

    public Post getData(JSONObject jsonObject){
        Post post = new Post();
        try {
            JSONObject actorInfo = jsonObject.getJSONObject("actor");
            JSONObject objectInfo = jsonObject.getJSONObject("object");
            post.title = jsonObject.getString("title");
            post.displayName = actorInfo.getString("displayName");
            post.objectType = objectInfo.getString("objectType");
            post.published = jsonObject.getString("published");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return post;
    }

    public ArrayList<Post> getPosts(JSONArray jsonArray){
        ArrayList<Post> posts = new ArrayList<Post>(25);
        for(int i=0; i<25;i++){
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Post post = getData(jsonObject);
                posts.add(post);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return posts;
    }
}
