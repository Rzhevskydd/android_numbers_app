package com.example.numbersapp.ui.main;

import androidx.lifecycle.ViewModel;

import com.example.numbersapp.R;

import java.util.ArrayList;
import java.util.List;

public class NumbersViewModel extends ViewModel {
    private final List<NumberItem> mNumbersArr = new ArrayList<>();
    public int red;
    public int blue;

    public NumbersViewModel() {
        super();
    }


    public void fillNumbers(int num) {
        for (int i = 0; i < num; ++i) {
            this.addItemSequentially();
        }
    }

    public int getNumsCount() {
        return mNumbersArr.size();
    }

    public void addItemSequentially() {
        NumberItem number = createItemToAdd();
        mNumbersArr.add(number);
    }

    private NumberItem createItemToAdd() {
        int index = mNumbersArr.size() + 1;
        return new NumberItem(index, index % 2 == 0 ? red : blue);
    }


    public List<NumberItem> getNumbersList() { return mNumbersArr; }
}