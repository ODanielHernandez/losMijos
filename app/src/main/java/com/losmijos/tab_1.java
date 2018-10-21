package com.losmijos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class tab_1 extends Fragment {

    private ListView listas;
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


        return v;
    }

    public ArrayList<entidad_mochila> getArrayListItems(){
        ArrayList<entidad_mochila> listItems = new ArrayList<>();
        listItems.add(new entidad_mochila("Agua","2", true));

        return listItems;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
