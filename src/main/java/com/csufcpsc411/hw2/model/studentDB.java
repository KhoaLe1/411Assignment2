package com.csufcpsc411.hw2.model;

import java.util.ArrayList;

public class studentDB {
    private static final studentDB ourInstance = new studentDB();

    protected ArrayList<student> mStudents;

    static public studentDB getInstance() {
        return ourInstance;
    }

    public ArrayList<student> getStudents() {
        return mStudents;
    }

    public void setStudents(ArrayList<student> students) {
        mStudents = students;
    }

    public void addStudent(student student){
        mStudents.add(student);
    }
}
