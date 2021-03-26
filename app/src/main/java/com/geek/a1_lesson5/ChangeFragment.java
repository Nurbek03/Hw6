package com.geek.a1_lesson5;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class ChangeFragment extends Fragment implements IFragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerModel model;
    private IFragment iFragment;
    private ArrayList<RecyclerModel> list;

    public ChangeFragment() {
        // Required empty public constructor
    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change, container, false);
         recyclerView = view.findViewById(R.id.recyclerView);
         setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        list = new ArrayList<>();
        list.add(new RecyclerModel("Hello from 30th group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));
        list.add(new RecyclerModel("Hello from 30 group","sub title"));

        adapter = new RecyclerAdapter(list,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnclickListener(this);
    }

    @Override
    public void displayDetails(String title, String subTitle) {
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.displayDetails(title,subTitle);
    }
}