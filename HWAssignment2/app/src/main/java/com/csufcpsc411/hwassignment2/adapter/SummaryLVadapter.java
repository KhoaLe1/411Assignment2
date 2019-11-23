package com.csufcpsc411.hwassignment2.adapter;

import android.widget.BaseAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csufcpsc411.hwassignment2.R;
import com.csufcpsc411.hwassignment2.model.student;
import com.csufcpsc411.hwassignment2.model.studentDB;

public class SummaryLVadapter extends BaseAdapter {
    @Override
    public int getCount() {
        return studentDB.getInstance().getStudents().size();
    }

    @Override
    public Object getItem(int position) {
        return studentDB.getInstance().getStudents().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row_view;

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            row_view = inflater.inflate(R.layout.row, parent, false);
        } else row_view = convertView;

        student s = studentDB.getInstance().getStudents().get(position);

        TextView firstNameView =  row_view.findViewById(R.id.first_name_id);
        TextView lastNameView = row_view.findViewById(R.id.last_name_id);
        firstNameView.setText(s.getFirstName());
        lastNameView.setText(s.getLastName());
        row_view.setTag(new Integer(position));

        return row_view;
    }
}