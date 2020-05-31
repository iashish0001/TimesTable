package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generatetimesTable(int tableNumber){
        ArrayList<String> tableContent = new ArrayList<String>();
        for( int j = 1; j <= 10; j++ ){
            tableContent.add(Integer.toString(j * tableNumber));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tableContent);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

        int max = 20;
        int startingPosition = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);

        generatetimesTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tableNumber;

                if(i < min){
                    tableNumber = min;
                    seekBar.setProgress(min);
                }else{
                    tableNumber = i;
                }
                Log.i("Seek Bar value", Integer.toString(tableNumber));
                generatetimesTable(tableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
