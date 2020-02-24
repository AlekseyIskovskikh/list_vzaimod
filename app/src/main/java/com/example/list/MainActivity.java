package com.example.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SharedPreferences sharedPrefTxt;
    private SwipeRefreshLayout swipeLayout;
    private static  String LARGE_TEXT = "large_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paperContent();
        SharedPreferences preferences = getApplication().getSharedPreferences("SHARED_PREFS_KEY", MODE_PRIVATE);
        String text = preferences.getString("saved_text", getString(R.string.large_text));
        preferences.edit().putString("saved_text", text).apply();
    }


    private void paperContent(){
        String[] arrayContent = sharedPrefTxt.getString(LARGE_TEXT, "").split("\n\n");
        List<Map<String, String>> arrayList= new ArrayList<>();
        Map<String, String> map;
        for (String value: arrayContent){
            map = new HashMap<>();
            map.put("text", value);
            map.put("lenght", Integer.toString(value.length()));
            arrayList.add(map);

        }

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.list_layout,
                new String[]{"text","lenght"},
                new int[]{R.id.txtText, R.id.txtNumber});
        listView.setAdapter(adapter);
    }
}