package com.example.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeDisplayFragment extends Fragment {

    public JokeDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.joke_fragment, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(jokeDisplayActivity.joke_key);
        TextView jokeTextView = (TextView) rootView.findViewById(R.id.joke_textview);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return rootView;
    }

}
