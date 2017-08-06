package edu.oaklandcc.occkhanhdo;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * The OCCKhanhDoActivity class is an Android application which displays of list of courses from
 * which a course can be selected. The course details will be displayed, and the course
 * can be selected as completed.
 * @author Khanh Do
 * @version November 6, 2016
 * CIS 2818
 */

public class OCCKhanhDoActivity extends AppCompatActivity
        implements CourseListFragment.CourseListListener, CourseDetailsFragment.CourseDetailsListener {
    private static int coursesCompleted;
    private int coursesToTake;
    private long lastPosition;  //lastPosition is used to keep track of the last fragment displayed
                                //prior to screen rotation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occkhanh_do);

        if (savedInstanceState == null) {
            updateCourseStatus();
            CourseListFragment courseList = new CourseListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.frag_container, courseList);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_reset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_reset:
                for (int i = 0; i < Course.courses.length; i++) {
                    Course.courses[i].setTaken(false);
                }
                updateCourseStatus();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("lastPosition", lastPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            updateCourseStatus();
            if (savedInstanceState.getLong("lastPosition") != -1) {
                lastPosition = savedInstanceState.getLong("lastPosition");
                CourseDetailsFragment details = new CourseDetailsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                details.setCourse(lastPosition);
                transaction.replace(R.id.frag_container, details);
                transaction.addToBackStack(null);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
            }
        }
    }

    @Override
    public void itemClicked(long id) {
        CourseDetailsFragment details = new CourseDetailsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        details.setCourse(id);
        transaction.replace(R.id.frag_container, details);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
        lastPosition = id;
    }

    @Override
    public void checkBoxClicked() {
        updateCourseStatus();
    }

    @Override
    public void showListBtnClicked() {
        CourseListFragment courseList = new CourseListFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frag_container, courseList);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        lastPosition = -1;  //set to -1 to indicate that the last fragment was a CourseListFragment
        // since this number will never be set to the courseId field (not a legal array index)
    }

    public void updateCourseStatus() {
        coursesCompleted = 0;
        for (int j = 0; j < Course.courses.length; j++) {
            if (Course.courses[j].isTaken())
                coursesCompleted = coursesCompleted + 1;
        }
        coursesToTake = Course.courses.length - coursesCompleted;
        TextView textCourseCompleted = (TextView) findViewById(R.id.textCourseCompleted);
        textCourseCompleted.setText("Courses completed: " + coursesCompleted);
        TextView textCoursesToTake = (TextView) findViewById(R.id.textCoursesToTake);
        textCoursesToTake.setText("Courses to take: " + coursesToTake);
    }
}
