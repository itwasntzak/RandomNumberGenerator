package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
//        final EditText rollTotal = findViewById(R.id.rollTotal);
//        int randomRange = 2;
//        rollTotal.setText(randomRange);
////        Integer rollQuantity = rollTotal.getText();
//        rollTotal.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                ;
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String text = rollTotal.getText().toString();
//                return Integer.parseInt(text);
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
        EditText rollTotal = findViewById(R.id.rollTotal);
        Integer rollRange =  Integer.parseInt(rollTotal.getText().toString());
        Integer randomNumb = new Random().nextInt(rollRange) + 1;
        TextView textView = findViewById(R.id.textView);
        textView.setText(randomNumb.toString());
    }
}
