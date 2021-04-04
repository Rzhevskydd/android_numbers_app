package com.example.numbersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.numbersapp.ui.main.NumberFragment;
import com.example.numbersapp.ui.main.NumberItem;
import com.example.numbersapp.ui.main.NumberItemsAdapter;
import com.example.numbersapp.ui.main.NumbersTableFragment;

public class MainActivity extends AppCompatActivity implements NumberItemsAdapter.INumberClicker {
    private final static String STATE = "isNumbersAppActivated";
    private boolean isNumbersAppActivated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState != null) {
            isNumbersAppActivated = savedInstanceState.getBoolean(STATE, false);
        }

        if (!isNumbersAppActivated) {
            if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, NumbersTableFragment.newInstance())
                        .commit();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putBoolean(STATE, isNumbersAppActivated);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isNumbersAppActivated = false;
    }

    @Override
    public void onNumberClicked(NumberItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, NumberFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
        isNumbersAppActivated = true;
    }
}