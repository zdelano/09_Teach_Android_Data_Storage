package com.example.zachary.a09_teach_android_data_storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int number = 0;
    TextView myView;
    DatabaseHelper myLilHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLilHelper = new DatabaseHelper(this);

        // set text to 0 when app starts
        myView = (TextView) findViewById(R.id.textView);
        SharedPreferences prefs = getSharedPreferences("Team Activity", MODE_PRIVATE);
        number = prefs.getInt("num", 0);
        myView.setText("" + number);
    }

    /**
     * Advance the text view!
     * @param v
     */
    public void advance(View v) {
        number++;
        myView.setText("" + number);
    }

    /**
     * Save the user's preferences!
     * @param v
     */
    public void save(View v) {
        SharedPreferences.Editor editor =
                getSharedPreferences("Team Activity", MODE_PRIVATE).edit();
        editor.putInt("num", number);
        editor.commit();
        myLilHelper.updateData("0" , number);
    }
}
