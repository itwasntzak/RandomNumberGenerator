package com.example.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
//  todo: add buttons below and above random range EditText, increment value +/- 1 each press
//  todo: learn how to write and read file data, write teh results of rollRange & randomNumb. read them in and display on a new activity as a history

    private static final String HISTORY_FILE = "history.txt";
    public static final String HISTORY_ARRAY = "com.example.randomnumbergenerator.HISTORY";
    public static SimpleDateFormat pyTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    static File historyFile;
    TextView resultsTextView;
    EditText rangeInput;
    Integer randomResults;
    Integer rangeOfRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultsTextView = findViewById(R.id.randomResults);
        rangeInput = findViewById(R.id.rollRangeInput);
        historyFile  = new File(this.getFilesDir(), HISTORY_FILE);
    }

    public void rollRandom(View view) {
    //  todo: add a binary setting for randomly generating between 0 & 1
        rangeOfRandom = rangeOfRandom();
        randomResults = new Random().nextInt(rangeOfRandom) + 1;
        saveHistory(rangeOfRandom, randomResults);
        resultsTextView.setText(randomResults.toString());
    }

    public int rangeOfRandom() {
    //  todo: see if its possible to set a minimum value for range input
        return Integer.parseInt(rangeInput.getText().toString());
    }

    public void saveHistory(int rangeOfRandom, int randomResults) {
        Date dateTime = new Date();
//        String pyTimeFormat = String.format("%d-%02d-%02d %02d:%02d:%02d.%03d",
//                dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH) + 1, dateTime.get(Calendar.DAY_OF_MONTH),
//                dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE),
//                dateTime.get(Calendar.SECOND),dateTime.get(Calendar.MILLISECOND));
        String text = String.format("%s,%s,%s\n", pyTimeFormat.format(dateTime), rangeOfRandom, randomResults);
        try {
            FileWriter historyWriter;
            if (historyFile.exists()) {
                historyWriter = new FileWriter(historyFile, true);
                BufferedWriter writer = new BufferedWriter(historyWriter);
                writer.write(text);
                writer.close();
            } else {
                historyWriter = new FileWriter(historyFile);
                historyWriter.write(text);
            }
            historyWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Object>> loadHistory() {
        try {
            List<String> newLineList = new ArrayList<>();
            Scanner readFile = new Scanner(historyFile);
            while (readFile.hasNextLine()) {
                newLineList.add(readFile.nextLine());
            }
            readFile.close();
            ArrayList<ArrayList<Object>> historyList = new ArrayList<>();
            for (String line : newLineList) {
                String[] tempList = line.split(",");
                Date dateTime = pyTimeFormat.parse(tempList[0]);
                int rangeOfRandom = Integer.parseInt(tempList[1]);
                int randomResult = Integer.parseInt(tempList[2]);
                ArrayList<Object> history = new ArrayList<>();
                history.add(dateTime);
                history.add(rangeOfRandom);
                history.add(randomResult);
                historyList.add(history);
            }
            return historyList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clearHistory(View view) {
        if (historyFile.exists()) {
            historyFile.delete();
        } else {
            Toast.makeText(
                    this, "No history to clear.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void viewHistory(View view) {
        if (historyFile.exists()) {
            Intent intent = new Intent(this, DisplayHistory.class);
            startActivity(intent);
        } else {
            Toast.makeText(
                    this, "No history currently recorded.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}