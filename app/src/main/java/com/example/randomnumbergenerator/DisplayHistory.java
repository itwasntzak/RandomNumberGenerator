package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DisplayHistory extends AppCompatActivity {
    ArrayList<ArrayList<Object>> historyList;
    LinearLayout historyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);

        historyList = MainActivity.loadHistory();
        historyLayout = findViewById(R.id.historyLayout);


        for (ArrayList<Object> list : historyList) {
            LinearLayout tempLayout = new LinearLayout(this);
            tempLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tempLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView recordedTime = new TextView(this);
            recordedTime.setTextSize(24);
            recordedTime.setTextColor(Color.parseColor("#FFFFFF"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy\nHH:mm:ss");
            String formattedTime = dateFormat.format(list.get(0));
            recordedTime.setPadding(32, 16, 32, 16);
            recordedTime.setText(formattedTime);

            TextView rangeOfRandom = new TextView(this);
            rangeOfRandom.setTextSize(24);
            rangeOfRandom.setTextColor(Color.parseColor("#FFFFFF"));
            rangeOfRandom.setPadding(32, 16, 32, 16);
            rangeOfRandom.setText(list.get(1).toString());

            TextView randomResult = new TextView(this);
            randomResult.setTextSize(24);
            randomResult.setTextColor(Color.parseColor("#FFFFFF"));
            randomResult.setPadding(32, 16, 16, 32);
            randomResult.setText(list.get(2).toString());

            tempLayout.addView(recordedTime);
            tempLayout.addView(rangeOfRandom);
            tempLayout.addView(randomResult);
            historyLayout.addView(tempLayout);
        }
    }
}