package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.whatsapp.Adaptadores.PagerController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerController pageAdapter;
    android.view.Menu menu;
    FloatingActionButton buttonBar;
    FloatingActionButton buttonBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tbMenuPrincipal);
        viewPager = findViewById(R.id.viewpager);
        buttonBar = (FloatingActionButton)findViewById(R.id.floating_action_button_Contactos);
        buttonBar2 = (FloatingActionButton)findViewById(R.id.floating_action_button2_EstadosLlamadas);
        buttonBar2.setVisibility(View.INVISIBLE);

        pageAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_toolbar , menu);
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

        switch (tab.getPosition()){
            case 0:
                buttonBar2.setVisibility(View.INVISIBLE);
                buttonBar.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_contactos));
                this.menu.clear();
                getMenuInflater().inflate(R.menu.menu_toolbar , this.menu);
                break;
            case 1:
                buttonBar2.setVisibility(View.VISIBLE);
                buttonBar2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_editarestado));
                buttonBar.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_camara));
                this.menu.clear();
                getMenuInflater().inflate(R.menu.menu_estados , this.menu);
                break;
            case 2:
                buttonBar2.setVisibility(View.VISIBLE);
                buttonBar2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_agregarvideollamada));
                buttonBar.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_agregarllamada));
                this.menu.clear();
                getMenuInflater().inflate(R.menu.menu_llamadas , this.menu);
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}