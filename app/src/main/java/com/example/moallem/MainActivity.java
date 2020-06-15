package com.example.moallem;

import android.content.Intent;
import android.os.Bundle;

import com.example.moallem.Adapters.SubjectAdapter;
import com.example.moallem.Adapters.VideosAdapter;
import com.example.moallem.Models.Subject;
import com.example.moallem.Models.Videos;

import android.util.Log;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , VideosAdapter.HandelClick {
    String[] subjectNames = new String[] { "Physics", "Bio", "Algebra",
            "history", "English"};
    private static int[] imgs = { R.drawable.physics, R.drawable.physics, R.drawable.physics, R.drawable.physics ,R.drawable.physics };
    List<Subject> subjectList ;
    private AppDataBase mdb;
    List<Videos> videosList ;
    RecyclerView subjectRC ,videoRc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        videoRc = findViewById(R.id.videoRC);
        mdb = AppDataBase.getInstance(getApplicationContext());

        addVideosFromRawResourceToDB();
        subjectList = new ArrayList<>();
        for (int i = 0; i < subjectNames.length; i++) {

            Subject model = new Subject();
            model.setSubjectBg(imgs[i]);
            model.setSubjectName(subjectNames[i]);
            subjectList.add(model);
        }
        subjectRC = findViewById(R.id.subjectRC);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
        subjectRC.setLayoutManager(gridLayoutManager);
        SubjectAdapter adapter = new SubjectAdapter(this,subjectList);
        subjectRC.setAdapter(adapter);
        videosList = new ArrayList<>();
        videosList = mdb.videoDao().getAllItems();
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 1);
        gridLayoutManager1.setOrientation(gridLayoutManager.HORIZONTAL);
        VideosAdapter vAdapter = new VideosAdapter(this,videosList,this);
        videoRc.setLayoutManager(gridLayoutManager1);
        videoRc.setAdapter(vAdapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addVideosFromRawResourceToDB() {
        if(mdb.videoDao().getAllItems().size() == 0) {
            Field[] fields = R.raw.class.getFields();
            for (int i = 0; i < imgs.length; i++) {
                Log.i("Raw Asset: ", fields[i].getName());
                //mDBHlpr.addVideo(fields[i].getName());
                Videos model = new Videos();
                model.setVideoImagePath(String.valueOf(imgs[i]));
                model.setVideoPath(fields[i].getName());
                mdb.videoDao().insertItems(model);

            }
        }

    }

    @Override
    public void onHandelClick(int position) {
        Intent intent = new Intent(this,VideoActivity.class);
        intent.putExtra("videoPath",videosList.get(position).getVideoPath());
        //intent.putExtra("VideoImagePath",videosList.get(position).getVideoImagePath());

        startActivity(intent);
    }
}
