package com.yasir.android.customlistview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");

        String desc = bundle.getString("description");
        String title = bundle.getString("title");
        int image = bundle.getInt("image");
        ImageView img = (ImageView)findViewById(R.id.imageView);
        TextView header = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.desc);
        img.setBackgroundResource(image);
        header.setText(title);
        description.setText(desc);

    }
}
