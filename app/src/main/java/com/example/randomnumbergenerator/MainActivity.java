package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void rangeOfRandom() {
//        EditText rangeInput = findViewById(R.id.rollRangeInput);
//        int randomRange = 2;
//        rollTotal.setText(randomRange);
//        rollTotal.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                ;
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String text = rangeInput.getText().toString();
//                randomRange = Integer.parseInt(text);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//         rangeNumber;
//    }

    public void rollRandom(View view) {
//      todo: figure out how to get an integer from a number EditText, then use a parameter for random range
        EditText rangeInput = findViewById(R.id.rollRangeInput);
        Integer rollRange =  Integer.parseInt(rangeInput.getText().toString());
        Integer randomNumb = new Random().nextInt(rollRange) + 1;
        TextView textView = findViewById(R.id.textView);
        textView.setText(randomNumb.toString());
    }
}
