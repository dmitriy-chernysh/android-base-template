package com.cdvdev.basetemplate.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cdvdev.basetemplate.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestFirstFragment extends BaseFragment {

    private Button mButton;

    public static Fragment newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment fragment = new TestFirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_first, container, false);
        mButton = (Button) view.findViewById(R.id.test_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mFragmentsListener.onTestSecondFragment();
            }
        });

        return view;
    }

}
