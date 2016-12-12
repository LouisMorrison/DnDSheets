package com.example.the_c.ddcharacterapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import java.util.ListIterator;
import static java.lang.String.valueOf;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    //widgets n things
    //Buttons
    Button mainButt, diceButt, spellButt, nextButt, prevButt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_main, container, false);

        //initialize TextViews and Buttons
        mainButt = (Button) mainView.findViewById(R.id.mainButt);
        diceButt = (Button) mainView.findViewById(R.id.diceButt);
        spellButt = (Button) mainView.findViewById(R.id.spellButt);
        prevButt = (Button) mainView.findViewById(R.id.prevButt);
        nextButt = (Button) mainView.findViewById(R.id.nextButt);

        //fragment switching buttons for main sheet, dice, and spells
        mainButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragmentExchange(v);
            }
        });

        diceButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragmentExchange(v);
            }
        });

        spellButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragmentExchange(v);
            }
        });

        //on click listeners for Next and Prev character buttons
        prevButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).charSwitch(v);
            }
        });

        nextButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).charSwitch(v);
            }
        });

        return mainView;
    }
}
