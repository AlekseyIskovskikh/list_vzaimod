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
        listView = findViewById(R.id.list);
        sharedPrefTxt = getApplication().getSharedPreferences("SHARED_PREFS_KEY", MODE_PRIVATE);
        String text = sharedPrefTxt.getString(LARGE_TEXT, getString(R.string.large_text));
        sharedPrefTxt.edit().putString(LARGE_TEXT, text).apply();
        paperContent();
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

        final SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.list_layout,
                new String[]{"text","lenght"},
                new int[]{R.id.txtText, R.id.txtNumber});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = ((TextView)view).getText().toString();
               
                adapter.notifyDataSetChanged();
            }
        });

//        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//            }
//        });
    }
}