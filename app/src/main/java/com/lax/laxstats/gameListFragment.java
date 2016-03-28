package com.lax.laxstats;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;


public class gameListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private gameManager pm = gameManager.getInstance();
    private List<game> pList = pm.getGames();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game_list, container, false);

        ArrayAdapter<game> adapter = new ArrayAdapter<game>(getActivity(), R.layout.fragment_game_list_item, pList);

        ListView listView = (ListView) v.findViewById(R.id.gameListView);
        if (listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
        return v;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Pass to the main activity
        ((MainActivity)getActivity()).onItemClick(position);
    }
}