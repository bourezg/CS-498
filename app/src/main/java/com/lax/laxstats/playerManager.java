package com.lax.laxstats;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by laurenmarshall on 4/4/16.
 */
public class playerManager extends Activity implements OnItemSelectedListener{
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_information);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.positions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
