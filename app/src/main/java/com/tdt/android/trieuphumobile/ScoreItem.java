package com.tdt.android.trieuphumobile;

/**
 * Created by Tu on 28-Apr-17.
 */

public class ScoreItem {
    private int id;
    private String name;
    private int score;
    private String date;

    public ScoreItem() {
        id = 0;
        name = "";
        score = 0;
        date = "";
    }

    public ScoreItem(String name, int score, String date) {
        this.name = name;
        this.score = score;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
