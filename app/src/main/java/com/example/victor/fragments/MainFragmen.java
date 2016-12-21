package com.example.victor.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragmen extends Fragment {

    private  MenuInteractionListener mListener = null;

    Button button = null;

    public final static String SOME_VALUE = "SOME_VALUE";

// не переопределять! исп Bundle
    public MainFragmen() {
        // Required empty public constructor
    }

//newInstance... for bundle
    public static MainFragmen newInstance(int value) {

        Bundle args = new Bundle();
        args.putInt(SOME_VALUE, value);

        MainFragmen fragment = new MainFragmen();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int value = getArguments().getInt(SOME_VALUE);
                mListener.onMainFragmentListener(value);
            }
        });

        getArguments().getInt(SOME_VALUE);
    }

    public void showText (CharSequence text){
        //final View view = getView();
        //if(view == null) return;
        if(getView() == null) return;
        final TextView textView = (TextView) getView().findViewById(R.id.text);
        textView.setText(text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MenuInteractionListener) {
            mListener = (MenuInteractionListener) context;

        }
    }
}
