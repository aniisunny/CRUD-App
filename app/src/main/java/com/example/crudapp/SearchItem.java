package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);

        final EditText nameEditText = (EditText) findViewById(R.id.searchName);
        final TextView emptyText = (TextView) findViewById(R.id.emptyView);
        final Button searchItemButton = (Button) findViewById(R.id.searchItem);

        searchItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchName = nameEditText.getText().toString();
                int i = 0;

                for (; i < MainActivity.arrayOfStudents.size(); i++) {
                    if (MainActivity.arrayOfStudents.get(i).name.equalsIgnoreCase(searchName)) {
                        break;
                    }
                }

                if (i != MainActivity.arrayOfStudents.size()) {
                    Student s = MainActivity.arrayOfStudents.get(i);
                    emptyText.setText("Name: " + s.name + "\n\nDepartment: " + s.department + "\n\nCollege: " + s.college);
                    Toast.makeText(SearchItem.this, "Search Item Found!", Toast.LENGTH_SHORT).show();
                }
                else {
                    emptyText.setText("No Item Found!");
                }

//                Intent intent = new Intent (SearchItem.this, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}