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
    }
    private void paperContent(){
        listView=findViewById(R.id.list_view1);
        List<Map<String, String>> arrayList= new ArrayList<>();
        Map<String, String> map;




        // информация 1
        map = new HashMap<>();
        String stringValueTxt1 = "The Internet is increasingly used as a source of health-related information," +
                " and a vast majority of Internet users are performing health-related searches in the United States and Europe," +
                " with wide differences among countries. Health information searching behavior on the Internet is affected by" +
                " multiple factors, including demographics, socioeconomic factors, education, employment, attitudes toward the" +
                " Internet, and health conditions, and their knowledge may help to promote a safer use of the Internet. Limited" +
                " information however exists so far about Internet use to search for medical information in Italy";
        map.put("Text", stringValueTxt1);
        map.put("Name", String.valueOf(stringValueTxt1.length()));
        arrayList.add(map);

        map = new HashMap<>();
        String stringValueTxt2 = "Both authors equally contributed to study conception and design as well as to analysis and " +
                "interpretation of data. SL was responsible for acquisition of data. Both authors were involved in drafting" +
                " the paper and revising it critically for important intellectual content and approved the final version to" +
                " be published";
        map.put("Text", stringValueTxt2);
        map.put("Name", String.valueOf(stringValueTxt2.length()));
        arrayList.add(map);


        map = new HashMap<>();
        String stringValueTxt3 ="The objective of this study was to investigate the use of the Internet for searching for " +
                "information on medicines and disease in adult subjects in Northern Italy";
        map.put("Text", stringValueTxt3);
        map.put("Name", String.valueOf(stringValueTxt3.length()));
        arrayList.add(map);

        map = new HashMap<>();
        String stringValueTxt4 = "The study provides detailed information on the use of the Internet for searching for information" +
                " on medicines and disease in the Italian population. Gender, age, social status and level of education," +
                " and the previous use of medicines, affect searching behaviors and use patterns. Results can support educational " +
                "interventions to promote the retrieval of high-quality information by Internet users and health " +
                "professionals advising patients about appropriate use of Internet for health-related purposes";
        map.put("Text", stringValueTxt4);
        map.put("Name", String.valueOf(stringValueTxt4.length()));
        arrayList.add(map);

        map = new HashMap<>();
        String stringValueTxt5 = "The survey enrolled a total of 1008 participants. Their demographic details are shown in Table 1." +
                " The median age was 43 years (interquartile range: 34-51), with a range of 14 to 88 years. " +
                "Most of the participants were married or cohabiting (61.8%) or single (30.3%), with no differences between" +
                " women and men. Nearly 70% of the participants had secondary school or university degrees. University degrees" +
                " were declared more frequently by women than men (26.0% vs 19.4%). Nearly 73% of respondents were employed," +
                " and 10% were retired. In comparison to women, men were more likely to be employed (79.5% vs 68.1%) or retired " +
                "(13.7% vs 7.5%), whereas women were more likely to be unemployed (2.6% vs 0.7%) and housewives (15.2% vs 0.0%)";
        map.put("Text", stringValueTxt5);
        map.put("Name", String.valueOf(stringValueTxt5.length()));
        arrayList.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.list_layout,
                new String[]{"Name","Text"},
                new int[]{R.id.txtText, R.id.txtNumber});
        listView.setAdapter(adapter);
    }
}
