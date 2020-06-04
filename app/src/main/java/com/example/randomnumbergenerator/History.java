package com.example.randomnumbergenerator;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class History extends AppCompatActivity{
    Date dateTime;
    int rangeOfRandom;
    int randomResult;

    public History(Date timeStamp, int range, int result) {
        setContentView(R.layout.history_container);

        dateTime = timeStamp;
        rangeOfRandom = range;
        randomResult = result;
    }

    public ConstraintLayout getHistoryView() {
//      NOTE: this doesnt work
        ConstraintLayout constraintLayout;
        LinearLayout historyLayout;
        TextView dateTimeView;
        TextView rangeView;
        TextView resultView;

        constraintLayout = findViewById(R.id.constraintLayout);
        historyLayout = findViewById(R.id.historyLayout);
        dateTimeView = findViewById(R.id.dateTime);
        rangeView = findViewById(R.id.rangeOfRandom);
        resultView = findViewById(R.id.randomResult);

        int pad  = 10;
        dateTimeView.setPadding(pad, pad, pad, pad);
        rangeView.setPadding(pad, pad, pad, pad);
        resultView.setPadding(pad, pad, pad, pad);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss");
        dateTimeView.setText(dateFormat.format(this.dateTime));
        rangeView.setText(Integer.toString(this.rangeOfRandom));
        resultView.setText(Integer.toString(this.randomResult));

        historyLayout.addView(dateTimeView);
        historyLayout.addView(rangeView);
        historyLayout.addView(resultView);

        return constraintLayout;
    }
}
