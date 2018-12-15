package com.robydarmansyah.horizontalparallax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.robydarmansyah.horizontalparallax.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    private ItemAdapter adapter;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initSetup();
    }

    private void initSetup() {
        list = new ArrayList<>(Arrays.asList("cover","Description 1", "Description 2", "Description 3", "Description 4", "Description 5"));
        adapter = new ItemAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView r, int dx, int dy) {
                super.onScrolled(r, dx, dy);
                View view = r.getChildAt(0);
                if(view != null && recyclerView.getChildAdapterPosition(view) == 0) {
                    view.setTranslationX(-view.getLeft() / 2);
                }
            }
        });

    }
}
