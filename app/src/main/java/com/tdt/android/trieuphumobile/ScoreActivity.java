package com.tdt.android.trieuphumobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<ScoreItem> listScore;
    private CustomAdapter adapter;
    private Button btnBack;
    private MediaManager background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        loadScore();
        initView();
        initControls();
    }

    public void initControls() {
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreActivity.this, StartActivity.class));
            }
        });
        background = new MediaManager(ScoreActivity.this);
        background.openMedia(R.raw.score, true);
    }

    private void loadScore() {
        listView = (ListView) findViewById(R.id.list_score);
        listScore = new ArrayList<>();
        listScore.addAll(StartActivity.scoreHandler.getListScores());
    }

    private void initView() {
        adapter = new CustomAdapter(ScoreActivity.this, R.layout.custom_layout_score, listScore);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        background.playBackGround();
    }

    @Override
    protected void onPause() {
        super.onPause();
        background.pause();
    }
}
