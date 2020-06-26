package com.example.crudapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter (Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Student student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView department = (TextView) convertView.findViewById(R.id.department);
        TextView college = (TextView) convertView.findViewById(R.id.college);

        name.setText(student.name);
        department.setText(student.department);
        college.setText(student.college);

        return convertView;
    }
}
