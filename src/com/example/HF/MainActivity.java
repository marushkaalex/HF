package com.example.HF;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends SherlockActivity{

    final String LOG_TAG = "myLogs";

    String[] data = {"one", "two", "three", "four", "five"};
    ListView lvMain;
    ArrayAdapter<String> adapter;

    View header1;
    View header2;

    View footer1;
    View footer2;
    HFList hfList;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] t = {"sadf", "sadfsa", " sadf"};
        ArrayList<String> content = new ArrayList<String>(Arrays.asList(t));
        lvMain = (ListView) findViewById(R.id.lvMain);
        hfList = new HFList();
        hfList.createList(this, getApplicationContext(), lvMain, content, 2);

    }


    // нажатие кнопки
    public void onclick(View v) {
        /*Object obj;
        HeaderViewListAdapter hvlAdapter = (HeaderViewListAdapter) lvMain.getAdapter();
        obj = hvlAdapter.getItem(1);
        Log.d(LOG_TAG, "hvlAdapter.getItem(1) = " + obj.toString());
        obj = hvlAdapter.getItem(4);
        Log.d(LOG_TAG, "hvlAdapter.getItem(4) = " + obj.toString());

        ArrayAdapter<String> alAdapter = (ArrayAdapter<String>) hvlAdapter.getWrappedAdapter();
        obj = alAdapter.getItem(1);
        Log.d(LOG_TAG, "alAdapter.getItem(1) = " + obj.toString());
        obj = alAdapter.getItem(4);
        Log.d(LOG_TAG, "alAdapter.getItem(4) = " + obj.toString());*/
        hfList.setHeaderText(HFList.HEADER_1, "lololol");
        hfList.setVisible(HFList.HEADER_1);
        hfList.setHeaderText(HFList.HEADER_2, "lololol");
        hfList.setVisible(HFList.HEADER_2);

    }


}