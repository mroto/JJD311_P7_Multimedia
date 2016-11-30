package com.mroto.jjd311_p7_multimedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MyMediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(MainActivity.TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnPlaySound).setOnClickListener(this);
        findViewById(R.id.btnPlaySoundInService).setOnClickListener(this);
        findViewById(R.id.btnPlayTrack).setOnClickListener(this);
        findViewById(R.id.btnStopTrack).setOnClickListener(this);

        this.mPlayer = new MyMediaPlayer(this, R.raw.bensoundbrazilsamba);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnPlaySound:
                Log.e(MainActivity.TAG, "btnPlaySound");
                break;
            case R.id.btnPlaySoundInService:
                Log.e(MainActivity.TAG, "btnPlaySoundInService");
                break;
            case R.id.btnPlayTrack:
                Log.e(MainActivity.TAG, "btnPlayTrack");
                this.mPlayer.startPause();
                break;
            case R.id.btnStopTrack:
                Log.e(MainActivity.TAG, "btnStopTrack");
                this.mPlayer.stop();
                break;
        }
    }

    @Override
    protected void onPause() {
        Log.e(MainActivity.TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e(MainActivity.TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e(MainActivity.TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.e(MainActivity.TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.e(MainActivity.TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(MainActivity.TAG, "onDestroy");
        super.onDestroy();
    }
}
