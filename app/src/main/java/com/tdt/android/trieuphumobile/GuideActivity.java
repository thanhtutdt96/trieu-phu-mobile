package com.tdt.android.trieuphumobile;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    List<TextView> textViewList;
    List<ImageView> imageViewList;
    private TextView question1;
    private TextView question2;
    private TextView question3;
    private TextView question4;
    private TextView question5;
    private TextView question6;
    private TextView question7;
    private TextView question8;
    private TextView question9;
    private TextView question10;
    private TextView question11;
    private TextView question12;
    private TextView question13;
    private TextView question14;
    private TextView question15;
    private ImageView guideCall;
    private ImageView guideAudience;
    private ImageView guideFifty;
    private ImageView guideChange;
    private Handler handler1;
    private Handler handler2;
    private Handler handler3;
    private Handler handler4;

    private int i = 0;
    private int k = 0;
    private int j = 0;
    private MediaManager background;
    private MediaManager guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initControls();
        setControls();
    }

    private void initControls() {
        background = new MediaManager(GuideActivity.this);
        background.openMedia(R.raw.score, true);
        guide = new MediaManager(GuideActivity.this);
        guide.openMedia(R.raw.guide, false);

        question1 = (TextView) findViewById(R.id.ques1);
        question2 = (TextView) findViewById(R.id.ques2);
        question3 = (TextView) findViewById(R.id.ques3);
        question4 = (TextView) findViewById(R.id.ques4);
        question5 = (TextView) findViewById(R.id.ques5);
        question6 = (TextView) findViewById(R.id.ques6);
        question7 = (TextView) findViewById(R.id.ques7);
        question8 = (TextView) findViewById(R.id.ques8);
        question9 = (TextView) findViewById(R.id.ques9);
        question10 = (TextView) findViewById(R.id.ques10);
        question11 = (TextView) findViewById(R.id.ques11);
        question12 = (TextView) findViewById(R.id.ques12);
        question13 = (TextView) findViewById(R.id.ques13);
        question14 = (TextView) findViewById(R.id.ques14);
        question15 = (TextView) findViewById(R.id.ques15);
        guideCall = (ImageView) findViewById(R.id.guide_call);
        guideAudience = (ImageView) findViewById(R.id.guide_audience);
        guideFifty = (ImageView) findViewById(R.id.guide_fifty);
        guideChange=(ImageView)findViewById(R.id.guide_change);

        textViewList = new ArrayList<>();
        textViewList.add(question1);
        textViewList.add(question2);
        textViewList.add(question3);
        textViewList.add(question4);
        textViewList.add(question5);
        textViewList.add(question6);
        textViewList.add(question7);
        textViewList.add(question8);
        textViewList.add(question9);
        textViewList.add(question10);
        textViewList.add(question11);
        textViewList.add(question12);
        textViewList.add(question13);
        textViewList.add(question14);
        textViewList.add(question15);

        imageViewList = new ArrayList<>();
        imageViewList.add(guideFifty);
        imageViewList.add(guideCall);
        imageViewList.add(guideAudience);
        imageViewList.add(guideChange);
    }

    private void setControls() {
        final int yellow = Color.parseColor("#DFA119");
        final int white = Color.WHITE;
        final int black = Color.BLACK;

        setResourceColor(textViewList.get(0), R.drawable.guide_mark, black);
        handler1 = new Handler();
        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                setResourceColor(textViewList.get(0), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(1), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(2), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(3), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(4), Color.TRANSPARENT, white);
                setResourceColor(textViewList.get(5), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(6), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(7), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(8), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(9), Color.TRANSPARENT, white);
                setResourceColor(textViewList.get(10), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(11), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(12), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(13), Color.TRANSPARENT, yellow);
                setResourceColor(textViewList.get(14), Color.TRANSPARENT, white);

                if (i < textViewList.size()) {
                    setResourceColor(textViewList.get(i), R.drawable.guide_mark, black);
                    i++;
                    handler1.postDelayed(this, 200);
                }
            }
        };
        handler1.postDelayed(runnable1, 300);

        handler2 = new Handler();
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                if (k < textViewList.size()) {
                    if (k == 4 || k == 9 || k == 14)
                        setResourceColor(textViewList.get(k), R.drawable.guide_mark, black);
                    k++;
                    handler2.postDelayed(this, 150);
                }
            }

        };
        handler2.postDelayed(runnable2, 4000);

        handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                setResourceColor(textViewList.get(4), 0, white);
                setResourceColor(textViewList.get(9), 0, white);
                setResourceColor(textViewList.get(14), 0, white);
            }
        }, 7500);

        handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (j < imageViewList.size()) {
                    zoomInOut(imageViewList.get(j));
                    j++;
                    handler4.postDelayed(this, 1000);
                }
            }
        }, 8000);

    }

    private void setResourceColor(TextView question, int resource, int color) {
        question.setBackgroundResource(resource);
        question.setTextColor(color);
    }

    private void zoomInOut(ImageView image) {
        Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.zoom_in_out);
        animation.reset();
        image.startAnimation(animation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        guide.playBackGround();
        background.playBackGround();
    }

    @Override
    protected void onPause() {
        super.onPause();
        background.pause();
        if (guide.isPlaying())
            guide.pause();
    }
}
