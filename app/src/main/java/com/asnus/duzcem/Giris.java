package com.asnus.duzcem;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Giris extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intocan = new Intent(Giris.this, Giris.class);
                startActivity(intocan);
            }
        });

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://anketcim.esy.es/duzcem.htm");
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Çıkmak istediğinize emin misiniz?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
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
            Intent intocan = new Intent(Giris.this, Tarih.class);
            startActivity(intocan);
        } else if (id == R.id.galeri) {
            Intent intocan = new Intent(Giris.this, Galeri.class);
            startActivity(intocan);
        } else if (id == R.id.haber) {
            Intent intocan = new Intent(Giris.this, Haber.class);
            startActivity(intocan);
        } else if (id == R.id.rehber) {
            Intent intocan = new Intent(Giris.this, Rehber.class);
            startActivity(intocan);
        } else if (id == R.id.ezcane) {
            Intent intocan = new Intent(Giris.this, Eczane.class);
            startActivity(intocan);
        } else if (id == R.id.otobus) {
            Intent intocan = new Intent(Giris.this, Otobus.class);
            startActivity(intocan);
        } else if (id == R.id.universite) {
            Intent intocan = new Intent(Giris.this, Universite.class);
            startActivity(intocan);
        } else if (id == R.id.akcakoca) {
            Intent intocan = new Intent(Giris.this, Akcakoca.class);
            startActivity(intocan);
        } else if (id == R.id.cumayeri) {
            Intent intocan = new Intent(Giris.this, Cumayeri.class);
            startActivity(intocan);
        } else if (id == R.id.cilimli) {
            Intent intocan = new Intent(Giris.this, Cilimli.class);
            startActivity(intocan);
        } else if (id == R.id.golyaka) {
            Intent intocan = new Intent(Giris.this, Golyaka.class);
            startActivity(intocan);
        } else if (id == R.id.gumusova) {
            Intent intocan = new Intent(Giris.this, Gumusova.class);
            startActivity(intocan);
        } else if (id == R.id.kaynasli) {
            Intent intocan = new Intent(Giris.this, Kaynasli.class);
            startActivity(intocan);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
