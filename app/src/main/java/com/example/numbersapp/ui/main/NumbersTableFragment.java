package com.example.numbersapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.numbersapp.R;

public class NumbersTableFragment extends Fragment implements View.OnClickListener {
    private static final String ELEMENTS_NUM = "ELEMENTS_NUM";
    private NumbersViewModel mViewModel;

    private NumberItemsAdapter mAdapter;

    public NumbersTableFragment() {
        super();
    }
    public static NumbersTableFragment newInstance() {
        return new NumbersTableFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mViewModel.red = getResources().getColor(R.color.red);
        mViewModel.blue = getResources().getColor(R.color.blue);

        View view = inflater.inflate(R.layout.numbers_table_fragment, parent, false);
        RecyclerView recyclerViewNumbers = view.findViewById(R.id.recycle_view_numbers);

        NumberItemsAdapter.INumberClicker listener = (NumberItemsAdapter.INumberClicker) getActivity();
        mAdapter = new NumberItemsAdapter(mViewModel.getNumbersList(), listener);

        recyclerViewNumbers.setAdapter(mAdapter);
        recyclerViewNumbers.setLayoutManager(new GridLayoutManager(getContext(),
                getResources().getInteger(R.integer.columns_num)));

        view.findViewById(R.id.add_button).setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = new NumbersViewModel();
        mViewModel.red = getResources().getColor(R.color.red);
        mViewModel.blue = getResources().getColor(R.color.blue);

        super.onCreate(savedInstanceState);
        int elementsNum = getResources().getInteger(R.integer.numbers_num);
        if (savedInstanceState != null) {
            elementsNum = savedInstanceState.getInt(ELEMENTS_NUM, elementsNum);
        }

        mViewModel.fillNumbers(elementsNum);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle state) {
        state.putInt(ELEMENTS_NUM, mViewModel.getNumsCount());
        super.onSaveInstanceState(state);
    }


    @Override
    public void onClick(View view) {
        mViewModel.addItemSequentially();
        mAdapter.notifyItemInserted(mViewModel.getNumsCount() - 1);
    }

}