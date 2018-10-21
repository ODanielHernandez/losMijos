package com.losmijos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class tab_1 extends Fragment implements View.OnClickListener {

    private ListView listas;
    ImageView btnAdd;
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

        listas = (ListView) v.findViewById(R.id.listaArticulos);
        adaptador = new adaptador_mochila(getActivity().getApplicationContext(), getArrayListItems());
        listas.setAdapter(adaptador);
        listaArticulos = new ArrayList<entidad_mochila>();

        btnAdd = v.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);


        return v;
    }


    /*public void onClick(View view) {
        Intent i = new Intent(getActivity().getApplicationContext(), agregarSuministro.class);
        switch (view.getId()){
            case R.id.btnAdd:
                startActivity(i);
                break;
        }
    }*/


    public ArrayList<entidad_mochila> getArrayListItems(){
        ArrayList<entidad_mochila> listItems = new ArrayList<>();
        listItems.add(new entidad_mochila("Agua","2", true));

        return listItems;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity().getApplicationContext(), agregarSuministro.class);
        //Integer idDesastre =listaDesastres.get(position).getId_desastre();
        //i.putExtra("id", idDesastre);
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
