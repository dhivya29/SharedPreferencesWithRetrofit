package com.example.dhiviya.dhivya.grid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dhiviya.dhivya.R;
import com.example.dhiviya.dhivya.list.ListAdapter;
import com.example.dhiviya.dhivya.preference.PreferenceKeys;
import com.example.dhiviya.dhivya.preference.PreferencesPiczy;

import java.util.ArrayList;
import java.util.List;


public class GridItemFragment extends Fragment {
    RecyclerView recyclerView;

    private List<String> imageList=new ArrayList<>();
    private ListAdapter listAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_frag,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        getList();

        //    presenter = getPresenter();

    }

    private void getList() {
        for (int i = 0; i<5 ; i++){
            String images= PreferencesPiczy.getStringValue(getActivity(), PreferenceKeys.Images+i);
            imageList.add(images);
        }
        setAdapter();
    }

    private void setAdapter() {
        if (imageList!=null){
            listAdapter=new ListAdapter(getActivity(),imageList);
            recyclerView.setAdapter(listAdapter);
        }
    }
}
