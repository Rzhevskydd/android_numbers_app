package com.example.numbersapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.numbersapp.R;

public class NumberFragment extends Fragment {
    private final static String NUMBER = "number";
    private final static String COLOR = "color";

    public NumberFragment() {
        super();
    }

    public static NumberFragment newInstance(NumberItem item) {
        NumberFragment fragment = new NumberFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NUMBER, item.number);
        bundle.putInt(COLOR, item.color);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_number_fragment, parent, false);
        TextView textView = view.findViewById(R.id.single_number);
        textView.setText(String.valueOf(getArguments().getInt(NUMBER)));
        textView.setTextColor(getArguments().getInt(COLOR));
        return view;
    }


}
