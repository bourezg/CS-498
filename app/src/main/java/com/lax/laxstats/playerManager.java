package com.lax.laxstats;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class playerManager extends Activity implements OnItemSelectedListener{
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_information);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.positions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        EditText tv = (EditText) findViewById(R.id.editPlayerName);
        tv.setText(MainActivity.playerName);
        EditText et = (EditText) findViewById(R.id.editPlayerNumber);
        et.setText(MainActivity.playerNumber);
        displayNumber();
        displayName();
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void displayName()
    {
            EditText tv = (EditText) findViewById(R.id.editPlayerName);
            tv.setOnEditorActionListener(new EditText.OnEditorActionListener(){
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
                {
                    boolean handled = false;
                    if(i == EditorInfo.IME_ACTION_DONE)
                    {
                        String inputText = textView.getText().toString();
                        MainActivity.playerName = inputText;

                        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                        handled = true;
                    }
                    return handled;
                }
            });
    }
    private void displayNumber()
    {
        EditText tv = (EditText) findViewById(R.id.editPlayerNumber);
        tv.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
            {
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_DONE)
                {
                    String inputText = textView.getText().toString();
                    MainActivity.playerNumber = inputText;

                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                    handled = true;
                }
                return handled;
            }
        });
    }
}
