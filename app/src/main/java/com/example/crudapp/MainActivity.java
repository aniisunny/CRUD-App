package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Student> arrayOfStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayOfStudents = new ArrayList<>();

        arrayOfStudents.add(new Student("Aniruddha", "CSE", "Chandigarh Univeristy"));
        arrayOfStudents.add(new Student("Divya Ahuja", "CSE", "Banasthali Vidyapith"));
        arrayOfStudents.add(new Student("Rahul Bansal", "CSE", "Chandigarh Univeristy"));
        arrayOfStudents.add(new Student("Riddhi Sharma", "ECE", "UPTU"));
        arrayOfStudents.add(new Student("Simran Kaur", "CSE", "Chandigarh Univeristy"));
        arrayOfStudents.add(new Student("Charu Garg", "CSE", "Banasthali Vidyapith"));

        StudentAdapter adapter = new StudentAdapter (this, arrayOfStudents);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}