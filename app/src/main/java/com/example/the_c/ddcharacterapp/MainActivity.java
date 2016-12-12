//MainActivity of D&D Character Sheet App
//Louis Morrison, Stephen Dupre
//CSC 4800, Fall 2016, SPU
package com.example.the_c.ddcharacterapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;
import java.util.ListIterator;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    //fragments
    SheetFragment sheetFrag;
    DiceFragment diceFrag;
    SpellFragment spellFrag;
    //widgets
    //Buttons
    Button nextButt, prevButt, mainButt, diceButt, spellButt;
    //TextViews
    TextView charName, charLvl, charClass, charBG, charRace, charAlign, charXP, rollValue;
    //Character list stuff
    public static Character character;
    List<Character> charList;
    ListIterator<Character> charListIterator;
    //other
    int shownFrag; //for tracking which fragment is show, 0=dice, 1=sheet, 2=spells
    boolean nextCalled = false, prevCalled = false;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DBHandler(this);

        //initialize character list
        charList = new CircularList<>();

        //retrieve character list from DB
        charList = db.getAllChars();

        //load first character and initialize iterator
        character = charList.get(0);
        charListIterator = charList.listIterator(1);

        //this is down here so that character gets set before the fragments are created
        setContentView(R.layout.activity_main);

        //initialize fragments
        sheetFrag = new SheetFragment();
        diceFrag = new DiceFragment();
        spellFrag = new SpellFragment();

        //load main fragment and sheet fragment into both frame layouts at start
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, sheetFrag)
                .commit();
        shownFrag = 1;

        //initialize widgets
        charName = (TextView) findViewById(R.id.cName);
        charLvl = (TextView) findViewById(R.id.cLevel);
        charClass = (TextView) findViewById(R.id.cClass);
        charBG = (TextView) findViewById(R.id.cBackground);
        charRace = (TextView) findViewById(R.id.cRace);
        charAlign = (TextView) findViewById(R.id.cAlignment);
        charXP = (TextView) findViewById(R.id.cExp);
        rollValue = (TextView) findViewById(R.id.rollLabel);
        prevButt = (Button) findViewById(R.id.prevButt);
        nextButt = (Button) findViewById(R.id.nextButt);
        mainButt = (Button) findViewById(R.id.mainButt);
        diceButt = (Button) findViewById(R.id.diceButt);
        spellButt = (Button) findViewById(R.id.spellButt);

        //load character info into TextViews
        update();

        //grey out buttons if necessary
        if (!charListIterator.hasPrevious()) {
            prevButt.setEnabled(false);
        }
        else
            prevButt.setEnabled(true);
        if (!charListIterator.hasNext()) {
            nextButt.setEnabled(false);
        }
        else
            nextButt.setEnabled(true);

        //EditText watchers to save changed data to character
        charName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharName(charName.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        charLvl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharLvl(Integer.parseInt(charLvl.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        charClass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharClass(charClass.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        charBG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharBG(charBG.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        charRace.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharRace(charRace.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        charAlign.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharAlign(charAlign.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        charXP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharXP(Integer.parseInt(charXP.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void rollUpdater(String x) {
        rollValue.setText(x);
    }

    public void fragmentExchange(View view) {
        //don't do anything if selected fragment is already showing
        if (view == diceButt && shownFrag != 0) {
            //should never be null but Justin Case...
            if (diceFrag == null)
                diceFrag = new DiceFragment();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, diceFrag)
                    .commit();

            shownFrag = 0;
        }
        else if (view == mainButt && shownFrag != 1) {
            if (sheetFrag == null)
                sheetFrag = new SheetFragment();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, sheetFrag)
                    .commit();

            shownFrag = 1;
        }
        else if (view == spellButt && shownFrag != 2) {
            if (spellFrag == null)
                spellFrag = new SpellFragment();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, spellFrag)
                    .commit();

            shownFrag = 2;
        }
    }

    public void charSwitch(View view) {
        db.updateChar(character);

        if (view == prevButt) {
            //check that keeps Iterator from returning same value on back and forth
            // prev and next calls
            if (nextCalled) {
                charListIterator.previous();
                nextCalled = false;
            }
            prevCalled = true;
            character = charListIterator.previous();
        }
        else if (view == nextButt) {
            nextCalled = true;
            if (prevCalled) {
                prevCalled = false;
                charListIterator.next();
            }
            character = charListIterator.next();
        }

        //update currently displayed lower fragment
        if (shownFrag == 1) {
            sheetFrag.update();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, sheetFrag)
                    .commit();
        }
        else if (shownFrag == 2) {
            spellFrag.update();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, spellFrag)
                    .commit();
        }

        //update info
        update();

        //grey out buttons if necessary
        if (!charListIterator.hasPrevious()) {
            prevButt.setEnabled(false);
        }
        else
            prevButt.setEnabled(true);
        if (!charListIterator.hasNext()) {
            nextButt.setEnabled(false);
        }
        else
            nextButt.setEnabled(true);
    }

    public void update() {
        //load character basics
        charName.setText(character.getCharName());
        charLvl.setText(valueOf(character.getCharLvl()));
        charClass.setText(character.getCharClass());
        charBG.setText(character.getCharBG());
        charRace.setText(character.getCharRace());
        charAlign.setText(character.getCharAlign());
        charXP.setText(valueOf(character.getCharXP()));
    }

    @Override
    protected void onPause() {super.onPause(); db.updateChar(character);}

}
