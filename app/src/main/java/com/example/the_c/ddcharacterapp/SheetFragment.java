package com.example.the_c.ddcharacterapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class SheetFragment extends Fragment {

    public SheetFragment() {
    }

    //widgets n things
    Character character;
    //TextViews
    TextView str, dex, con, intel, wis, cha, acrobatics, animalHandling, arcana,
             athletics, deception, history, insight, intimidation, investigation,
             medicine, nature, perception, performance, persuasion, religion, sleight,
             stealth, survival;
    //EditTexts
    EditText strVal, dexVal, conVal, intVal, wisVal, chaVal, ac, profBonus, init, spd, hpCurr, hpMax,
             equip, feats;
    //CheckBoxes
    CheckBox strBox, dexBox, conBox, intBox, wisBox, chaBox, acrobaticsBox,
             animalHandlingBox, arcanaBox, athleticsBox, deceptionBox, historyBox,
             insightBox, intimidationBox, investigationBox, medicineBox, natureBox,
             perceptionBox, performanceBox, persuasionBox, religionBox, sleightBox,
             stealthBox, survivalBox;
    //coin flip animation
    private Animation coinFlip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sheet, container, false);

        coinFlip = AnimationUtils.loadAnimation(getActivity(), R.anim.coinflip);
        coinFlip.setDuration(1000);

        //Clickable Views
        str = (TextView)view.findViewById(R.id.strLabel);
        dex = (TextView)view.findViewById(R.id.dexLabel);
        con = (TextView)view.findViewById(R.id.conLabel);
        intel = (TextView)view.findViewById(R.id.intLabel);
        wis = (TextView)view.findViewById(R.id.wisLabel);
        cha = (TextView)view.findViewById(R.id.chaLabel);
        acrobatics = (TextView)view.findViewById(R.id.acrobaticsLabel);
        animalHandling = (TextView)view.findViewById(R.id.animalHandlingLabel);
        arcana = (TextView)view.findViewById(R.id.arcanaLabel);
        athletics = (TextView)view.findViewById(R.id.athleticsLabel);
        deception = (TextView)view.findViewById(R.id.deceptionLabel);
        history = (TextView)view.findViewById(R.id.historyLabel);
        insight = (TextView)view.findViewById(R.id.insightLabel);
        intimidation = (TextView)view.findViewById(R.id.intimidationLabel);
        investigation = (TextView)view.findViewById(R.id.investigationLabel);
        medicine = (TextView)view.findViewById(R.id.medicineLabel);
        nature = (TextView)view.findViewById(R.id.natureLabel);
        perception = (TextView)view.findViewById(R.id.perceptionLabel);
        performance = (TextView)view.findViewById(R.id.performanceLabel);
        persuasion = (TextView)view.findViewById(R.id.persuasionLabel);
        religion = (TextView)view.findViewById(R.id.religionLabel);
        sleight = (TextView)view.findViewById(R.id.sleightLabel);
        stealth = (TextView)view.findViewById(R.id.stealthLabel);
        survival = (TextView)view.findViewById(R.id.survivalLabel);

        //Saving Throws
        strVal = (EditText) view.findViewById(R.id.strVal);
        strBox = (CheckBox) view.findViewById(R.id.strChk);
        dexVal = (EditText) view.findViewById(R.id.dexVal);
        dexBox = (CheckBox) view.findViewById(R.id.dexChk);
        conVal = (EditText) view.findViewById(R.id.conVal);
        conBox = (CheckBox) view.findViewById(R.id.conChk);
        intVal = (EditText) view.findViewById(R.id.intVal);
        intBox = (CheckBox) view.findViewById(R.id.intChk);
        wisVal = (EditText) view.findViewById(R.id.wisVal);
        wisBox = (CheckBox) view.findViewById(R.id.wisChk);
        chaVal = (EditText) view.findViewById(R.id.chaVal);
        chaBox = (CheckBox) view.findViewById(R.id.chaChk);

        //Skill Boxes
        acrobaticsBox = (CheckBox) view.findViewById(R.id.acrobaticsBox);
        animalHandlingBox = (CheckBox) view.findViewById(R.id.animalHandlingBox);
        arcanaBox = (CheckBox) view.findViewById(R.id.arcanaBox);
        athleticsBox = (CheckBox) view.findViewById(R.id.athleticsBox);
        deceptionBox = (CheckBox) view.findViewById(R.id.deceptionBox);
        historyBox = (CheckBox) view.findViewById(R.id.historyBox);
        insightBox = (CheckBox) view.findViewById(R.id.insightBox);
        intimidationBox = (CheckBox) view.findViewById(R.id.intimidationBox);
        investigationBox = (CheckBox) view.findViewById(R.id.investigationBox);
        medicineBox = (CheckBox) view.findViewById(R.id.medicineBox);
        natureBox = (CheckBox) view.findViewById(R.id.natureBox);
        perceptionBox = (CheckBox) view.findViewById(R.id.perceptionBox);
        performanceBox = (CheckBox) view.findViewById(R.id.performanceBox);
        persuasionBox = (CheckBox) view.findViewById(R.id.persuasionBox);
        religionBox = (CheckBox) view.findViewById(R.id.religionBox);
        sleightBox = (CheckBox) view.findViewById(R.id.sleightBox);
        stealthBox = (CheckBox) view.findViewById(R.id.stealthBox);
        survivalBox = (CheckBox) view.findViewById(R.id.survivalBox);

        //proficiency, equipment, feats, HP, AC, etc
        profBonus = (EditText) view.findViewById(R.id.profVal);
        equip = (EditText) view.findViewById(R.id.equipment);
        feats = (EditText) view.findViewById(R.id.feats);
        init = (EditText) view.findViewById(R.id.initVal);
        spd = (EditText) view.findViewById(R.id.speedVal);
        hpCurr = (EditText) view.findViewById(R.id.curHpVal);
        hpMax = (EditText) view.findViewById(R.id.totalHpVal);
        ac = (EditText) view.findViewById(R.id.acVal);

        //load current character info into TextViews from MainActivity
        update();

        str.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = strVal.getText().toString();
                if (!textVal.equals(""))
                    roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                else
                    roll = diceRoll(20);
                if(strBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }

                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        dex.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = dexVal.getText().toString();
                if (!textVal.equals(""))
                    roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                else
                    roll = diceRoll(20);
                if(dexBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }

                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        con.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = conVal.getText().toString();
                if (!textVal.equals(""))
                    roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                else
                    roll = diceRoll(20);
                if(conBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }

                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        intel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = intVal.getText().toString();
                if (!textVal.equals(""))
                    roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                else
                    roll = diceRoll(20);
                if(intBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }

                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        wis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = wisVal.getText().toString();
                if (!textVal.equals(""))
                    roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                else
                    roll = diceRoll(20);
                if(wisBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }

                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        cha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = chaVal.getText().toString();
                if (!textVal.equals(""))
                    roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                else
                    roll = diceRoll(20);
                if(chaBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }

                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        acrobatics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = dexVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(acrobaticsBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        animalHandling.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = wisVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(animalHandlingBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        arcana.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = intVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(arcanaBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        athletics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = strVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(athleticsBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        deception.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = chaVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(deceptionBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = intVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(historyBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        insight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = wisVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(insightBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        intimidation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = chaVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(intimidationBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        investigation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = intVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(investigationBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        medicine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = wisVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(medicineBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        nature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = intVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(natureBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        perception.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = wisVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(perceptionBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        performance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = chaVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(performanceBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        persuasion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = chaVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(persuasionBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        religion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = intVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(religionBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        sleight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = dexVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(sleightBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        stealth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = dexVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(stealthBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        survival.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int roll;
                String textVal = wisVal.getText().toString();
                roll = diceRoll(20) + ((Integer.parseInt(textVal)-10)/2);
                if(survivalBox.isChecked() && (!profBonus.getText().toString().equals("")))
                {
                    roll += Integer.parseInt(profBonus.getText().toString());
                }
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(Integer.toString(roll));
            }
        });

        //CheckBox watchers to save changed data to character
        strBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharProfStr(1);
                else
                    character.setCharProfStr(0);
            }
        });
        dexBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharProfDex(1);
                else
                    character.setCharProfDex(0);
            }
        });
        conBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharProfCon(1);
                else
                    character.setCharProfCon(0);
            }
        });
        intBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharProfInt(1);
                else
                    character.setCharProfInt(0);
            }
        });
        wisBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharProfWis(1);
                else
                    character.setCharProfWis(0);
            }
        });
        chaBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharProfCha(1);
                else
                    character.setCharProfCha(0);
            }
        });
        acrobaticsBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkAcro(1);
                else
                    character.setCharSkAcro(0);
            }
        });
        animalHandlingBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkAnimal(1);
                else
                    character.setCharSkAnimal(0);
            }
        });
        arcanaBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkArcana(1);
                else
                    character.setCharSkArcana(0);
            }
        });
        athleticsBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkAth(1);
                else
                    character.setCharSkAth(0);
            }
        });
        deceptionBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkDecept(1);
                else
                    character.setCharSkDecept(0);
            }
        });
        historyBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkHist(1);
                else
                    character.setCharSkHist(0);
            }
        });
        insightBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkInsight(1);
                else
                    character.setCharSkInsight(0);
            }
        });
        investigationBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkInvest(1);
                else
                    character.setCharSkInvest(0);
            }
        });
        intimidationBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkIntim(1);
                else
                    character.setCharSkIntim(0);
            }
        });
        medicineBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkMed(1);
                else
                    character.setCharSkMed(0);
            }
        });
        natureBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkNat(1);
                else
                    character.setCharSkNat(0);
            }
        });
        perceptionBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkPerc(1);
                else
                    character.setCharSkPerc(0);
            }
        });
        performanceBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkPerf(1);
                else
                    character.setCharSkPerf(0);
            }
        });
        persuasionBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkPers(1);
                else
                    character.setCharSkPers(0);
            }
        });
        religionBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkRel(1);
                else
                    character.setCharSkRel(0);
            }
        });
        sleightBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkSleight(1);
                else
                    character.setCharSkSleight(0);
            }
        });
        stealthBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkStealth(1);
                else
                    character.setCharSkStealth(0);
            }
        });
        survivalBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    character.setCharSkSurv(1);
                else
                    character.setCharSkSurv(0);
            }
        });

        //EditText watchers to save changed data to character
        strVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharStr(Integer.parseInt(strVal.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dexVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharDex(Integer.parseInt(dexVal.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        conVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharCon(Integer.parseInt(conVal.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        intVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharInt(Integer.parseInt(intVal.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        wisVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharWis(Integer.parseInt(wisVal.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        chaVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharCha(Integer.parseInt(chaVal.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ac.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharAC(Integer.parseInt(ac.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        profBonus.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharProf(Integer.parseInt(profBonus.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        init.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharInit(Integer.parseInt(init.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        spd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharSpd(Integer.parseInt(spd.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        hpCurr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharHPCurr(Integer.parseInt(hpCurr.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        hpMax.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharHPMax(Integer.parseInt(hpMax.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        equip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharEquip(equip.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        feats.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                character.setCharFeats(feats.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    public int diceRoll(int die)
    {
        return (int)((Math.random()*die)+1);
    }

    public void update() {
        //load character from MainActivity
        character = MainActivity.character;

        //update abilities
        strVal.setText(valueOf(character.getCharStr()));
        dexVal.setText(valueOf(character.getCharDex()));
        conVal.setText(valueOf(character.getCharCon()));
        intVal.setText(valueOf(character.getCharInt()));
        wisVal.setText(valueOf(character.getCharWis()));
        chaVal.setText(valueOf(character.getCharCha()));

        //update skills and saving throw checks
        strBox.setChecked(character.getCharProfStr() == 1);
        dexBox.setChecked(character.getCharProfDex() == 1);
        conBox.setChecked(character.getCharProfCon() == 1);
        intBox.setChecked(character.getCharProfInt() == 1);
        wisBox.setChecked(character.getCharProfWis() == 1);
        chaBox.setChecked(character.getCharProfCha() == 1);
        acrobaticsBox.setChecked(character.getCharSkAcro() == 1);
        animalHandlingBox.setChecked(character.getCharSkAnimal() == 1);
        arcanaBox.setChecked(character.getCharSkArcana() == 1);
        athleticsBox.setChecked(character.getCharSkAth() == 1);
        deceptionBox.setChecked(character.getCharSkDecept() == 1);
        historyBox.setChecked(character.getCharSkHist() == 1);
        insightBox.setChecked(character.getCharSkInsight() == 1);
        intimidationBox.setChecked(character.getCharSkIntim() == 1);
        investigationBox.setChecked(character.getCharSkInvest() == 1);
        medicineBox.setChecked(character.getCharSkMed() == 1);
        natureBox.setChecked(character.getCharSkNat() == 1);
        perceptionBox.setChecked(character.getCharSkPerc() == 1);
        performanceBox.setChecked(character.getCharSkPerf() == 1);
        persuasionBox.setChecked(character.getCharSkPers() == 1);
        religionBox.setChecked(character.getCharSkRel() == 1);
        sleightBox.setChecked(character.getCharSkSleight() == 1);
        stealthBox.setChecked(character.getCharSkStealth() == 1);
        survivalBox.setChecked(character.getCharSkSurv() == 1);

        //update misc stuffs like HP and proficiency bonus
        profBonus.setText(valueOf(character.getCharProf()));
        ac.setText(valueOf(character.getCharAC()));
        init.setText(valueOf(character.getCharInit()));
        spd.setText(valueOf(character.getCharSpd()));
        hpCurr.setText(valueOf(character.getCharHPCurr()));
        hpMax.setText(valueOf(character.getCharHPMax()));
        equip.setText(character.getCharEquip());
        feats.setText(character.getCharFeats());
    }
}
