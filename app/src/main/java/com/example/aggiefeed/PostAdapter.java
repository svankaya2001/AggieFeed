package com.example.aggiefeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter<Post> {
    public PostAdapter(@NonNull Context context, ArrayList<Post> posts) {
        super(context, 0, posts);
    }
    public class ViewHolder{
        public TextView title;
        public TextView displayName;
        public TextView objectType;
        public TextView published;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Post post = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.post, parent, false);
        viewHolder.title = (TextView)convertView.findViewById(R.id.Title);
        viewHolder.displayName = (TextView)convertView.findViewById(R.id.displayName);
        convertView.setTag(viewHolder);
        viewHolder.title.setText(post.getTitle());
        viewHolder.displayName.setText(post.getDisplayName());


        return convertView;

    }


}
