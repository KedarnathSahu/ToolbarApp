package com.cumulations.toolbarapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();
    public static Spinner spinner;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //compatibility check
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            toolbar.setElevation(10.f);
        }

        initSpinner();
    }

    public void initSpinner() {
        spinner = findViewById(R.id.spinner_nav_sub);
        names.add(0, "Home");
        names.add(1, "Profile");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerText, names);
        spinner.setAdapter(adapter);
//        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Profile")) {
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "Nothing is Selected.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
