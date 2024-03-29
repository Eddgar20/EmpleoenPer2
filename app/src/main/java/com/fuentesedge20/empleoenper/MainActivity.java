package com.fuentesedge20.empleoenper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        //FragmentManager fragmentManager=getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.contenedor,new PRINCIPAL()).addToBackStack(null).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new GalleryFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
         /*   Intent intent = new Intent().setClass(this, MainActivity.class);
            intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);*/
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

        FragmentManager fM=getSupportFragmentManager();

        if (id == R.id.Inicio) {

        } else if (id == R.id.Buscar) {

            fM.beginTransaction().replace(R.id.contenedor,new BUSCARFragment()).commit();

        } else if (id == R.id.Categorias) {

            fM.beginTransaction().replace(R.id.contenedor,new GalleryFragment()).commit();

        }else if (id == R.id.trabajosGuardasdos) {

            fM.beginTransaction().replace(R.id.contenedor,new GalleryFragment()).commit();

        }else if (id == R.id.recomendado) {

            fM.beginTransaction().replace(R.id.contenedor,new GalleryFragment()).commit();

        }else if (id == R.id.PublicarAviso) {

            fM.beginTransaction().replace(R.id.contenedor,new GalleryFragment()).commit();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
