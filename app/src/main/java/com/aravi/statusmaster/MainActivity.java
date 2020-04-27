package com.aravi.statusmaster;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aravi.statusmaster.adapter.ListAdapter;
import com.aravi.statusmaster.model.Status;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Status> statuses;

    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rcv_statuses);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        String path = Environment.getExternalStorageDirectory().toString() + "/WhatsApp/Media/.Statuses";
        File directory = new File(path);
        statuses = new ArrayList<>();
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.getName().contains(".jpg")) {
                Status status = new Status();
                Uri uri = Uri.fromFile(file);
                status.setName(uri.toString());
                status.setType("image");
                status.setLastUpdated(file.lastModified());
                statuses.add(status);

            }
        }
        Collections.shuffle(statuses);

        listAdapter = new ListAdapter(this, statuses);
        recyclerView.setAdapter(listAdapter);

    }
}
