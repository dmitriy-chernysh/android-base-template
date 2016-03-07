package com.cdvdev.basetemplate.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import com.cdvdev.basetemplate.interfaces.FragmentsListener;

/**
 * Base class for ListFragments
 * <p/>
 * Note: Write here a common code for all ListFragments
 *
 * @author Dmitriy V. Chernysh (dmitriy.chernysh@gmail.com)
 */
public class BaseListFragment extends ListFragment {

    protected FragmentsListener mFragmentsListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //save fragment`s object
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = null;
        try {
            if (context instanceof Activity) {
                activity = (Activity) context;
                mFragmentsListener = (FragmentsListener) activity;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must be implement FragmentsListener");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentsListener = null;
    }
}
