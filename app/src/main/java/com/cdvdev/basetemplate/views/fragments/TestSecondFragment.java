package com.cdvdev.basetemplate.views.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.cdvdev.basetemplate.R;
import com.cdvdev.basetemplate.views.adapters.TestAdapter;
import com.cdvdev.basetemplate.models.TestModel;

import java.util.ArrayList;

/**
 * Test fragment for demonstrate SwipeRefresh
 *
 * @author Dmitriy V. Chernysh (dmitriy.chernysh@gmail.com)
 */
public class TestSecondFragment extends BaseListFragmentSwipeRefresh {

    public static Fragment newInstance() {

        Bundle args = new Bundle();

        Fragment fragment = new TestSecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    int getLayoutResId() {
        return R.layout.fragment_test_second;
    }


    @Override
    SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO: put here operation for refresh list data
                //...

                //it`s only for demonstrate SwipeRefresh process-->
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showRefreshIndicator(false);
                    }
                }, 4000);
                //<--it`s only for demonstrate SwipeRefresh
            }
        };
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //it`s only for demonstrate SwipeRefresh-->
        ArrayList<TestModel> testList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestModel model = new TestModel();
            model.setItemName("Item " + (i + 1));
            testList.add(model);
        }
        ArrayAdapter<TestModel> adapter = new TestAdapter(getActivity(), testList);
        //<--it`s only for demonstrate SwipeRefresh

        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Attention!!! It is important for work SwipeRefresh
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
