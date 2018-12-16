package com.robydarmansyah.horizontalparallax;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
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
    private View itemCover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initSetup();
    }

    ColorDrawable drawable = new ColorDrawable();


    private void initSetup() {
        list = new ArrayList<>(Arrays.asList("cover", "Description 1", "Description 2", "Description 3", "Description 4", "Description 5"));
        adapter = new ItemAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));

        drawable.setColor(ContextCompat.getColor(this, R.color.colorPrimary));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView r, int dx, int dy) {
                super.onScrolled(r, dx, dy);
                if(itemCover ==null) {
                    itemCover = r.getChildAt(0);
                }

                if (r.getChildAdapterPosition(itemCover) == 0) {
                    itemCover.setTranslationX(-itemCover.getLeft() / 2);
                    setOpacity(itemCover,r);
                }

            }
        });
    }

    private void setOpacity(View view,RecyclerView recyclerView) {
        int headerWidth = (view.getWidth() * 2) - recyclerView.computeHorizontalScrollOffset();
        float ratio = (float) Math.min(Math.max(-view.getLeft(), 0), headerWidth) / headerWidth;
        float alpha = Math.abs(ratio - 1);

        view.setAlpha(alpha);
    }
}
