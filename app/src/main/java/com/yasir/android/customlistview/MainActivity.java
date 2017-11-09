package com.yasir.android.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ListView list;
    ArrayList<RowItem> itemList;




    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };

    String description ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";

    Integer[] imgid={
        R.drawable.icon1,
        R.drawable.icon2,
        R.drawable.icon3,
        R.drawable.icon4,
        R.drawable.icon5,
        R.drawable.icon6,
        R.drawable.icon7,
        R.drawable.icon8,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONArray jsonArray = new JSONArray();

        for (int a = 0; a<imgid.length; a++){
            JSONObject obj1 = new JSONObject();
            try {
                obj1.put("id", a);
                obj1.put("name",itemname[a]);
                obj1.put("image", imgid[a]);

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(obj1);
        }

        JSONObject studentsObj = new JSONObject();
        try {
            studentsObj.put("data", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = studentsObj.toString();

        System.out.println("jsonString: "+jsonStr);


        itemList = new ArrayList<RowItem>();
        for (int a = 0; a<itemname.length; a++){
        //String id = studentsObj.getJSONArray("data").getJSONObject(a).getString("id");
            try {
                itemList.add(new RowItem(Integer.parseInt(studentsObj.getJSONArray("data").getJSONObject(a).getString("id")),
                studentsObj.getJSONArray("data").getJSONObject(a).getString("name"),
                description,
                Integer.parseInt(studentsObj.getJSONArray("data").getJSONObject(a).getString("image"))));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        CustomListAdapter adapter=new CustomListAdapter(this, itemList);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //TODO Auto-generated method stub
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem + ": id=  " + itemList.get(position).id, Toast.LENGTH_SHORT).show();
                Bundle newBund = new Bundle();
                newBund.putInt("id", itemList.get(position).id);
                newBund.putInt("image", itemList.get(position).image);
                newBund.putString("description", itemList.get(position).description);
                newBund.putString("title", itemList.get(position).title);
                Intent i = new Intent(MainActivity.this, DetailPage.class);
                i.putExtras(newBund);
                startActivity(i);
            }
        });
    }
}
