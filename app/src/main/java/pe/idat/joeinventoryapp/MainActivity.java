package pe.idat.joeinventoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import pe.idat.joeinventoryapp.Fragmentos.F_Ajustes;
import pe.idat.joeinventoryapp.Fragmentos.F_Todas;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    boolean DobleToqueParaSalir = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*Fragmento al ejectuar la aplicación*/
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new F_Todas()).commit();
            navigationView.setCheckedItem(R.id.Opcion_Todas);
        }

    }

    /*Aqui controlamos nuestros fragmentos*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        /*Añadiendo condiciones las cuales nos permita visualizar el fragmento elegido*/
        if (id == R.id.Opcion_Todas){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new F_Todas()).commit();
        }
        if (id == R.id.Opcion_Ajustes){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new F_Ajustes()).commit();
        }
        if (id == R.id.Opcion_Salir){
            Toast.makeText(this, "Cerraste sesion", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (DobleToqueParaSalir){
            super.onBackPressed();
            Toast.makeText(this, "Saliste de la aplicación", Toast.LENGTH_SHORT).show();
            return;
        }

        /*Al presionar una vez en el boton de retroceso*/
        this.DobleToqueParaSalir = true;
        Toast.makeText(this, "Presione dos veces para salir", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                DobleToqueParaSalir = false;
            }
        }, 2000);
        super.onBackPressed();
    }
}