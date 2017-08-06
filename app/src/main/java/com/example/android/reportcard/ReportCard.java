package com.example.android.reportcard;

import java.util.ArrayList;


public class ReportCard {

    private ArrayList<String> mCourses;
    private ArrayList<Integer> mGrades;

    public ReportCard() {
        mCourses = new ArrayList<>();
        mGrades = new ArrayList<>();
    }

    @Override
    public String toString() {
        String reportString = "";
        for(int i=0; i<mCourses.size(); i++) {
            reportString = reportString + mCourses.get(i) + ": " + mGrades.get(i);
            if (i != mCourses.size()){
            reportString = reportString + "\n";
            }
        }

        return reportString;
    }

    public String getCourses(int index) {
        String courseList = "";
        for(int i=0; i<mCourses.size(); i++) {
            courseList = mCourses.get(i);
            if (i != mCourses.size()){
                courseList = courseList + ",";
            }
        }

        return courseList;
    }

    public String getCourse(int index) {
        String course = mCourses.get(index);
        return course;
    }

    public int getGrade(int index) {
        int grade = mGrades.get(index);
        return grade;
    }

    public void addGrade(String courseName, int grade) {
        int courseIndex = getCourseIndex(courseName);
        if (courseIndex != -1) {
            /* course does exist, add at courseIndex */
            mCourses.add(courseIndex,courseName);
            mGrades.add(courseIndex,grade);
        }
        else {
            /* course does exist, add after last existing */
            mCourses.add(courseName);
            mGrades.add(grade);
        }
    }

    /* Helper method to get index of existing course */
    public int getCourseIndex(String courseName) {
        int index;
        index = -1;

        for(int i=0; i<mCourses.size(); i++) {
            if(mCourses.get(i).equals(courseName)) {
                index = i;
            }
        }
        return index;
    }

}
