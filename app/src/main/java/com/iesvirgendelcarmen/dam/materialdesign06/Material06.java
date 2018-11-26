package com.iesvirgendelcarmen.dam.materialdesign06;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Material06 extends AppCompatActivity {


    Button btn_anadir, btn_quitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material06);

        final TabLayout tabLayout =findViewById(R.id.tabLayout);

        TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("TAB 01");
        primerTab.setIcon(R.mipmap.ic_launcher);
        tabLayout.addTab(primerTab);

        TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("TAB 02");
        segundoTab.setIcon(R.drawable.icono1);
        tabLayout.addTab(segundoTab);

        TabLayout.Tab tercerTab = tabLayout.newTab();
        tercerTab.setText("TAB 03");
        tercerTab.setIcon(R.drawable.icono2);
        tabLayout.addTab(tercerTab,1,true);

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabTextColors(Color.RED, Color.WHITE);
        tabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        tabLayout.setSelectedTabIndicatorHeight(12);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int elegida = tabLayout.getSelectedTabPosition();
                Toast.makeText(Material06.this, "HA TOCADO "+elegida, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btn_anadir = findViewById(R.id.anadir_tab);
        btn_quitar = findViewById(R.id.quitar_tab);

        btn_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabLayout.getTabCount() < 6){
                    TabLayout.Tab tab = tabLayout.newTab();
                    tab.setText("TAB");
                    tab.setIcon(R.mipmap.ic_launcher);
                    tabLayout.addTab(tab);
                } else {
                    Toast.makeText(Material06.this,"NO SE PUEDEN AÑADIR MÁS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_quitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabLayout.getTabCount() > 2){
                    tabLayout.removeTabAt(tabLayout.getTabCount() - 1);
                } else {
                    Toast.makeText(Material06.this,"NO SE PUEDEN QUITAR MÁS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
