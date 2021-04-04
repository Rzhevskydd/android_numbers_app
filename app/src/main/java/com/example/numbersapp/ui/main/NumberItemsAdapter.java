package com.example.numbersapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.numbersapp.R;

import java.util.List;


public class NumberItemsAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    private final List<NumberItem> mNumbersItemsList;
    private final INumberClicker mListener;

    NumberItemsAdapter(List<NumberItem> _mNumbersItemsList, INumberClicker listener) {
        this.mNumbersItemsList = _mNumbersItemsList;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.numbers_table_item, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        final NumberItem numberItem = mNumbersItemsList.get(position);
        holder.bind(numberItem, mListener);
    }

    @Override
    public int getItemCount() { return mNumbersItemsList.size(); }

    public interface INumberClicker {
        void onNumberClicked(NumberItem item);
    }
}
