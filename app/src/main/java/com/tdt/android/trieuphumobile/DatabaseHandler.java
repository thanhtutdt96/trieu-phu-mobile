package com.tdt.android.trieuphumobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tu on 21-Apr-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "millionaireQuestion";
    private static final String TABLE_QUESTION = "Question";
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION_CONTENT = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTION_A = "optionA";
    private static final String KEY_OPTION_B = "optionB";
    private static final String KEY_OPTION_C = "optionC";
    private static final String KEY_OPTION_D = "optionD";
    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESTION_CONTENT
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTION_A + " TEXT, "
                + KEY_OPTION_B + " TEXT, " + KEY_OPTION_C + " TEXT, " + KEY_OPTION_D + " TEXT)";
        db.execSQL(sql);
        addQuestion();
    }

    public void closeDatabase() {
        database.close();
    }

    private void addQuestion() {
        QuestionList qList = new QuestionList();
        for (QuestionItem q : qList.listQuestion)
            this.addQuestion(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_QUESTION);
        onCreate(db);
    }

    public void addQuestion(QuestionItem q) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION_CONTENT, q.getQuestionContent());
        values.put(KEY_ANSWER, q.getAnswer());
        values.put(KEY_OPTION_A, q.getOptionA());
        values.put(KEY_OPTION_B, q.getOptionB());
        values.put(KEY_OPTION_C, q.getOptionC());
        values.put(KEY_OPTION_D, q.getOptionD());
        database.insert(TABLE_QUESTION, null, values);
    }

    public List<QuestionItem> getListQuestions() {
        List<QuestionItem> questionItemList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_QUESTION + " ORDER BY RANDOM() LIMIT 16";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                QuestionItem q = new QuestionItem();
                q.setId(cursor.getInt(0));
                q.setQuestionContent(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptionA(cursor.getString(3));
                q.setOptionB(cursor.getString(4));
                q.setOptionC(cursor.getString(5));
                q.setOptionD(cursor.getString(6));
                questionItemList.add(q);
            } while (cursor.moveToNext());
        }
        return questionItemList;
    }
}
