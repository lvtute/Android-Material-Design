package com.hcmute.thuan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new  LinearLayoutManager(this));

        listItems = new ArrayList<>();
        ListItem item = new ListItem();
        for (int i = 0; i< 10; i++){
            item =
                    new ListItem("Item" + (i+1),
                            "Description" + i+1,
                            "Excellent");
            listItems.add(item);
        }
        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);

    }
}
