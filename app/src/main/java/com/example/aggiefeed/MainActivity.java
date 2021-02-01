package com.example.aggiefeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    PostAdapter postAdapter;
    PostClient postClient;
    ListView postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postsList = (ListView)findViewById(R.id.posts);
        ArrayList<Post> posts = new ArrayList<Post>();
        postAdapter = new PostAdapter(this, posts);
        postsList.setAdapter(postAdapter);
        fetchPosts();
    }

    private void fetchPosts() {
        postClient = new PostClient();
        postClient.getPosts(new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                   final ArrayList<Post> posts = Post.getPosts(response);
                   postAdapter.clear();
                   Log.d("tag", String.valueOf(response.length()));
                   for(Post post:posts){
                       postAdapter.add(post);
                   }
                   postAdapter.notifyDataSetChanged();

                   postsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                           Intent intent = new Intent(MainActivity.this, postDetails.class);
                           intent.putExtra("title", posts.get(i).getTitle());
                           intent.putExtra("displayName", posts.get(i).getDisplayName());
                           intent.putExtra("objectType", posts.get(i).getObjectType());
                           intent.putExtra("published", posts.get(i).getPublished());
                           startActivity(intent);
                       }
                   });
            }
        });
    }
}