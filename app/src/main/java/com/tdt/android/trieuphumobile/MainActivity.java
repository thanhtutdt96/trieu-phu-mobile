package com.tdt.android.trieuphumobile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String currentDate;
    private static final long TIME_QUEST = 21000;
    List<QuestionItem> questionList;
    private DatabaseHandler questionHandler;
    private QuestionItem currQuestion;
    private CountDownTimer timerQuestion;
    private long currentTime;

    // Question board views
    private TextView question;
    private TextView optionA;
    private TextView optionB;
    private TextView optionC;
    private TextView optionD;
    private TextView questionNumber;
    private TextView money;
    private TextView time;
    private List<TextView> listOption;

    // Help board views
    private ImageView stop;
    private ImageView helpCall;
    private ImageView turnOffCall;
    private ImageView help5050;
    private ImageView turnOff5050;
    private ImageView helpAskAudience;
    private ImageView turnOffAsk;
    private ImageView helpChangeQuestion;
    private ImageView turnOffChange;

    private RelativeLayout mainLayout;
    private int number = 0;
    private int score = 0;

    private HashMap<String, TextView> mapOptions;
    private HashMap<String, Integer> mapAudience;
    private List<TextView> mapFifty;

    // Media items
    private MediaManager main1;
    private MediaManager main2;
    private MediaManager main3;
    private MediaManager mark5;
    private MediaManager mark10;
    private MediaManager mark15;
    private MediaManager soundPool;
    private MediaManager callWaiting;
    private MediaManager callProgress;
    private MediaManager audience;

    private boolean isClicked = false;
    private LinearLayout layout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        main1.playBackGround();
        loadQuestions();
        displayQuestion();
        questionHandler.closeDatabase();
        setControls();
    }

    public void initControls() {
        DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm");
        currentDate = df.format(Calendar.getInstance().getTime());
        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);

        questionNumber = (TextView) findViewById(R.id.question_number);
        money = (TextView) findViewById(R.id.money);
        time = (TextView) findViewById(R.id.time);
        question = (TextView) findViewById(R.id.question);
        optionA = (TextView) findViewById(R.id.optionA);
        optionB = (TextView) findViewById(R.id.optionB);
        optionC = (TextView) findViewById(R.id.optionC);
        optionD = (TextView) findViewById(R.id.optionD);

        listOption = new ArrayList<>();
        listOption.add(optionA);
        listOption.add(optionB);
        listOption.add(optionC);
        listOption.add(optionD);

        mapOptions = new HashMap<>();
        mapOptions.put("A", optionA);
        mapOptions.put("B", optionB);
        mapOptions.put("C", optionC);
        mapOptions.put("D", optionD);

        mapAudience = new HashMap<>();
        mapFifty = new ArrayList<>();

        stop = (ImageView) findViewById(R.id.stop);
        helpCall = (ImageView) findViewById(R.id.help_call);
        turnOffCall = (ImageView) findViewById(R.id.turn_off_call);
        help5050 = (ImageView) findViewById(R.id.help_50_50);
        turnOff5050 = (ImageView) findViewById(R.id.turn_off_50_50);
        helpAskAudience = (ImageView) findViewById(R.id.help_ask_audience);
        turnOffAsk = (ImageView) findViewById(R.id.turn_off_ask);
        helpChangeQuestion = (ImageView) findViewById(R.id.help_change_question);
        turnOffChange = (ImageView) findViewById(R.id.turn_off_change);

        main1 = new MediaManager(MainActivity.this);
        main1.openMedia(R.raw.bgmain1, true);
        main2 = new MediaManager(MainActivity.this);
        main2.openMedia(R.raw.bgmain2, true);
        main3 = new MediaManager(MainActivity.this);
        main3.openMedia(R.raw.bgmain3, true);
        mark5 = new MediaManager(MainActivity.this);
        mark5.openMedia(R.raw.mark5, false);
        mark10 = new MediaManager(MainActivity.this);
        mark10.openMedia(R.raw.mark10, false);
        mark15 = new MediaManager(MainActivity.this);
        mark15.openMedia(R.raw.mark15, false);
        callWaiting = new MediaManager(MainActivity.this);
        callWaiting.openMedia(R.raw.call_waiting, true);
        callProgress = new MediaManager(MainActivity.this);
        callProgress.openMedia(R.raw.call_progress, false);
        audience = new MediaManager(MainActivity.this);
        audience.openMedia(R.raw.audience_waiting, false);

        soundPool = StartActivity.soundPoolMain;
    }

    public void setControls() {
        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);

        stop.setOnClickListener(this);
        helpCall.setOnClickListener(this);
        turnOffCall.setOnClickListener(this);
        help5050.setOnClickListener(this);
        turnOff5050.setOnClickListener(this);
        helpAskAudience.setOnClickListener(this);
        turnOffAsk.setOnClickListener(this);
        helpChangeQuestion.setOnClickListener(this);
        turnOffChange.setOnClickListener(this);
    }

    public void loadQuestions() {
        questionHandler = new DatabaseHandler(this);
        questionList = questionHandler.getListQuestions();
        currQuestion = questionList.get(number);
    }

    public void displayQuestion() {
        number++;
        questionNumber.setText(" Câu hỏi số " + number + " ");
        setMoney();
        timeHandler(TIME_QUEST);
        question.setText(currQuestion.getQuestionContent());
        optionA.setText(currQuestion.getOptionA());
        optionB.setText(currQuestion.getOptionB());
        optionC.setText(currQuestion.getOptionC());
        optionD.setText(currQuestion.getOptionD());
    }

    public void changeQuestion() {
        currQuestion = questionList.get(15);
        question.setText(currQuestion.getQuestionContent());
        optionA.setText(currQuestion.getOptionA());
        optionB.setText(currQuestion.getOptionB());
        optionC.setText(currQuestion.getOptionC());
        optionD.setText(currQuestion.getOptionD());
        if (isClicked)
            showAllOptions();
    }

    private void timeHandler(long timePlay) {
        timerQuestion = new CountDownTimer(timePlay, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(millisUntilFinished / 1000 - 1 + "");
                currentTime = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                new AlertDialog.Builder(MainActivity.this).setMessage("Bạn có muốn chơi lại không?")
                        .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setCancelable(false)
                        .setTitle("Hết thời gian!")
                        .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                startActivity(getIntent());
                            }
                        })
                        .show();
            }
        };
        timerQuestion.start();
    }

    private void pauseTimer() {
        if (currentTime > 0)
            timerQuestion.cancel();
    }

    private void resumeTimer() {
        if (currentTime > 0)
            timeHandler(currentTime);
    }

    public void setMoney() {
        switch (number) {
            case 1:
                soundPool.play("ques1");
                money.setText("200");
                break;

            case 2:
                soundPool.play("ques2");
                money.setText("400");
                break;

            case 3:
                soundPool.play("ques3");
                money.setText("600");
                break;

            case 4:
                soundPool.play("ques4");
                money.setText("1.000");
                break;
            case 5:
                soundPool.play("ques5");
                money.setText("2.000");
                score = 2000;
                break;

            case 6:
                soundPool.play("ques6");
                money.setText("3.000");
                score = 3000;
                break;

            case 7:
                soundPool.play("ques7");
                money.setText("6.000");
                score = 6000;
                break;

            case 8:
                soundPool.play("ques8");
                money.setText("10.000");
                score = 10000;
                break;

            case 9:
                soundPool.play("ques9");
                money.setText("14.000");
                score = 14000;
                break;

            case 10:
                soundPool.play("ques10");
                money.setText("22.000");
                score = 22000;
                break;

            case 11:
                soundPool.play("ques11");
                money.setText("30.000");
                score = 30000;
                break;

            case 12:
                soundPool.play("ques12");
                money.setText("40.000");
                score = 40000;
                break;

            case 13:
                soundPool.play("ques13");
                money.setText("60.000");
                score = 60000;
                break;

            case 14:
                soundPool.play("ques14");
                money.setText("85.000");
                score = 85000;
                break;

            case 15:
                soundPool.play("ques15");
                money.setText("150.000");
                score = 150000;
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.optionA:
                answerHandler(optionA.getText().toString(), optionA);
                break;

            case R.id.optionB:
                answerHandler(optionB.getText().toString(), optionB);
                break;

            case R.id.optionC:
                answerHandler(optionC.getText().toString(), optionC);
                break;

            case R.id.optionD:
                answerHandler(optionD.getText().toString(), optionD);
                break;

            case R.id.stop:
                new AlertDialog.Builder(MainActivity.this).setMessage("Bạn có chắc chắn muốn dừng cuộc chơi?")
                        .setPositiveButton("Dừng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (number >= 5)
                                    saveScore();
                                finish();
                            }
                        }).setCancelable(false)
                        .setNegativeButton("Chơi tiếp", null)
                        .show();
                break;

            case R.id.help_50_50:
                turnOff5050.setVisibility(View.VISIBLE);
                help5050.setEnabled(false);
                soundPool.play("fifty");
                isClicked = true;

                int count = 0;
                String save = "";
                String alphabet = "ABCD";
                int n = alphabet.length();
                while (count < 2) {
                    Random random = new Random();
                    String randomOption = String.valueOf(alphabet.charAt(random.nextInt(n)));
                    if (!randomOption.equals(currQuestion.getAnswer()) && !save.equals(randomOption)) {
                        mapOptions.get(randomOption).setVisibility(View.INVISIBLE);
                        count++;
                        save = randomOption;
                    }
                }

                for (TextView x : listOption) {
                    if (x.getVisibility() == View.VISIBLE)
                        mapFifty.add(x);
                }
                break;

            case R.id.help_ask_audience:
                turnOffAsk.setVisibility(View.VISIBLE);
                helpAskAudience.setEnabled(false);

                final Dialog audienceDialog = new Dialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog);
                audienceDialog.setContentView(R.layout.custom_layout_audience);
                audienceDialog.setTitle("Hỏi ý kiến khán giả");
                final ProgressBar spinner_a = (ProgressBar) audienceDialog.findViewById(R.id.spinner_a);

                final ImageView col1 = (ImageView) audienceDialog.findViewById(R.id.col_percent_A);
                final ImageView col2 = (ImageView) audienceDialog.findViewById(R.id.col_percent_B);
                final ImageView col3 = (ImageView) audienceDialog.findViewById(R.id.col_percent_C);
                final ImageView col4 = (ImageView) audienceDialog.findViewById(R.id.col_percent_D);

                final TextView txtPercentA = (TextView) audienceDialog.findViewById(R.id.txt_percent_A);
                final TextView txtPercentB = (TextView) audienceDialog.findViewById(R.id.txt_percent_B);
                final TextView txtPercentC = (TextView) audienceDialog.findViewById(R.id.txt_percent_C);
                final TextView txtPercentD = (TextView) audienceDialog.findViewById(R.id.txt_percent_D);

                layout1 = (LinearLayout) audienceDialog.findViewById(R.id.linear_percent_A);

                audienceHandler(currQuestion.getAnswer(), number);
                pauseBackground();
                pauseTimer();
                audience.playBackGround();

                col1.setVisibility(View.INVISIBLE);
                col2.setVisibility(View.INVISIBLE);
                col3.setVisibility(View.INVISIBLE);
                col4.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        // Kiểm tra trường hợp vừa 50-50 vừa khán giả
                        if (isClicked == true) {
                            String fiftyOption1 = String.valueOf(mapFifty.get(0).getText().charAt(0));
                            String fiftyOption2 = String.valueOf(mapFifty.get(1).getText().charAt(0));

                            if (fiftyOption1.equals("A"))
                                setColumnAudience(col1, fiftyOption1, txtPercentA);
                            else if (fiftyOption1.equals("B"))
                                setColumnAudience(col2, fiftyOption1, txtPercentB);
                            else if (fiftyOption1.equals("C"))
                                setColumnAudience(col3, fiftyOption1, txtPercentC);
                            else if (fiftyOption1.equals("D"))
                                setColumnAudience(col4, fiftyOption1, txtPercentD);

                            if (fiftyOption2.equals("A"))
                                setColumnAudience(col1, fiftyOption2, txtPercentA);
                            else if (fiftyOption2.equals("B"))
                                setColumnAudience(col2, fiftyOption2, txtPercentB);
                            else if (fiftyOption2.equals("C"))
                                setColumnAudience(col3, fiftyOption2, txtPercentC);
                            else if (fiftyOption2.equals("D"))
                                setColumnAudience(col4, fiftyOption2, txtPercentD);

                        } else {
                            setColumnAudience(col1, "A", txtPercentA);
                            setColumnAudience(col2, "B", txtPercentB);
                            setColumnAudience(col3, "C", txtPercentC);
                            setColumnAudience(col4, "D", txtPercentD);
                        }
                        spinner_a.setVisibility(View.INVISIBLE);
                        resumeBackground();
                    }
                }, 6500);

                audienceDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        audience.stop();
                        audience.pRelease();
                        resumeTimer();
                    }
                });

                audienceDialog.show();
                break;

            case R.id.help_call:
                turnOffCall.setVisibility(View.VISIBLE);
                helpCall.setEnabled(false);

                final Dialog callDialog = new Dialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog);
                callDialog.setContentView(R.layout.custom_layout_call);
                callDialog.setTitle("Bạn sẽ gọi cho ai?");
                pauseBackground();
                pauseTimer();
                callWaiting.playBackGround();

                final TextView callAnswer = (TextView) callDialog.findViewById(R.id.call_answer);
                final ProgressBar spinner = (ProgressBar) callDialog.findViewById(R.id.spinner);

                final ImageView callDoctor = (ImageView) callDialog.findViewById(R.id.call_doctor);
                final ImageView callTeacher = (ImageView) callDialog.findViewById(R.id.call_teacher);
                final ImageView callFootballer = (ImageView) callDialog.findViewById(R.id.call_footballer);
                final ImageView callLvs = (ImageView) callDialog.findViewById(R.id.call_lvs);
                callDoctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callProgress.playBackGround();
                        spinner.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                spinner.setVisibility(View.GONE);
                                callAnswer.setVisibility(View.VISIBLE);
                                callAnswer.setText("Tôi nghĩ đáp án là " + currQuestion.getAnswer());
                                callDoctor.setEnabled(false);
                                callTeacher.setEnabled(false);
                                callFootballer.setEnabled(false);
                                callLvs.setEnabled(false);
                            }
                        }, 8000);
                    }
                });
                callTeacher.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callProgress.playBackGround();
                        spinner.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                spinner.setVisibility(View.GONE);
                                callAnswer.setVisibility(View.VISIBLE);
                                callAnswer.setText("Tôi nghĩ đáp án là " + currQuestion.getAnswer());
                                callDoctor.setEnabled(false);
                                callTeacher.setEnabled(false);
                                callFootballer.setEnabled(false);
                                callLvs.setEnabled(false);
                            }
                        }, 8000);
                    }
                });
                callFootballer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callProgress.playBackGround();
                        spinner.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                spinner.setVisibility(View.GONE);
                                callAnswer.setVisibility(View.VISIBLE);
                                callAnswer.setText("Tôi nghĩ đáp án là A");
                                if (isClicked)
                                    callAnswer.setText("Tôi nghĩ đáp án là " + String.valueOf(mapFifty.get(1).getText().charAt(0)));
                                callDoctor.setEnabled(false);
                                callTeacher.setEnabled(false);
                                callFootballer.setEnabled(false);
                                callLvs.setEnabled(false);
                            }
                        }, 8000);
                    }
                });
                callLvs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinner.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                spinner.setVisibility(View.GONE);
                                callAnswer.setVisibility(View.VISIBLE);
                                callAnswer.setText("Số điện thoại này tạm thời không liên lạc được :((");
                                callDoctor.setEnabled(false);
                                callTeacher.setEnabled(false);
                                callFootballer.setEnabled(false);
                                callLvs.setEnabled(false);
                            }
                        }, 2000);
                    }
                });

                callDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        resumeBackground();
                        callWaiting.stop();
                        callWaiting.pRelease();
                        callProgress.pRelease();
                        resumeTimer();
                    }
                });

                callDialog.show();
                break;

            case R.id.help_change_question:
                turnOffChange.setVisibility(View.VISIBLE);
                helpChangeQuestion.setEnabled(false);

                changeQuestion();
                break;
        }
    }

    public void audienceHandler(String answer, int number) {
        Random random = new Random();
        int highestPercent = 0;
        if (number <= 5) {
            highestPercent = random.nextInt(20) + 80;
        } else if (number > 5 && number <= 10) {
            highestPercent = random.nextInt(20) + 50;
        } else if (number > 10) {
            highestPercent = random.nextInt(30) + 30;
        }

        int case1, case2, case3;
        case1 = random.nextInt(101 - highestPercent);
        case2 = random.nextInt(101 - highestPercent - case1);
        case3 = 100 - highestPercent - case1 - case2;

        if (isClicked == true) {
            case1 = 100 - highestPercent;
            if (answer.equals(String.valueOf(mapFifty.get(0).getText().charAt(0)))) {
                mapAudience.put(String.valueOf(mapFifty.get(0).getText().charAt(0)), highestPercent);
                mapAudience.put(String.valueOf(mapFifty.get(1).getText().charAt(0)), case1);
            }
            if (answer.equals(String.valueOf(mapFifty.get(1).getText().charAt(0)))) {
                mapAudience.put(String.valueOf(mapFifty.get(1).getText().charAt(0)), highestPercent);
                mapAudience.put(String.valueOf(mapFifty.get(0).getText().charAt(0)), case1);
            }
        } else {
            if (answer.equals("A")) {
                mapAudience.put("A", highestPercent);
                mapAudience.put("B", case1);
                mapAudience.put("C", case2);
                mapAudience.put("D", case3);
            } else {
                if (answer.equals("B")) {
                    mapAudience.put("B", highestPercent);
                    mapAudience.put("A", case1);
                    mapAudience.put("C", case2);
                    mapAudience.put("D", case3);
                } else {
                    if (answer.equals("C")) {
                        mapAudience.put("C", highestPercent);
                        mapAudience.put("A", case1);
                        mapAudience.put("B", case2);
                        mapAudience.put("D", case3);
                    } else {
                        mapAudience.put("D", highestPercent);
                        mapAudience.put("A", case1);
                        mapAudience.put("B", case2);
                        mapAudience.put("C", case3);
                    }
                }
            }
        }
    }

    public void setColumnAudience(ImageView column, String optionLetter, TextView textPercent) {
        column.setVisibility(View.VISIBLE);
        column.getLayoutParams().width = layout1.getWidth();
        column.getLayoutParams().height = ((mapAudience.get(optionLetter) * layout1.getHeight() / 100));
        column.requestLayout();
        textPercent.setVisibility(View.VISIBLE);
        textPercent.setText(mapAudience.get(optionLetter) + "%");
    }

    public void answerHandler(final String answer, final TextView option) {
        pauseTimer();
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("Câu trả lời cuối cùng của bạn là " + answer.substring(0, 1) + "?")
                .setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        pauseTimer();
                        // Câu trả lời được chọn
                        option.setBackgroundResource(R.drawable.press_question);
                        if (number > 5 && number <= 10)
                            soundPool.play("final_answer");
                        else if (number > 10)
                            soundPool.play("final_answer2");
                        disableEnableControls(false, mainLayout);

                        // Câu trả lời đúng
                        Runnable chooseAnswer = new Runnable() {
                            @Override
                            public void run() {
                                if (checkAnswer(answer)) {
                                    // Câu hỏi 1-4
                                    if (number < 5) {
                                        soundPool.play("true1");
                                        new CountDownTimer(1500, 100) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                int time = (int) (millisUntilFinished / 100);
                                                if (time % 2 == 0) {
                                                    option.setBackgroundResource(R.drawable.press_question);
                                                } else {
                                                    option.setBackgroundResource(R.drawable.true_question);
                                                }
                                            }

                                            @Override
                                            public void onFinish() {
                                                disableEnableControls(true, mainLayout);
                                                currQuestion = questionList.get(number);
                                                displayQuestion();
                                                showAllOptions();
                                            }
                                        }.start();

                                        // Mốc câu hỏi số 5
                                    } else if (number == 5) {
                                        main1.stop();
                                        main1.pRelease();
                                        mark5.playBackGround();
                                        new CountDownTimer(10000, 500) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                int time = (int) (millisUntilFinished / 100);
                                                if (time % 2 == 0) {
                                                    option.setBackgroundResource(R.drawable.press_question);
                                                } else {
                                                    option.setBackgroundResource(R.drawable.true_question);
                                                }
                                            }

                                            @Override
                                            public void onFinish() {
                                                main2.playBackGround();
                                                disableEnableControls(true, mainLayout);
                                                currQuestion = questionList.get(number);
                                                displayQuestion();
                                                showAllOptions();
                                            }
                                        }.start();
                                    }

                                    // Câu hỏi 6-9 & 11-15
                                    else if (number > 5 && number < 15 && number != 10) {
                                        soundPool.play("true2");
                                        if (number > 10)
                                            soundPool.play("true3");

                                        new CountDownTimer(4000, 100) {

                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                int time = (int) (millisUntilFinished / 100);
                                                if (time % 2 == 0) {
                                                    option.setBackgroundResource(R.drawable.press_question);
                                                } else {
                                                    option.setBackgroundResource(R.drawable.true_question);
                                                }
                                            }

                                            @Override
                                            public void onFinish() {
                                                disableEnableControls(true, mainLayout);
                                                currQuestion = questionList.get(number);
                                                displayQuestion();
                                                showAllOptions();
                                            }
                                        }.start();
                                    }

                                    // Mốc câu hỏi số 10
                                    else if (number == 10) {
                                        main2.stop();
                                        main2.pRelease();
                                        mark10.playBackGround();
                                        new CountDownTimer(10000, 500) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                int time = (int) (millisUntilFinished / 100);
                                                if (time % 2 == 0) {
                                                    option.setBackgroundResource(R.drawable.press_question);
                                                } else {
                                                    option.setBackgroundResource(R.drawable.true_question);
                                                }
                                            }

                                            @Override
                                            public void onFinish() {
                                                main3.playBackGround();
                                                disableEnableControls(true, mainLayout);
                                                currQuestion = questionList.get(number);
                                                displayQuestion();
                                                showAllOptions();
                                            }
                                        }.start();
                                    }
                                    // Mốc câu hỏi số 15
                                    else if (number == 15) {
                                        main3.stop();
                                        mark15.playBackGround();
                                        saveScore();
                                        new CountDownTimer(10000, 500) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                int time = (int) (millisUntilFinished / 100);
                                                if (time % 2 == 0) {
                                                    option.setBackgroundResource(R.drawable.press_question);
                                                } else {
                                                    option.setBackgroundResource(R.drawable.true_question);
                                                }
                                            }

                                            @Override
                                            public void onFinish() {
                                                disableEnableControls(true, mainLayout);
                                                new AlertDialog.Builder(MainActivity.this).setMessage("Bạn có muốn chơi lại không?").setPositiveButton("Không", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        finish();
                                                    }
                                                }).setCancelable(false)
                                                        .setTitle("Bạn là Triệu Phú. Xin chúc mừng!")
                                                        .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                mark15.stop();
                                                                mark15.pRelease();
                                                                finish();
                                                                startActivity(getIntent());
                                                            }
                                                        })
                                                        .show();
                                            }
                                        }.start();
                                    }


                                    // Câu trả lời sai
                                } else {
                                    pauseBackground();
                                    if (number > 5) {
                                        saveScore();
                                    }

                                    soundPool.play("false");
                                    new CountDownTimer(1500, 100) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            int time = (int) (millisUntilFinished / 100);
                                            if (time % 2 == 0) {
                                                option.setBackgroundResource(R.drawable.press_question);
                                                mapOptions.get(currQuestion.getAnswer()).setBackgroundResource(R.drawable.press_question);
                                            } else {
                                                mapOptions.get(currQuestion.getAnswer()).setBackgroundResource(R.drawable.true_question);

                                            }
                                        }

                                        @Override
                                        public void onFinish() {
                                            new AlertDialog.Builder(MainActivity.this)
                                                    .setTitle("Game Over")
                                                    .setMessage("Bạn có muốn chơi lại không?")
                                                    .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            finish();
                                                            startActivity(getIntent());
                                                        }
                                                    })
                                                    .setCancelable(false)
                                                    .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        }
                                    }.start();
                                }
                            }
                        };
                        if (number <= 5)
                            option.postDelayed(chooseAnswer, 1000);
                        else if (number > 5)
                            option.postDelayed(chooseAnswer, 5500);
                    }
                }).setCancelable(false)
                .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resumeTimer();
                    }
                })
                .show();

    }

    public boolean checkAnswer(String answer) {
        if ((answer.substring(0, 1)).equals(currQuestion.getAnswer()))
            return true;
        return false;
    }

    // show the options after using 50-50
    private void showAllOptions() {
        for (int i = 0; i < listOption.size(); i++) {
            listOption.get(i).setVisibility(View.VISIBLE);
            listOption.get(i).setBackgroundResource(R.drawable.normal_question);
        }
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
    protected void onPause() {
        super.onPause();
        pauseBackground();
        pauseTimer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeBackground();
        resumeTimer();
    }

    private void resumeBackground() {
        if (number <= 5)
            main1.playBackGround();
        else if (number > 5 && number <= 10)
            main2.playBackGround();
        else
            main3.playBackGround();
    }

    private void pauseBackground() {
        if (number <= 5)
            main1.pause();
        else if (number > 5 && number <= 10)
            main2.pause();
        else
            main3.pause();
    }

    public void saveScore() {
        StartActivity.scoreHandler.addScore(new ScoreItem(StartActivity.playerName.getText().toString(), score, currentDate));
    }
}
