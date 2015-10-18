package com.perfection.firstapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class ContentFragment extends Fragment {

    public static final String TAG = "HOME";
    private int counter = 0;
    private TextView tv1, tv2, tv3;
    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.content_fragment,container,false);
        handleClicks();
        return v;
    }

    private void handleClicks() {
        tv1 = (TextView) v.findViewById(R.id.textView1);
        tv2 = (TextView) v.findViewById(R.id.textView2);
        tv3 = (TextView) v.findViewById(R.id.textView3);
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

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setRetainInstance(true); //Will ignore onDestroy Method (Nested Fragments no need this if parent have it)
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("current", tv3.getText().toString());
        }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            tv3.setText(savedInstanceState.getString("current"));
            counter = Integer.parseInt(savedInstanceState.getString("current"));
        }
    }

}
