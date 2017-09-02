package com.yiran.hanfuquan.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.yiran.hanfuquan.R;
import com.yiran.hanfuquan.view.fragment.HomeFragment;


import java.util.HashMap;

import nucleus.view.NucleusActivity;


public class MainActivity extends NucleusActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int STANDARD_ZONG = 2;
    private static final int STANDARD_HAN = 1;
    private static final int STANDARD_MING = 0;
    private static final int STANDARD_SONG = 3;
    private static final int STANDARD_TANG = 4;
    private HashMap<Integer, Integer> bmbButtonImages;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("汉服圈");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_aty_content,
                        Fragment.instantiate(this, HomeFragment.class.getName()))
                .commit();

        bmbInit();

    }

    public Toolbar getToolbar(){
        return this.toolbar;
    }

    private void bmbInit(){
        final ImageView ivBMBMenu;
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb_standard);
        ivBMBMenu = (ImageView) findViewById(R.id.bmb_standard_img);
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_3);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_4);
        bmbButtonImages = new HashMap<Integer, Integer>();
        bmbButtonImages.put(STANDARD_HAN, R.drawable.c_han);
        bmbButtonImages.put(STANDARD_MING, R.drawable.c_ming);
        bmbButtonImages.put(STANDARD_ZONG, R.drawable.c_zong);
        bmbButtonImages.put(STANDARD_SONG, R.drawable.c_song);
        bmbButtonImages.put(STANDARD_TANG, R.drawable.c_tang);
        for(int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++){
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder();
            builder.normalImageRes(bmbButtonImages.get(i));
            builder.listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    ivBMBMenu.setImageResource(bmbButtonImages.get(index));
                }
            });
            bmb.addBuilder(builder);
        }
    }

}
