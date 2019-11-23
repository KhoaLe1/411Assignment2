package com.csufcpsc411.hwassignment2.model;

import java.util.ArrayList;

public class student {

    protected String mFirstName;
    protected String mLastName;
    protected String mCWID;


    protected ArrayList<Courses> mCourses;

    public student(String firstName, String lastName, String CWID) {
        mFirstName = firstName;
        mLastName = lastName;
        mCWID = CWID;
    }
    public String getLastName() {
        return mLastName;
    }



    public void setCourses(ArrayList<Courses> coursesEnrolled) {
        mCourses = coursesEnrolled;
    }


    public String getFirstName() {
        return mFirstName;
    }





}
