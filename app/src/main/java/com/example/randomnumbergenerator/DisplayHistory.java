package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DisplayHistory extends AppCompatActivity {
    ArrayList<Object[]> historyList;
    LinearLayout recordedTimeColumn;
    LinearLayout rollRangeColumn;
    LinearLayout randomResultColumn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);

        historyList = MainActivity.loadHistory();
        recordedTimeColumn = findViewById(R.id.recordedTimeColumn);
        rollRangeColumn = findViewById(R.id.rollRangeColumn);
        randomResultColumn = findViewById(R.id.randomResultColumn);

        for (Object[] item : historyList) {
            TextView recordedTime = new TextView(this);
            recordedTime.setTextSize(24);
            recordedTime.setTextColor(Color.parseColor("#FFFFFF"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss", Locale.ENGLISH);
            String formattedTime = dateFormat.format(item[0]);
            recordedTime.setText(formattedTime);
            recordedTimeColumn.addView(recordedTime);

            TextView rangeOfRandom = new TextView(this);
            rangeOfRandom.setTextSize(24);
            rangeOfRandom.setTextColor(Color.parseColor("#FFFFFF"));
            rangeOfRandom.setText(item[1].toString());
            rollRangeColumn.addView(rangeOfRandom);

            TextView randomResults = new TextView(this);
            randomResults.setTextSize(24);
            randomResults.setTextColor(Color.parseColor("#FFFFFF"));
            randomResults.setText(item[2].toString());
            randomResultColumn.addView(randomResults);
        }
//        TextView comma = new TextView(this);
//        comma.setTextSize(36);
//        comma.setTextColor(Color.parseColor("#FFFFFF"));
//        comma.setText(", ");
//        commaColumn.addView(comma);
    }
}
