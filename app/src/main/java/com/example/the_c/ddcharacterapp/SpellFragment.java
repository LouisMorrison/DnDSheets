package com.example.the_c.ddcharacterapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.DropBoxManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class SpellFragment extends Fragment {

    public SpellFragment() {
    }

    //widgets
    Character character;
    //TextViews
    TextView clear, saveDC, atkBonus, castStat;
    //EditTexts
    EditText prepared, cantrips, lv1sp, lv2sp, lv3sp, lv4sp, lv5sp, lv6sp, lv7sp, lv8sp, lv9sp;
    //shared preferences
    SharedPreferences sharedPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_spells, container, false);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        //initialize widgets
        //TextViews
        clear = (TextView) myView.findViewById(R.id.clearLabelTV);
        saveDC = (TextView) myView.findViewById(R.id.saveDC);
        atkBonus = (TextView) myView.findViewById(R.id.attackBonus);
        castStat = (TextView) myView.findViewById(R.id.castingStat);

        //EditTexts
        prepared = (EditText) myView.findViewById(R.id.prepared);
        cantrips = (EditText) myView.findViewById(R.id.cantrips);
        lv1sp = (EditText) myView.findViewById(R.id.firstlvlSpells);
        lv2sp = (EditText) myView.findViewById(R.id.secondlvlSpells);
        lv3sp = (EditText) myView.findViewById(R.id.thirdlvlSpells);
        lv4sp = (EditText) myView.findViewById(R.id.fourthlvlSpells);
        lv5sp = (EditText) myView.findViewById(R.id.fifthlvlSpells);
        lv6sp = (EditText) myView.findViewById(R.id.sixthlvlSpells);
        lv7sp = (EditText) myView.findViewById(R.id.seventhlvlSpells);
        lv8sp = (EditText) myView.findViewById(R.id.eighthlvlSpells);
        lv9sp = (EditText) myView.findViewById(R.id.ninthlvlSpells);

        //load current character info from MainActivity into TextViews
        update();

        //when user enters prepared spell
        prepared.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getString(R.string.prepared_key), prepared.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //when user presses Clear
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepared.setText("");
            }
        });

        return myView;
    }

    public void update() {
        //load current character from  MainActivity
        character = MainActivity.character;

        //load spell info
        saveDC.setText(valueOf(character.getCharSpSaveDC()));
        atkBonus.setText(valueOf(character.getCharSpAtk()));
        castStat.setText(character.getCharCastStat());
        prepared.setText(sharedPref.getString(getString(R.string.prepared_key), null));
        cantrips.setText(character.getCharCantrips());
        lv1sp.setText(character.getCharSpLv1());
        lv2sp.setText(character.getCharSpLv2());
        lv3sp.setText(character.getCharSpLv3());
        lv4sp.setText(character.getCharSpLv4());
        lv5sp.setText(character.getCharSpLv5());
        lv6sp.setText(character.getCharSpLv6());
        lv7sp.setText(character.getCharSpLv7());
        lv8sp.setText(character.getCharSpLv8());
        lv9sp.setText(character.getCharSpLv9());
    }
}