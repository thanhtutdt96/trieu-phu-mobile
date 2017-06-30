package com.tdt.android.trieuphumobile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    public static ScoreHandler scoreHandler;
    private Button btnPlay;
    private Button btnScore;
    private Button btnGuide;
    private Button btnClose;
    private ToggleButton btnMusic;
    private Button btnInfo;
    private Button btnChangeName;
    public static TextView playerName;

    private MediaManager background;
    private MediaManager start;
    private MediaManager soundPoolStart;
    public static MediaManager soundPoolMain;

    private ProgressDialog progress;
    private RelativeLayout startLayout;
    private Dialog infoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initControls();
        setControls();
    }

    @Override
    protected void onResume() {
        super.onResume();
        background.playBackGround();
        if (playerName.getText().toString().length() <= 0 && loadSavedName().length() <= 0) {
            playerName.setText("Player 1");

        } else {
            playerName.setText(loadSavedName());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        background.pause();
    }

    public void initControls() {
        scoreHandler = new ScoreHandler(this);

        startLayout = (RelativeLayout) findViewById(R.id.start_layout);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnMusic = (ToggleButton) findViewById(R.id.btnMusic);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnScore = (Button) findViewById(R.id.btnScore);
        btnGuide = (Button) findViewById(R.id.btnGuide);
        btnChangeName = (Button) findViewById(R.id.btnChangeName);
        playerName = (TextView) findViewById(R.id.player_name);

        background = new MediaManager(StartActivity.this);
        background.openMedia(R.raw.bgstart, true);

        start = new MediaManager(StartActivity.this);
        start.openMedia(R.raw.start, false);

        soundPoolStart = new MediaManager(StartActivity.this);
        soundPoolStart.add("ready", R.raw.ready);
        soundPoolStart.add("joker", R.raw.joker);
        soundPoolMain = new MediaManager(StartActivity.this);
    }

    public void addSoundPool() {
        soundPoolMain.add("true1", R.raw.true1);
        soundPoolMain.add("true2", R.raw.true2);
        soundPoolMain.add("true3", R.raw.true3);
        soundPoolMain.add("false", R.raw.false1);
        soundPoolMain.add("final_answer", R.raw.final_answer);
        soundPoolMain.add("final_answer2", R.raw.final_answer2);
        soundPoolMain.add("mark5", R.raw.mark5);
        soundPoolMain.add("mark10", R.raw.mark10);
        soundPoolMain.add("mark15", R.raw.mark15);
        soundPoolMain.add("fifty", R.raw.help_fifty);
        soundPoolMain.add("ques1", R.raw.ques1);
        soundPoolMain.add("ques2", R.raw.ques2);
        soundPoolMain.add("ques3", R.raw.ques3);
        soundPoolMain.add("ques4", R.raw.ques4);
        soundPoolMain.add("ques5", R.raw.ques5);
        soundPoolMain.add("ques6", R.raw.ques6);
        soundPoolMain.add("ques7", R.raw.ques7);
        soundPoolMain.add("ques8", R.raw.ques8);
        soundPoolMain.add("ques9", R.raw.ques9);
        soundPoolMain.add("ques10", R.raw.ques10);
        soundPoolMain.add("ques11", R.raw.ques11);
        soundPoolMain.add("ques12", R.raw.ques12);
        soundPoolMain.add("ques13", R.raw.ques13);
        soundPoolMain.add("ques14", R.raw.ques14);
        soundPoolMain.add("ques15", R.raw.ques15);

    }

    public void setControls() {
        btnMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    background.pause();
                    btnMusic.setBackgroundResource(R.drawable.music_off);
                } else {
                    background.playBackGround();
                    btnMusic.setBackgroundResource(R.drawable.music);
                }
            }
        });
        btnClose.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnGuide.setOnClickListener(this);
        btnScore.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnChangeName.setOnClickListener(this);
    }

    private void disableEnableControls(boolean enable, ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View child = vg.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup) {
                disableEnableControls(enable, (ViewGroup) child);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClose:
                disableEnableControls(false, startLayout);
                new AlertDialog.Builder(StartActivity.this)
                        .setMessage("Bạn có muốn thoát không?")
                        .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                disableEnableControls(true, startLayout);
                            }
                        })
                        .show();
                break;

            case R.id.btnPlay:
                disableEnableControls(false, startLayout);
                background.pause();
                soundPoolStart.play("joker");
                soundPoolStart.play("ready");
                new AlertDialog.Builder(StartActivity.this)
                        .setMessage("Bạn đã sẵn sàng chưa?")
                        .setNegativeButton("Sẵn sàng", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                background.stop();
                                start.playBackGround();

                                progress = new ProgressDialog(StartActivity.this);
                                progress.setMessage("Chúng ta đi tìm Ai là Triệu Phú...");
                                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progress.show();

                                Runnable progressRunnable = new Runnable() {

                                    @Override
                                    public void run() {
                                        addSoundPool();
                                        progress.dismiss();
                                        disableEnableControls(true, startLayout);
                                        startActivity(new Intent(StartActivity.this, MainActivity.class));
                                    }
                                };

                                Handler handler = new Handler();
                                handler.postDelayed(progressRunnable, 5500);
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("Chưa", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                disableEnableControls(true, startLayout);
                                background.playBackGround();
                            }
                        })
                        .show();

                break;

            case R.id.btnScore:
                disableEnableControls(false, startLayout);
                background.pause();
                soundPoolStart.play("joker");
                startActivity(new Intent(StartActivity.this, ScoreActivity.class));
                disableEnableControls(true, startLayout);
                break;

            case R.id.btnGuide:
                disableEnableControls(false, startLayout);
                background.pause();
                soundPoolStart.play("joker");
                startActivity(new Intent(StartActivity.this, GuideActivity.class));
                disableEnableControls(true, startLayout);
                break;

            case R.id.btnInfo:
                disableEnableControls(false, startLayout);
                background.pause();
                soundPoolStart.play("joker");
                infoDialog = new Dialog(StartActivity.this);
                infoDialog.setContentView(R.layout.custom_layout_info);
                Button btnCloseDialog = (Button) infoDialog.findViewById(R.id.btnCloseDialog);
                btnCloseDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        infoDialog.dismiss();
                    }
                });
                infoDialog.getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                infoDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                infoDialog.show();
                disableEnableControls(true, startLayout);
                background.playBackGround();
                break;

            case R.id.btnChangeName:
                final EditText txtName = new EditText(this);
                txtName.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                txtName.setGravity(Gravity.CENTER);
                new AlertDialog.Builder(new ContextThemeWrapper(StartActivity.this, android.R.style.Theme_Holo_Light_Dialog))
                        .setView(txtName)
                        .setTitle("Nhập tên của bạn")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                playerName.setText(txtName.getText().toString());
                                saveCurrentName(txtName.getText().toString());
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("Cancel", null)
                        .show();

                break;

        }
    }

    private void saveCurrentName(String name) {
        SharedPreferences preferences = getSharedPreferences("prefName", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name);
        editor.commit();
    }

    private String loadSavedName() {
        SharedPreferences preferences = getSharedPreferences("prefName", MODE_PRIVATE);
        String name = preferences.getString("name", "");
        return name;
    }
}

