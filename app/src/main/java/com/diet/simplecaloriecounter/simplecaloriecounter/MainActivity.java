package com.diet.simplecaloriecounter.simplecaloriecounter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.*;
import android.Manifest;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.diet.simplecaloriecounter.simplecaloriecounter.ui.addFoodtoDiary.AddFoodToDiaryFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.food.FoodFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.goal.GoalFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.gps.GPSFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.home.HomeFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.photo.PhotoFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.profile.ProfileFragment;
import com.diet.simplecaloriecounter.simplecaloriecounter.ui.statistics.StatisticsFragment;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import com.diet.simplecaloriecounter.simplecaloriecounter.ui.videoplay.VideoFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AddFoodToDiaryFragment.OnFragmentInteractionListener,
        FoodFragment.OnFragmentInteractionListener,
        GoalFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        StatisticsFragment.OnFragmentInteractionListener {

    private static final int RC_NOTIFICATION = 99 ;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //createNotificationChannelEvening();
        //createNotificationChannelAfternoon();

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBAdapter db = new DBAdapter(this);
        db.open();

        int numberRows = db.count("food");

        if (numberRows < 1) {

            DBSetupInsert setupInsert = new DBSetupInsert(this);
            setupInsert.insertAllFood();
            Toast.makeText(this, "Setup Completed!", Toast.LENGTH_LONG).show();

        }
        numberRows = db.count("users");
        if (numberRows < 1) {
            Toast.makeText(this, "Just a few steps away from signing up", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
        db.close();


        Fragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = HomeFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Navigation items
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /////////////////////////////////////////////////////////////////////////////////////////

        //Stetho.initializeWithDefaults(this);

        //new OkHttpClient.Builder()
        //        .addNetworkInterceptor(new StethoInterceptor())
        //        .build();




        createNotificationChannelMorning();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED) {
            /*Intent intent = new Intent(  MainActivity.this, MorningNotification.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast (  MainActivity.this,  0, intent, PendingIntent.FLAG_IMMUTABLE);
            AlarmManager alarmManager = (AlarmManager) getSystemService ( ALARM_SERVICE);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 18);
            calendar.set(Calendar.MINUTE, 58);
            calendar.set(Calendar.SECOND, 0);
            long triggerTime = calendar.getTimeInMillis();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
            }*/
            setNotificationMorning();
            setNotificationEvening();
            setNotificationAfternoon(20,51,0);

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    RC_NOTIFICATION);
        }


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    private boolean isSameFragment(Fragment fragment1, Fragment fragment2) {
        return fragment1 != null && fragment2 != null && fragment1.getClass().equals(fragment2.getClass());
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.flContent);
        if (fragment != null && !isSameFragment(currentFragment, fragment)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.commit();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.nav_home) {
            fragmentClass = HomeFragment.class;
            replaceFragment(new HomeFragment());
        } else if (id == R.id.nav_profile) {
            fragmentClass = ProfileFragment.class;
            replaceFragment(new ProfileFragment());
        } else if (id == R.id.nav_goal) {
            fragmentClass = GoalFragment.class;
            replaceFragment(new GoalFragment());
        } else if (id == R.id.nav_food) {
            fragmentClass = FoodFragment.class;
            replaceFragment(new FoodFragment());
        } else if (id == R.id.nav_statistics) {
            fragmentClass = StatisticsFragment.class;
            replaceFragment(new StatisticsFragment());
        } else if (id == R.id.nav_gps) {
            fragmentClass = GPSFragment.class;
            replaceFragment(new GPSFragment());
        } else if (id == R.id.nav_photo) {
            fragmentClass = PhotoFragment.class;
            replaceFragment(new PhotoFragment());
        } else if (id == R.id.nav_video) {
            fragmentClass = VideoFragment.class;
            replaceFragment(new VideoFragment());

        }
        /*
        // Try to add item to fragment
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Try to show that content

        FragmentManager fragmentManager = getSupportFragmentManager();


        try {
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        */

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int newOrientation = newConfig.orientation;

        if (newOrientation == Configuration.ORIENTATION_LANDSCAPE) {

        }
    }

    private void createNotificationChannelMorning() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel 1";
            String description = "Channel for morning";
            int importance = NotificationManager. IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel( "channel1", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService (NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void createNotificationChannelEvening() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel 2";
            String description = "Channel for Evening";
            int importance = NotificationManager. IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel( "channel2", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService (NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void createNotificationChannelAfternoon() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel 3";
            String description = "Channel for Afternoon";
            int importance = NotificationManager. IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel( "channel3", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService (NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void createNotificationChannel() {
        CharSequence name = "Lemubit Reminder Channel";
        String description = "Channel for Lemubit Reminder";
        int importance = NotificationManager. IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel( "notifyLemubit", name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = getSystemService (NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

    }

    private void setNotificationMorning(){
        Intent intent = new Intent(  MainActivity.this, MorningNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast (  MainActivity.this,  0, intent, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService ( ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 7);
        calendar.set(Calendar.SECOND, 0);
        long triggerTime = calendar.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        }
    }
    private void setNotificationEvening(){
        Intent intent = new Intent(  MainActivity.this, EveningNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast (  MainActivity.this,  1, intent, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService ( ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 8);
        calendar.set(Calendar.SECOND, 0);
        long triggerTime = calendar.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        }
    }

    private void setNotificationAfternoon(int gio,int phut,int giay){
        Toast.makeText(this,  "Reminder Set!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(  MainActivity.this, AfternoonNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast (  MainActivity.this,  2, intent, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService ( ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, gio);
        calendar.set(Calendar.MINUTE, phut);
        calendar.set(Calendar.SECOND, giay);
        long triggerTime = calendar.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        }
    }
}
