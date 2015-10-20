package com.perfection.firstapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class ContentFragment extends Fragment {

    public static final String TAG = "HOME";
    private int counter = 0;
    private View v;
    private int sumOfWords,sumOfRemainWords,learnedWords,progressPrecent;
    private TextView sumOfWordsView,sumOfRemainWordsView,learnedWordsView,progressPrecentView,sumOfWordsTitle,sumOfRemainWordsTitle,learnedWordsTitle,
            progressPrecentTitle, startButton, learnedWordsButton ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.content_fragment,container,false);

        sumOfWords = 2000;
        learnedWords = 420;
        sumOfRemainWords = sumOfWords - learnedWords ;

        FieldsUpdate(v);
        handleClicks();

        return v;
    }

    private void FieldsUpdate(View v){

        sumOfWordsTitle = (TextView) v.findViewById(R.id.sumOfWordsHebtitle);
        sumOfRemainWordsTitle = (TextView) v.findViewById(R.id.sumOfLearnedWordstitle);
        learnedWordsTitle = (TextView) v.findViewById(R.id.sumOfLearnedWordstitle);
        progressPrecentTitle = (TextView) v.findViewById(R.id.progressPrecentTitle);
        sumOfRemainWordsView = (TextView) v.findViewById(R.id.sumOfRemainWordsHeb);
        sumOfWordsView = (TextView) v.findViewById(R.id.sumOfWordsHeb);
        learnedWordsView = (TextView) v.findViewById(R.id.sumOfLearnedWords);
        progressPrecentView = (TextView) v.findViewById(R.id.progressPrecent);


        sumOfWordsView.setText("" + sumOfWords);
        sumOfRemainWordsView.setText("" + sumOfRemainWords);
        learnedWordsView.setText("" + learnedWords);
        progressPrecentView.setText("" + (learnedWords * 100) / sumOfWords);

    }


    private void handleClicks() {

        startButton = (TextView) v.findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(v.getContext() ,startButton);
                popup.getMenuInflater()
                        .inflate(R.menu.units_menu,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        /*Toast.makeText(
                                ,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();*/
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }

        });


/*
        hebrewButton = (Button) v.findViewById(R.id.hebrewButton);

        hebrewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), HebrewMenuActivity.class);
                getActivity().startActivity(myIntent);
            }
        });


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tv3.setText(String.valueOf(counter));
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv1.getText().equals("Static TextView")) {
                    tv1.setText("Hello");
                    Toast.makeText(v.getContext(), tv1.getText() + " Clicked", Toast.LENGTH_SHORT).show();
                } else if (tv1.getText().equals("Hello")) {
                    tv1.setText("Static TextView");
                    Toast.makeText(v.getContext(), tv1.getText() + " Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setRetainInstance(true); //Will ignore onDestroy Method (Nested Fragments no need this if parent have it)
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
        }
    }

}
