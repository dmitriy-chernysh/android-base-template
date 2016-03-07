package com.cdvdev.basetemplate.views.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cdvdev.basetemplate.R;

/**
 * Base class for ListFragments with SwipeRefresh
 *
 * @author Dmitriy V. Chernysh (dmitriy.chernysh@gmail.com)
 *
 */
public abstract class BaseListFragmentSwipeRefresh extends BaseListFragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    abstract int getLayoutResId();
    abstract SwipeRefresh.OnRefreshListener getOnRefreshListener();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeRefreshLayout = new SwipeRefresh(getActivity().getBaseContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View listFragment = inflater.inflate(getLayoutResId(), container, false);

        //add list view to SwipeRefreshLayout
        mSwipeRefreshLayout.addView(
                listFragment,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );


        //fill fragment
        mSwipeRefreshLayout.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );

        //colors
        TypedArray colors = getResources().obtainTypedArray(R.array.swipe_refresh_colors);
        mSwipeRefreshLayout.setColorSchemeColors(
                colors.getColor(0, 0),
                colors.getColor(1, 0),
                colors.getColor(2, 0),
                colors.getColor(3, 0)
        );

        return mSwipeRefreshLayout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setOnRefreshListener(getOnRefreshListener());
    }

    public SwipeRefreshLayout getSwipeRefreshLayout(){
        return mSwipeRefreshLayout;
    }

    /**
     * Listener for refreshes
     * @param listener SwipeRefreshLayout.OnRefreshListener
     */
    private void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener){
        mSwipeRefreshLayout.setOnRefreshListener(listener);
    }

    /**
     * Check refresh progress
     * @return true - showing
     */
    private boolean isRefreshing(){
        return mSwipeRefreshLayout.isRefreshing();
    }

    /**
     * Stop refresh progress
     */
    private void stopRefreshing(){
        mSwipeRefreshLayout.setRefreshing(false);
    }

    /**
     * Start refresh progress
     */
    private void startRefresh(){
        mSwipeRefreshLayout.setRefreshing(true);
    }

    /**
     * Helper method for show progress
     * @param isShow true - show
     */
    public void showRefreshIndicator(final boolean isShow) {
        final SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if (isShow) {
                            if (!isRefreshing()) {
                                startRefresh();
                            }
                        } else {
                            if (isRefreshing()) {
                                stopRefreshing();
                            }
                        }
                    }
                }
        );
    }


    private class SwipeRefresh extends SwipeRefreshLayout{

        public SwipeRefresh(Context context) {
            super(context);
        }

        /**
         * signal when a swipe-to-refresh' is possible
         *
         * @return true - ListView is visible
         */
        @Override
        public boolean canChildScrollUp() {
            ListView listView = getListView();

            if (listView.getVisibility() == View.VISIBLE) {
                return canListViewScrollUp(listView);
            } else {
                return false;
            }
        }
    }

    /**
     * * Utility method to check whether a ListView can scroll up from it's current position.
     *
     * @param listView
     * @return Boolean
     */
    private static boolean canListViewScrollUp(ListView listView) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            // For ICS and above we can call canScrollVertically() to determine this
            return ViewCompat.canScrollVertically(listView, -1);
        } else {
            // Pre-ICS we need to manually check the first visible item and the child view's top
            // value
            return listView.getChildCount() > 0 &&
                    (listView.getFirstVisiblePosition() > 0
                            || listView.getChildAt(0).getTop() < listView.getPaddingTop());
        }
    }
}
