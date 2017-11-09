package com.yasir.android.customlistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YasirRajpoot on 27/10/2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mDataset;

    public MyAdapter(ArrayList<String> mDataset){
        this.mDataset = mDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        ViewHolder vh = null;
        if (viewType == 0){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row, parent, false);

            vh = new ViewHolder(v);

        }else if (viewType == 1){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row, parent, false);

            vh = new ViewHolder1(v);
    }


        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
    public class ViewHolder1 extends ViewHolder {
        public TextView mTitle;
        public ViewHolder1(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
