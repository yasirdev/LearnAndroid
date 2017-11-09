package com.yasir.android.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DetailPage extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        mDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDataset.add("New Title # "+ i);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");

        String desc = bundle.getString("description");
        String title = bundle.getString("title");
        int image = bundle.getInt("image");
        //ImageView img = (ImageView)findViewById(R.id.imageView);
        //TextView header = (TextView) findViewById(R.id.title);
        //TextView description = (TextView) findViewById(R.id.desc);
        //img.setBackgroundResource(image);
        //header.setText(title);
        //description.setText(desc);

    }
}
