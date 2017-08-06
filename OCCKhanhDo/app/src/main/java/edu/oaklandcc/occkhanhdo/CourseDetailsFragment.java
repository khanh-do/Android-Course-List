package edu.oaklandcc.occkhanhdo;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * The CourseDetailsFragment class is a subclass (fragment) that displays the details of the course
 * that was selected by the user.
 * @author Khanh Do
 * @version November 6, 2016
 * CIS 2818
 */

public class CourseDetailsFragment extends Fragment {
    public interface CourseDetailsListener {
        void checkBoxClicked();
        void showListBtnClicked();
    }

    private CourseDetailsListener detailsListener;
    private CourseDetailsListener showListListener;
    private long courseId;

    /*public CourseDetailsFragment() {
        // Required empty public constructor
    }*/

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            courseId = savedInstanceState.getLong("courseId");
        }
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView textName = (TextView) view.findViewById(R.id.textName);
            Course course = Course.courses[(int) courseId];
            textName.setText(course.getName());
            TextView textTitle = (TextView)view.findViewById(R.id.textTitle);
            textTitle.setText(course.getTitle());
            TextView textDescription = (TextView)view.findViewById(R.id.textDescription);
            textDescription.setText(course.getDescription());
            CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);
            if (course.isTaken())
                checkBox.setChecked(true);
            else
                checkBox.setChecked(false);
        }

        CheckBox check = (CheckBox)getActivity().findViewById(R.id.checkBox);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check1 = (CheckBox)getActivity().findViewById(R.id.checkBox);
                if ( check1.isChecked() )
                    Course.courses[ (int)courseId ].setTaken(true);
                else if ( !check1.isChecked() )
                    Course.courses[ (int)courseId ].setTaken(false);
                detailsListener.checkBoxClicked();
            }
        });

        Button button = (Button)getActivity().findViewById(R.id.btnShowList);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListListener.showListBtnClicked();
            }
        });
    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("courseId", courseId);
    }*/

    public void setCourse(long id) {
        this.courseId= id;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.detailsListener = (CourseDetailsListener)activity;
        this.showListListener = (CourseDetailsListener)activity;
    }
    /*public void onCheckBoxClick(View v) {

        detailsListener.checkBoxClicked();
    }*/

    /*@Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(null);
        CheckBox check = (CheckBox)getActivity().findViewById(R.id.checkBox);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check1 = (CheckBox)getActivity().findViewById(R.id.checkBox);
                if (check1.isChecked())
                    Course.courses[(int)courseId].setTaken(true);
                else if ( !check1.isChecked() )
                    Course.courses[(int)courseId].setTaken(false);
                detailsListener.checkBoxClicked();

            }
        });
    }*/
}
