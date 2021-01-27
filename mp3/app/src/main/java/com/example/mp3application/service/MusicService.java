package com.example.mp3application.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.FileUtils;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;


import com.example.mp3application.MainActivity;
import com.example.mp3application.R;

import java.io.IOException;
import java.util.ArrayList;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    public MediaPlayer mediaPlayer;

    @Override
    public void onDestroy() {
        mediaPlayer = null;
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        silentForegroundNotification();
    }

    @TargetApi(26)
    private void silentForegroundNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //开启服务  必须通知
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel("audio", "音频播放", NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "audio");
            builder.setContentTitle(getString(R.string.app_name) + "正在后台播放");
            builder.setContentText("");
            builder.setDefaults(Notification.DEFAULT_ALL);
            builder.setAutoCancel(true);
            builder.setShowWhen(true);
            startForeground(2, builder.build());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    //  通过 Binder 来保持 Activity 和 Service 的通信
    public MyBinder binder = new MyBinder();

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mediaPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        //play over
        /**
         * 停止
         */
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return true;
    }


    public class MyBinder extends Binder {

        public MediaPlayer getMediaPlayer() {
            return mediaPlayer;
        }

        /**
         * 播放音乐
         *
         * @param musicPath 音乐文件的路径
         */
        public void playMusic(Uri musicPath) {
            if (mediaPlayer != null) {
                get(musicPath);
            }

        }

        private void get(Uri musicPath) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(MusicService.this, musicPath);
                mediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void play() {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();

            }

        }

        public void pause() {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }

        public void playOrPause() {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }

        public boolean isPlaying() {
            return mediaPlayer.isPlaying();
        }

        public int getCurrentPosition() {
            int currentPosition = 0;
            if (null != mediaPlayer) {
                currentPosition = mediaPlayer.getCurrentPosition();
            }
            return currentPosition;
        }

        public int getDuration() {
            int duration = 0;
            if (null != mediaPlayer) {
                duration = mediaPlayer.getDuration();
            }
            return duration;
        }

        public void stop() {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        }
    }


    @Override
    public boolean onUnbind(Intent intent) {
        releaseMediaPlayer();
        return super.onUnbind(intent);
    }

    /**
     * 释放资源
     */
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            //关键语句
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


}