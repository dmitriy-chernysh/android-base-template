package com.cdvdev.basetemplate.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cdvdev.basetemplate.R;
import com.cdvdev.basetemplate.fragments.TestFirstFragment;
import com.cdvdev.basetemplate.fragments.TestSecondFragment;
import com.cdvdev.basetemplate.interfaces.FragmentsListener;

public class MainActivity extends BaseActivity implements FragmentsListener{

    private FragmentManager mFm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFm = getSupportFragmentManager();

        //init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        showFirstFragment();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent layouts.activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showFirstFragment(){
        Fragment fragment = TestFirstFragment.newInstance();
        FragmentTransaction ft = mFm.beginTransaction();
        ft.replace(R.id.fragments_container, fragment)
                .commit();
    }

    //IMPLEMENT FRAGMENTS CALLBACKS 

    @Override
    public void onTestSecondFragment() {
        Fragment fragment = TestSecondFragment.newInstance();
        FragmentTransaction ft = mFm.beginTransaction();
        ft.replace(R.id.fragments_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
