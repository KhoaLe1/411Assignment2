package com.csufcpsc411.hw2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.csufcpsc411.hw2.adapter.SummaryLVadapter;
import com.csufcpsc411.hw2.model.studentDB;
import com.csufcpsc411.hw2.model.Courses;
import com.csufcpsc411.hw2.model.student;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected SummaryLVadapter SLV;
    protected ListView mSummaryView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createStudentDB();
        setContentView(R.layout.listview);
        mSummaryView = findViewById(R.id.summary_list_view_id);
        SLV = new SummaryLVadapter();
        mSummaryView.setAdapter(SLV);
    }

    protected void createStudentDB()
    {
        ArrayList<student> studentList = new ArrayList();

        student s = new student("Mike", "Whaling", "987654321");
        ArrayList<Courses> coursesEnrolled = new ArrayList();
        coursesEnrolled.add(new Courses("0", "A"));
        coursesEnrolled.add(new Courses("1", "B"));
        coursesEnrolled.add(new Courses("2", "D"));

        s.setCourses(coursesEnrolled);
        studentList.add(s);

        s = new student("Louie", "Lopez", "123456789");
        coursesEnrolled = new ArrayList();
        coursesEnrolled.add(new Courses("0", "B"));
        coursesEnrolled.add(new Courses("1", "B"));
        coursesEnrolled.add(new Courses("2", "C"));

        s.setCourses(coursesEnrolled);
        studentList.add(s);

        studentDB.getInstance().setStudents(studentList);
    }
//added for part 2

    //edit
    @Override
    protected void onStart() { super.onStart(); SLV.notifyDataSetChanged(); }

    //display menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summary_screen, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    //add screen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddStudent.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}
