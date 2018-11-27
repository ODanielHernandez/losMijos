package com.losmijos;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class tab_1 extends Fragment implements View.OnClickListener, Serializable {

    private ListView listas;
    ImageView btnAdd;
    String value;
    ArrayList<entidad_mochila> listaArticulos;
    private adaptador_mochila adaptador;

    private OnFragmentInteractionListener mListener;

    public tab_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab_1, container, false);

        listas = v.findViewById(R.id.listaArticulos);

        btnAdd = v.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        //Integer idDesastre = fragment_holder.valorFragmento.myvalue;

        //Toast.makeText(getActivity(),String.valueOf(variable),Toast.LENGTH_SHORT).show();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        AdminBD baseDatos = new AdminBD(getContext());
        SQLiteDatabase baseD = baseDatos.getWritableDatabase();
        ArrayList<entidad_mochila> listItems = new ArrayList<>();
        Integer idDesastre = fragment_holder.valorFragmento.myvalue;
        String nomDesastre = "";
        switch (idDesastre){
            case 0:
                nomDesastre = "inundaciones";
                listItems.add(new entidad_mochila("Agua","1", false));
                listItems.add(new entidad_mochila("Comida en lata","1", false));
                listItems.add(new entidad_mochila("Lampara","2", false));
                listItems.add(new entidad_mochila("Ropa extra","3", false));
                break;
            case 1:
                nomDesastre = "terremotos";
                break;
            case 2:
                nomDesastre = "huracanes";
                break;
            case 3:
                nomDesastre = "tornados";
                break;
            case 4:
                nomDesastre = "tsunamis";
                break;
            case 5:
                nomDesastre = "temperaturasExtremas";
                break;
            case 6:
                nomDesastre = "sequias";
                break;
            case 7:
                nomDesastre = "erupcionVolcanica";
                break;
        }
        Cursor tabla = baseDatos.consultaTotal(baseD, nomDesastre);
        try {
            int numregistro = tabla.getCount();
            tabla.moveToFirst();
            for (int i = 0; i < numregistro; i++){
                listItems.add(new entidad_mochila(tabla.getString(1), tabla.getString(2),false));
                tabla.moveToNext();
            }
        }catch (Exception e){
        }

        adaptador = new adaptador_mochila(getActivity().getApplicationContext(), listItems);
        listas.setAdapter(adaptador);

        listaArticulos = new ArrayList<entidad_mochila>();
        adaptador.notifyDataSetChanged();

        //Toast.makeText(getActivity(), "Saludos desde onResume", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<entidad_mochila> getArrayListItems(){
        ArrayList<entidad_mochila> listItems = new ArrayList<>();
        listItems.add(new entidad_mochila("Agua","1", false));
        listItems.add(new entidad_mochila("Comida en lata","1", false));
        listItems.add(new entidad_mochila("Lampara","2", false));
        listItems.add(new entidad_mochila("Ropa extra","3", false));

        return listItems;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity().getApplicationContext(), agregarSuministro.class);
        i.putExtra("id", value);
        switch (v.getId()){
            case R.id.btnAdd:
                startActivity(i);
                break;
        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
