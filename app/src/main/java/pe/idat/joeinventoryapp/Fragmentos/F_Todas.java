package pe.idat.joeinventoryapp.Fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pe.idat.joeinventoryapp.OpcionesProducto.Agregar_Producto;
import pe.idat.joeinventoryapp.R;


public class F_Todas extends Fragment {

    FloatingActionButton FAB_AgregarProducto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f__todas, container, false);
        FAB_AgregarProducto=view.findViewById(R.id.FAB_AgregarProducto);
        FAB_AgregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Agregar_Producto.class));
            }
        });

        return view;
    }
}