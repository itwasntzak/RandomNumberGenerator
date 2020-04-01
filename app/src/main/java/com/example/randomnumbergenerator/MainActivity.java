package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InterruptedIOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
//  todo: add buttons below and above random range EditText, incrament value +/- 1 each press

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rollRandom(View view) {
        Integer randomNumb = new Random().nextInt(randomRange()) + 1;
        TextView textView = (TextView) findViewById(R.id.randomResults);
        textView.setText(randomNumb.toString());
    }

    public int randomRange() {
        EditText rangeInput = (EditText) findViewById(R.id.rollRangeInput);
        Integer rollRange =  Integer.parseInt(rangeInput.getText().toString());
        return rollRange;
    }
}