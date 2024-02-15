package com.college.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import com.college.converter.R;
import com.college.converter.databinding.ActivityMainBinding;

/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    static private final Float CONVERSION_RATE = 0.80F;
    static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Enter onCreate()");

        //implement binding
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());

//        setContentView(R.layout.activity_main);
        setContentView(variableBinding.getRoot());
        Button buttonConvert = variableBinding.convertButton;

        buttonConvert.setOnClickListener( view ->  {
            Log.d(TAG, "Clicked btn");

            convertCurrency(view);
        } );

        Log.d(TAG, "Exit onCreate()");
    }

    public void convertCurrency(View view) {
        // Entry point log message
        Log.d("convertCurrency", "Enter convertCurrency()"); 

        EditText inputView = variableBinding.entryId;

        String inputAmount = inputView.getText().toString();

        TextView resultView = variableBinding.resultId;

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);
            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            resultView.setText( resultFloat + getString(R.string.euros_message) );
        }
        // Exit point log message
        Log.d("convertCurrency", "Exit convertCurrency()"); 
    }
}
