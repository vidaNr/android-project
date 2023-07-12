package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FavoritesActivity extends Activity {

    Spinner spn;
    String country[];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Button btnNext = findViewById(R.id.btn_next);

        listOfCountries();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FavoritesActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void listOfCountries() {

        spn = (Spinner) findViewById(R.id.spn_country);
        ArrayAdapter<CharSequence> adapterItems = ArrayAdapter.createFromResource(this, R.array.countries, R.layout.item_country);
        adapterItems.setDropDownViewResource(R.layout.item_country);
        spn.setAdapter(adapterItems);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}