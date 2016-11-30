package com.mroto.jjd311_p7_multimedia;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

public class MyMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private static final String TAG = MyMediaPlayer.class.getSimpleName();

    private MediaPlayer mMediaPlayer;
    private Context mContext;
    private int mRes;

    public MyMediaPlayer(Context context, int res) {
        Log.e(MyMediaPlayer.TAG, "MyMediaPlayer");
        this.mContext = context;
        this.mRes = res;
        this.createMediaPlayer();
    }

    private void createMediaPlayer() {
        this.mMediaPlayer = MediaPlayer.create(this.mContext, this.mRes);
        this.mMediaPlayer.setOnPreparedListener(this);
        this.mMediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        Log.e(MyMediaPlayer.TAG, "onPrepared");
    }

    public void startPause() {
        if (this.mMediaPlayer == null) {
            this.createMediaPlayer();
        }
        String msg;
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            msg = "Pause";
        } else {
            this.mMediaPlayer.start();
            msg = "Play";
        }
        Log.e(MyMediaPlayer.TAG, msg);
        Toast.makeText(this.mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void stop() {
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mMediaPlayer.seekTo(0);
            Log.e(MyMediaPlayer.TAG, "Stop");
            Toast.makeText(this.mContext, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        Log.e(MyMediaPlayer.TAG, "onCompletion");
        Toast.makeText(this.mContext, "Complete", Toast.LENGTH_SHORT).show();
        this.release();
    }

    public void release() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }
}
