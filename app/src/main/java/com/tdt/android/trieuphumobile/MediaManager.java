package com.tdt.android.trieuphumobile;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by Tu on 23-Apr-17.
 */

public class MediaManager {
    private MediaPlayer player;
    private int songLength;
    private SoundPool soundPool;
    private HashMap<String, Integer> soundPoolMap;
    private AudioManager audioManager;
    private Context context;

    public MediaManager(Context context) {
        this.context = context;
        sRelease();
        soundPool = new SoundPool(32, AudioManager.STREAM_MUSIC, 0);
        soundPoolMap = new HashMap<>();
        audioManager = (AudioManager) this.context.getSystemService(Context.AUDIO_SERVICE);
    }

        public void add(String name, int id) {
        soundPoolMap.put(name, soundPool.load(context, id, 1));
    }

    public void play(String name) {
        int streamVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        soundPool.play(soundPoolMap.get(name), streamVolume, streamVolume, 1, 0, 1f);
    }

    public void openMedia(int id, boolean loop) {
        pRelease();
        player = MediaPlayer.create(context, id);
        if (loop) {
            player.setLooping(true);
        }
    }

    public void playBackGround() {
        if (player != null && !player.isPlaying()) {
            if (songLength > 0)
                player.seekTo(songLength);
            player.start();
        }
    }

    public void pRelease() {
        if (player != null) {
            player.release();
        }
    }

    public void sRelease() {
        if (soundPool != null) {
            soundPool.release();
        }
    }


    public void stop() {
        if (player != null && player.isPlaying()) {
            player.stop();
        }
    }
    public boolean isPlaying(){
        return player.isPlaying();
    }

    public void pause() {
        if (player != null && player.isPlaying()) {
            if (songLength > 0)
                songLength = player.getCurrentPosition();
            player.pause();
        }
    }
}
