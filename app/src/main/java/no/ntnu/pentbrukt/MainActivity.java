package no.ntnu.pentbrukt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Menu navMenu;
    private NavigationView navigationView;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navMenu = navigationView.getMenu();

        setMenuSelections();

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ListingsFragment()).commit();
            //Intent i = new Intent(this, ListingActivity.class);
            //startActivity(i);
            return;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;

            case R.id.nav_listings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ListingsFragment()).commit();
                /*Intent i = new Intent(this, ListingActivity.class);
                startActivity(i); */

            case R.id.nav_new_listing:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NewListingFragment()).commit();
                break;

            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MessagesFragment()).commit();
                break;

            case R.id.nav_register_new:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RegistrationFragment()).commit();
                break;

            case R.id.nav_login:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginFragment()).commit();
                break;

            case R.id.nav_logout:
                UserPrefData userPrefData = new UserPrefData(getApplicationContext());
                userPrefData.setToken("");
                setMenuSelections();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginFragment()).commit();
                Toast.makeText(getApplicationContext(), "Logget ut!", Toast.LENGTH_SHORT).show();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    public void setMenuSelections() {

        UserPrefData userPrefData = new UserPrefData(getApplicationContext());
        System.out.println(userPrefData.getToken());
        if (userPrefData.getToken().isEmpty()) {

            // USER IS LOGGED OUT: THERE IS NO TOKEN
            navMenu.findItem(R.id.nav_profile).setVisible(true);
            navMenu.findItem(R.id.nav_settings).setVisible(true);
            navMenu.findItem(R.id.nav_message).setVisible(true);
            navMenu.findItem(R.id.nav_help).setVisible(true);
            navMenu.findItem(R.id.nav_new_listing).setVisible(true);
            navMenu.findItem(R.id.nav_register_new).setVisible(true);
            navMenu.findItem(R.id.nav_login).setVisible(true);

            navMenu.findItem(R.id.nav_logout).setVisible(false);

            // USER IS LOGGED IN: TOKEN IS PRESENT
        } else {
            navMenu.findItem(R.id.nav_register_new).setVisible(false);
            navMenu.findItem(R.id.nav_login).setVisible(false);
            navMenu.findItem(R.id.nav_logout).setVisible(true);
        }

    }

}