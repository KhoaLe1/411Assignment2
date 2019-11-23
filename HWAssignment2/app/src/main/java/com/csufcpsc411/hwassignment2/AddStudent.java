package com.csufcpsc411.hwassignment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.csufcpsc411.hwassignment2.model.Courses;
import com.csufcpsc411.hwassignment2.model.student;
import com.csufcpsc411.hwassignment2.model.studentDB;

import java.util.ArrayList;

public class AddStudent extends AppCompatActivity {
    ArrayList<EditText> courseViewList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);
        courseViewList.add((EditText) findViewById(R.id.course_id));
        courseViewList.add((EditText) findViewById(R.id.grade_id));
        Button addCourseButton = findViewById(R.id.add_course);

        addCourseButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        LinearLayout course_id_ll = findViewById(R.id.courseid_ll_id);
                        LinearLayout grade_ll = findViewById(R.id.grade_ll_id);
                        LayoutInflater inflater = LayoutInflater.from(v.getContext());

                        EditText course_id = (EditText) inflater.inflate(R.layout.edit_courses, course_id_ll, false);
                        EditText grade = (EditText) inflater.inflate(R.layout.edit_courses, grade_ll, false);

                        courseViewList.add(course_id);
                        courseViewList.add(grade);

                        course_id_ll.addView(course_id);
                        grade_ll.addView(grade);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next_screen, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_done)
        {

            ArrayList<Courses> courseList = new ArrayList();

            for(int i = 0; i < courseViewList.size(); i += 2)
            {
                courseList.add(new Courses(courseViewList.get(i).getText().toString(),
                        courseViewList.get(i+1).getText().toString()));
            }

            student s = new student
                    (
                        ((EditText) findViewById(R.id.edit_fname)).getText().toString(),
                        ((EditText) findViewById(R.id.edit_lname)).getText().toString(),
                        (((EditText) findViewById(R.id.edit_cwid)).getText().toString())
                    );

            s.setCourses(courseList);
            studentDB.getInstance().addStudent(s);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
