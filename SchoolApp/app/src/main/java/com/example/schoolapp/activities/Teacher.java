package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.schoolapp.R;

import java.util.ArrayList;

public class Teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

       /* Bundle a = getIntent().getExtras();

        String  name = a.getString("name");

        TextView n = findViewById(R.id.textView2);

        n.setText("Welcome Teacher : "+ name );*/

        ArrayList<Section> sectionList = new ArrayList<>();

        //edu المرحلة الدراسية  name اسم الطالب  img  صور الطالب
        Section s1 = new Section("10th grade","Salman",R.drawable.pngegg);
        Section s2 = new Section("20th grade","Yousuf",R.drawable.yus);
        Section s3 = new Section("12th grade","Hussain AKA Bo Ali",R.drawable.sal);
        Section s4 = new Section("11th grade","Barrak",R.drawable.sd);
        Section s5 = new Section("12th grade","Hassan",R.drawable.has);
        Section s6 = new Section("8th grade","Rawan",R.drawable.rw);


        sectionList.add(s1);
        sectionList.add(s2);
        sectionList.add(s3);
        sectionList.add(s4);
        sectionList.add(s5);
        sectionList.add(s6);



        RecyclerView sectionL = findViewById(R.id.rv);

        sectionL.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        sectionL.setLayoutManager(lm);

        SectionAdapter sa = new SectionAdapter(sectionList,Teacher.this);
        sectionL.setAdapter(sa);


    }
}