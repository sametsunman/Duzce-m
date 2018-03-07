package com.asnus.duzcem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Gumusova extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gumusova);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intocan = new Intent(Gumusova.this, Giris.class);
                startActivity(intocan);
            }
        });


        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://tr.m.wikipedia.org/wiki/Gümüşova");
        webview.getSettings().setUserAgentString("Mozilla/5.0 (Android; Mobile; rv:26.0) Gecko/26.0 Firefox/26.0");

        final ProgressDialog progress = ProgressDialog.show(this, "Düzce'm", "Yükleniyor....", true);
        progress.show();
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.dismiss();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.giris, menu);
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
            Toast.makeText(getApplicationContext(), "Bu uygulama Samet Sunman tarafından yapılmıştır.", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.tarih) {
            Intent intocan = new Intent(Gumusova.this, Tarih.class);
            startActivity(intocan);
        } else if (id == R.id.galeri) {
            Intent intocan = new Intent(Gumusova.this, Galeri.class);
            startActivity(intocan);
        } else if (id == R.id.haber) {
            Intent intocan = new Intent(Gumusova.this, Haber.class);
            startActivity(intocan);
        } else if (id == R.id.rehber) {
            Intent intocan = new Intent(Gumusova.this, Rehber.class);
            startActivity(intocan);
        } else if (id == R.id.ezcane) {
            Intent intocan = new Intent(Gumusova.this, Eczane.class);
            startActivity(intocan);
        } else if (id == R.id.otobus) {
            Intent intocan = new Intent(Gumusova.this, Otobus.class);
            startActivity(intocan);
        } else if (id == R.id.universite) {
            Intent intocan = new Intent(Gumusova.this, Universite.class);
            startActivity(intocan);
        } else if (id == R.id.akcakoca) {
            Intent intocan = new Intent(Gumusova.this, Akcakoca.class);
            startActivity(intocan);
        } else if (id == R.id.cumayeri) {
            Intent intocan = new Intent(Gumusova.this, Cumayeri.class);
            startActivity(intocan);
        } else if (id == R.id.cilimli) {
            Intent intocan = new Intent(Gumusova.this, Cilimli.class);
            startActivity(intocan);
        } else if (id == R.id.golyaka) {
            Intent intocan = new Intent(Gumusova.this, Golyaka.class);
            startActivity(intocan);
        } else if (id == R.id.gumusova) {
            Intent intocan = new Intent(Gumusova.this, Gumusova.class);
            startActivity(intocan);
        } else if (id == R.id.kaynasli) {
            Intent intocan = new Intent(Gumusova.this, Kaynasli.class);
            startActivity(intocan);
        } else if (id == R.id.yigilca) {
            Intent intocan = new Intent(Gumusova.this, Yigilca.class);
            startActivity(intocan);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
