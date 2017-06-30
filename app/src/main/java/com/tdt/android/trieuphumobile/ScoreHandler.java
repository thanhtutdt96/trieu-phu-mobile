package com.tdt.android.trieuphumobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tu on 02-May-17.
 */

public class ScoreHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "hightScore";
    private static final String TABLE_SCORE = "Score";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SCORE = "score";
    private static final String KEY_DATE = "date";

    public ScoreHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
                + " TEXT, " + KEY_SCORE + " INTEGER, " + KEY_DATE + " TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }

    public void addScore(ScoreItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());
        values.put(KEY_SCORE, item.getScore());
        values.put(KEY_DATE, item.getDate());
        db.insert(TABLE_SCORE, null, values);
        db.close();
    }

    public List<ScoreItem> getListScores() {
        List<ScoreItem> scoreItemList = new ArrayList<>();
        String query = "SELECT  * FROM " + TABLE_SCORE + " ORDER BY " + KEY_SCORE + " DESC LIMIT 8";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                ScoreItem s = new ScoreItem();
                s.setId(cursor.getInt(0));
                s.setName(cursor.getString(1));
                s.setScore(cursor.getInt(2));
                s.setDate(cursor.getString(3));
                scoreItemList.add(s);
            } while (cursor.moveToNext());
        }
        return scoreItemList;
    }
}
