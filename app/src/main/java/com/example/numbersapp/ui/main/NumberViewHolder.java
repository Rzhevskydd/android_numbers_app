package com.example.numbersapp.ui.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.numbersapp.R;

class NumberViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleView;

    public NumberViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.number_item);
    }

    public void bind(NumberItem numItem, NumberItemsAdapter.INumberClicker listener) {
        String mText = Integer.toString(numItem.number);
        titleView.setText(mText);
        titleView.setTextColor(numItem.color);

        titleView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onNumberClicked(numItem);
            }
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                if (activity.getSupportFragmentManager().findFragmentById(R.id.table_container) == null) {
//                    activity.getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.container, LargeNumFragment.newInstance(mText, mColor))
//                            .addToBackStack(null)
//                            .commit();
//                }
            }
        );
    }

}
