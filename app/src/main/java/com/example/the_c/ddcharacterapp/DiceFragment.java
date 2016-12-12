package com.example.the_c.ddcharacterapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DiceFragment extends Fragment {

    public DiceFragment() {
    }

    //animations
    private Animation coinFlip;
    private Animation coinFlipBack;
    //widgets
    TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dice, container, false);

        coinFlip = AnimationUtils.loadAnimation(getActivity(), R.anim.coinflip);
        coinFlip.setDuration(1000);
        result = (TextView) view.findViewById(R.id.rollResult);
        Button coin = (Button) view.findViewById(R.id.flipDie);
        Button d4 = (Button) view.findViewById(R.id.fourDie);
        Button d6 = (Button) view.findViewById(R.id.sixDie);
        Button d8 = (Button) view.findViewById(R.id.eightDie);
        Button d10 = (Button) view.findViewById(R.id.tenDie);
        Button d12 = (Button) view.findViewById(R.id.twelveDie);
        Button d20 = (Button) view.findViewById(R.id.twentyDie);
        Button dPercent = (Button) view.findViewById(R.id.percentDie);

        coin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(2);
                if(roll.equals("1"))
                    roll = "Heads";
                else
                    roll = "Tails";
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);

            }
        });
        d4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(4);
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        d6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(6);
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        d8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(8);
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        d10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(10);
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        d12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(12);
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        d20.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(20);
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        dPercent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String roll = diceRoll(100);
                roll += "%";
                result.startAnimation(coinFlip);
                result.setText(roll);
                ((MainActivity)getActivity()).rollValue.startAnimation(coinFlip);
                ((MainActivity)getActivity()).rollUpdater(roll);
            }
        });
        return view;
    }

    public java.lang.String diceRoll(int die)
    {
        return Integer.toString((int)((Math.random()*die)+1));
    }
}
