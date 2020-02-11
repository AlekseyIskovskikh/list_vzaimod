package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

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
        map.put("Text", "\"Исследуйте стартовое приложение, находящееся в папке ./code.\\n\" +\n" +
                "                \"Добавьте ConstraintLayout в app/build.gradle. (implementation 'androidx.constraintlayout:constraintlayout:1.1.3).\\n\" +\n" +
                "                \"Создать xml файл в папке res/layout для элемента списка на основе ConstraintLayout, состоящий из двух TextView, один под другим.");
        map.put("Name", "1");
        arrayList.add(map);

        map = new HashMap<>();
        map.put("Text", "Еще раз повторите конструктор SimpleAdapter. Без детального понимания следующие два пункта будет сложно выполнить.\\n\" +\n" +
                "                \"Изменить метод prepareContent так, чтобы он возвращал список словарей строк (List<Map<String, String>>), нужный для SimpleAdapter. \" +\n" +
                "                \"Из каждого элемента списка мы будем создавать строку в интерфейсе, каждый элемент должен содержать заголовок и подзаголовок. \" +\n" +
                "                \"То есть в каждом элементе списка (Map<String, String>) должно быть 2 записи (MapEntry<String, String>), одна для заголовка, \" +\n" +
                "                \"вторая для подзаголовка. В качестве заголовка используем элемент массива строк из оригинального приложения (\" +\n" +
                "                \"String[] arrayContent = getString(R.string.large_text).split(\\\"\\\\n\\\\n\\\"); arrayContent[i];),\" +\n" +
                "                \" подзаголовком будет длина этой строки (arrayContent[i].length()).");
        map.put("Name", "2");
        arrayList.add(map);

        map = new HashMap<>();
        map.put("Text", "В методе createAdapter измените входной параметр на List<Map<String, String>>\" +\n" +
                "                \" и создайте SimpleAdapter вместо ArrayAdapter, так, чтобы заголовок и подзаголовок отображались в каждой строке. \" +\n" +
                "                \"Для этого используйте layout, созданный в пенкте 3, и параметры from (ключи словаря с заголовком и подзаголовком из пункта 5)\" +\n" +
                "                \" и to (id элементов TextView, созданных в пункте 3) конструктора SimpleAdapter.\\n");
        map.put("Name", "3");
        arrayList.add(map);

        map = new HashMap<>();
        map.put("Text", "Запустите приложение, объясните, почему не потребовалось менять тип\" +\n" +
                "                \" возвращаемого значения из метода createAdapter.");
        map.put("Name", "4");
        arrayList.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, android.R.layout.simple_expandable_list_item_2,
                new String[]{"Name","Text"},
                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);
    }
}
