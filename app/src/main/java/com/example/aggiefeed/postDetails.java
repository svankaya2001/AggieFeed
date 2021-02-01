package com.example.aggiefeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class postDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        TextView title = (TextView)findViewById(R.id.Title);
        TextView displayName = (TextView)findViewById(R.id.displayName);
        TextView objectType = (TextView)findViewById(R.id.objectType);
        TextView published = (TextView)findViewById(R.id.published);
        final Bundle extras = getIntent().getExtras();
        title.setText(extras.getString("title"));
        displayName.setText(extras.getString("displayName"));
        objectType.setText(extras.getString("objectType"));
        published.setText(extras.getString("published"));
    }
}