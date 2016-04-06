package com.lax.laxstats;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class gameListFragment extends Fragment implements AdapterView.OnItemClickListener {
    public static gameManager pm;
    public static List<game> pList;
    public static ArrayAdapter<game> adapter;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        pm = gameManager.getInstance();
        pList = pm.getGames();
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_game_list, container, false);

        adapter = new ArrayAdapter<game>(getActivity(), R.layout.fragment_game_list_item, pList);

        ListView listView = (ListView) v.findViewById(R.id.gameListView);
        if (listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
        return v;

    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Pass to the main activity
        ((MainActivity) getActivity()).onItemClick(position);
    }

}