package com.example.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefTxt;
    private static  String LARGE_TEXT = "large_text";
    private List<Map<String, String>> contentList;
    private BaseAdapter listContentAdapter;
    private SwipeRefreshLayout swipeLayout;
    private ArrayList<Integer> indexDelItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getApplication().getSharedPreferences("SHARED_PREFS_KEY", MODE_PRIVATE);
        String text = preferences.getString("saved_text", getString(R.string.large_text));
        preferences.edit().putString("saved_text", text).apply();
        prepareContent();

    }


    @NonNull
    private SimpleAdapter createAdapter(String[] stringsTxt) {
        contentList = new ArrayList<>();
        prepareAdapterContent(stringsTxt);
        return new SimpleAdapter(this, contentList, R.layout.list_layout,
                new String[]{"text","lenght"},
                new int[]{R.id.txtText, R.id.txtNumber});
    }


    @NonNull
    private List<Map<String, String>> prepareAdapterContent (String[] stringsTxt) {
        Map<String, String> mapList;
        for (String value: stringsTxt) {
            mapList = new HashMap<>();
            mapList.put("text", value);
            mapList.put("lenght", Integer.toString(value.length()));
            contentList.add(mapList);
        };
        return contentList;
    }

    @NonNull
    private String[] prepareContent() {
        String[] arrayContent = sharedPrefTxt.getString(LARGE_TEXT, "").split("\n\n");
        return  arrayContent;

    }
}