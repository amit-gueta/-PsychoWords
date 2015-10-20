package com.perfection.firstapp;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;


/**
 * Created by eli on 10/19/15.
 */
public class ContentFragmentHebrewMenu extends Fragment {
    public static final String TAG = "HOME";
    private int sumOfWords,sumOfRemainWords,learnedWords,progressPrecent;
    private TextView sumOfWordsView,sumOfRemainWordsView,learnedWordsView,progressPrecentView,sumOfWordsTitle,sumOfRemainWordsTitle,learnedWordsTitle,
                        progressPrecentTitle ;
    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.content_fregment_hebrew_menu,container,false);

        sumOfWords = 2000;
        learnedWords = 420;
        sumOfRemainWords = sumOfWords - learnedWords ;

        FieldsUpdate(v);


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
        progressPrecentView.setText("" + (learnedWords*100)/sumOfWords );

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

        }

    }



}
