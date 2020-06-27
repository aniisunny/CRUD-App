package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    static public ArrayList<Student> arrayOfStudents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        arrayOfStudents.add(new Student("Aniruddha", "CSE", "Chandigarh University"));
//        arrayOfStudents.add(new Student("Divya Ahuja", "CSE", "Banasthali Vidyapith"));
//        arrayOfStudents.add(new Student("Rahul Bansal", "CSE", "Chandigarh University"));
//        arrayOfStudents.add(new Student("Riddhi Sharma", "ECE", "AKEG"));
//        arrayOfStudents.add(new Student("Simran Kaur", "CSE", "Chandigarh University"));
//        arrayOfStudents.add(new Student("Charu Garg", "CSE", "Banasthali Vidyapith"));

        final StudentAdapter adapter = new StudentAdapter (this, arrayOfStudents);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        Button addButton = (Button) findViewById(R.id.addItem);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });

//        Button removeButton = (Button) findViewById(R.id.removeItem);
//        removeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = v.getId();
//                //arrayOfStudents.remove(arrayOfStudents.get(position));
//                adapter.remove(position);
//                adapter.notifyDataSetChanged();
//            }
//        });

        Button sortButton = (Button) findViewById(R.id.sortByName);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(arrayOfStudents, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.name.compareTo(o2.name);
                    }
                });
                adapter.notifyDataSetChanged();
            }
        });

        Button searchButton = (Button) findViewById(R.id.searchItem);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SearchItem.class);
                startActivity(intent);
            }
        });
    }
}