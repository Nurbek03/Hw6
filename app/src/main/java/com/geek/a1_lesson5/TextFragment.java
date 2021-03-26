package com.geek.a1_lesson5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment  {

    private String mParam1;
    private String mParam2;
    private TextView tvTitle,tvSubTitle;
    public TextFragment() {

    }

    public static TextFragment newInstance(String param1, String param2) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString("arg1",param1);
        args.putString("arg2",param2);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             mParam1 = getArguments().getString("arg1");
             mParam2 = getArguments().getString("arg2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text, container, false);
        tvTitle = view.findViewById(R.id.tv_title);
        tvSubTitle = view.findViewById(R.id.tv_subTitle);
        if (mParam1!=null){
        tvTitle.setText(mParam1);
        tvSubTitle.setText(mParam2);}
        return view;
    }

    public void showText(String title, String subTitle) {
    }
}