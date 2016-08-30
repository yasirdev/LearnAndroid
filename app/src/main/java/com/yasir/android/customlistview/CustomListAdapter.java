package com.yasir.android.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by YasirRajpoot on 29/08/2016.
 */
public class CustomListAdapter extends ArrayAdapter<RowItem> {

    private final Activity context;
    //public ArrayList<RowItem> newData;
    public ArrayList<RowItem> dataList;

    public CustomListAdapter(Activity context, ArrayList<RowItem> data) {
        super(context, R.layout.mylist, data);
        // TODO Auto-generated constructor stub
        //System.out.println(data.size());
        this.context=context;
        this.dataList = data;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        RowItem rowItem = dataList.get(position);
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(rowItem.title);
        imageView.setImageResource(rowItem.image);
        extratxt.setText("Description: "+rowItem.description);
        return rowView;

    };
}