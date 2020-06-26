package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final EditText nameEditText = (EditText) findViewById(R.id.newName);
        final EditText departmentEditText = (EditText) findViewById(R.id.newDepartment);
        final EditText collegeEditText = (EditText) findViewById(R.id.newCollege);
        final Button addItemButton = (Button) findViewById(R.id.addItem);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = nameEditText.getText().toString();
                String departmentString = departmentEditText.getText().toString();
                String collegeString = collegeEditText.getText().toString();

                MainActivity.arrayOfStudents.add (new Student(nameString, departmentString, collegeString));

                Intent intent = new Intent (AddItem.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}