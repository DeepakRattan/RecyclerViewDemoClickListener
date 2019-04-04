package com.example.deepakrattan.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<SingleRow> singleRowArrayList;
    SingleRow singleRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        //Data Source
        String[] title = {"Title", "Title", "Title", "Title", "Title", "Title", "Title", "Title", "Title", "Title"};
        String[] description = {"this is description ", "this is description ", "this is description ", "this is description ", "this is description ", "this is description ", "this is description ", "this is description ", "this is description ", "this is description "};
        int[] images = {R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic, R.drawable.pic};
        singleRowArrayList = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            singleRow = new SingleRow(title[i], description[i], images[i]);
            singleRowArrayList.add(singleRow);

        }

        RecyclerViewOnItemClickListener recyclerViewOnItemClickListener= new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                String title = singleRowArrayList.get(position).getTitle();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();

            }
        };

        MyAdapter adapter = new MyAdapter(this, singleRowArrayList,recyclerViewOnItemClickListener);
        rv.setAdapter(adapter);
    }
}
