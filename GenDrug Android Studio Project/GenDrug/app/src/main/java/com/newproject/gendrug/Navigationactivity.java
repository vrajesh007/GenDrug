package com.newproject.gendrug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Navigationactivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userSessionManager=new UserSessionManager(Navigationactivity.this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigationactivity, menu);
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

        } else if (id == R.id.nav_product) {
            Intent intent = new Intent(Navigationactivity.this, productlist.class);
            startActivity(intent);

        }   else if (id == R.id.nav_category) {
                Intent intent= new Intent(Navigationactivity.this,categorylist.class);
                startActivity(intent);

        } else if (id == R.id.nav_symptom) {

        } else if (id == R.id.nav_prescription) {
            Intent intent= new Intent(Navigationactivity.this,prescription.class);
            startActivity(intent);

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_login) {
            Intent intent= new Intent(Navigationactivity.this,login.class);
            startActivity(intent);

        }else if (id == R.id.nav_account) {

        }else if (id == R.id.nav_feedback) {

        }else if (id == R.id.nav_about) {
            Intent intent= new Intent(Navigationactivity.this,aboutus.class);
            startActivity(intent);

        }else if (id== R.id.logout){
            if (userSessionManager.getLoginStatus())
            {
                Toast.makeText(this,"Logged out", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent= new Intent(Navigationactivity.this, login.class);
                startActivity(intent);
            }
        }
        // logout.set

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
