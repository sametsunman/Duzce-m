package com.asnus.duzcem;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Galeri extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //the images to display
    Integer[] imageIDs = {
            R.drawable.galeri1,
            R.drawable.galeri2,
            R.drawable.galeri3,
            R.drawable.galeri4,
            R.drawable.galeri6,
            R.drawable.galeri7,
            R.drawable.galeri8,
            R.drawable.galeri9,
            R.drawable.galeri10,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intocan = new Intent(Galeri.this, Giris.class);
                startActivity(intocan);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Note that Gallery view is deprecated in Android 4.1---
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position,long id)
            {
                Toast.makeText(getBaseContext(),"Resim" + (position + 1) + " seçildi",
                        Toast.LENGTH_SHORT).show();
                // display the images selected
                ImageView imageView = (ImageView) findViewById(R.id.image1);
                imageView.setImageResource(imageIDs[position]);
            }
        });
    }


    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
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
            Intent intocan = new Intent(Galeri.this, Tarih.class);
            startActivity(intocan);
        } else if (id == R.id.galeri) {
            Intent intocan = new Intent(Galeri.this, Galeri.class);
            startActivity(intocan);
        } else if (id == R.id.haber) {
            Intent intocan = new Intent(Galeri.this, Haber.class);
            startActivity(intocan);
        } else if (id == R.id.rehber) {
            Intent intocan = new Intent(Galeri.this, Rehber.class);
            startActivity(intocan);
        } else if (id == R.id.ezcane) {
            Intent intocan = new Intent(Galeri.this, Eczane.class);
            startActivity(intocan);
        } else if (id == R.id.otobus) {
            Intent intocan = new Intent(Galeri.this, Otobus.class);
            startActivity(intocan);
        } else if (id == R.id.universite) {
            Intent intocan = new Intent(Galeri.this, Universite.class);
            startActivity(intocan);
        } else if (id == R.id.akcakoca) {
            Intent intocan = new Intent(Galeri.this, Akcakoca.class);
            startActivity(intocan);
        } else if (id == R.id.galeri) {
            Intent intocan = new Intent(Galeri.this, Galeri.class);
            startActivity(intocan);
        } else if (id == R.id.cilimli) {
            Intent intocan = new Intent(Galeri.this, Cilimli.class);
            startActivity(intocan);
        } else if (id == R.id.golyaka) {
            Intent intocan = new Intent(Galeri.this, Golyaka.class);
            startActivity(intocan);
        } else if (id == R.id.gumusova) {
            Intent intocan = new Intent(Galeri.this, Gumusova.class);
            startActivity(intocan);
        } else if (id == R.id.kaynasli) {
            Intent intocan = new Intent(Galeri.this, Kaynasli.class);
            startActivity(intocan);
        } else if (id == R.id.yigilca) {
            Intent intocan = new Intent(Galeri.this, Yigilca.class);
            startActivity(intocan);

        }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}
}
