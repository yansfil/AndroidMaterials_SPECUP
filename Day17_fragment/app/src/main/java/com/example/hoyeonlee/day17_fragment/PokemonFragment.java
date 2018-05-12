package com.example.hoyeonlee.day17_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by hoyeonlee on 2018. 3. 27..
 */

public class PokemonFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon,container,false);
        ListView listview = view.findViewById(R.id.listview);
        String[] pokemons = {"피카츄","라이츄","꼬부기","야도란"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,pokemons);
        listview.setAdapter(adapter);
        return view;
    }
}
