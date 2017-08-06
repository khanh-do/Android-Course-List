package edu.oaklandcc.occkhanhdo;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * The CourseListFragment class is subclass (fragment) that displays a list of the courses.
 * @author Khanh Do
 * @version November 6, 2016
 * CIS 2818
 */

public class CourseListFragment extends ListFragment {
    public interface CourseListListener {
        void itemClicked(long id);
    }
    private CourseListListener listener;

    /*public CourseListFragment() {
        // Required empty public constructor
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] courseNames = new String[Course.courses.length];
        for (int i = 0; i < courseNames.length; i++) {
            courseNames[i] = Course.courses[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,courseNames);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (CourseListListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
