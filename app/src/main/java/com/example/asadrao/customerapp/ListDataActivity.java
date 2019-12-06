package com.example.asadrao.customerapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        listView = (ListView)findViewById(R.id.listview);
        mDatabaseHelper = new DatabaseHelper(this);
        populatelistview();
    }

    private void populatelistview()
    {
        Cursor data = mDatabaseHelper.showData();
        ArrayList<String> ListData = new ArrayList<>();
        while(data.moveToNext())
        {
            ListData.add(data.getString(0));
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ListData);
        listView.setAdapter(listAdapter);
    }
}
