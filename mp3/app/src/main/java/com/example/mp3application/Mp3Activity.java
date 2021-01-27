package com.example.mp3application;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mp3application.service.MusicService;
import com.example.mp3application.utils.DateUtils;
import com.example.mp3application.utils.TCVideoFileInfo;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Mp3Activity extends BaseActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_name)
    TextView ivName;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;

    public MediaPlayer mediaPlayer;

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer = null;
        super.onDestroy();
    }

    public static final int UPDATE_PROGRESS = 0;
    //使用handler定时更新进度条
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PROGRESS:
                    updateProgress();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);
        ButterKnife.bind(this);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (getIntent().getData() != null) {
            playMusic(getIntent().getData());
            handler.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
        }
        if (getIntent().getParcelableExtra("uri") != null) {
            TCVideoFileInfo tcVideoFileInfo = getIntent().getParcelableExtra("uri");
            playMusic(tcVideoFileInfo.getFileUri());
            handler.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
        }

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
            mediaPlayer.setDataSource(Mp3Activity.this, musicPath);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    String TAG = "mp3";

    //更新进度条
    private void updateProgress() {
        if (null == seekbar) {
            return;
        }
        if (getIntent().getData() != null) {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(this, getIntent().getData());
            String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            Log.d(TAG, "title:" + title);
            String album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            Log.d(TAG, "album:" + album);
            String artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            Log.d(TAG, "artist:" + artist);
            String duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION); // 播放时长单位为毫秒
            tvTitle.setText(title);
        }
        if (getIntent().getParcelableExtra("uri") != null) {
            TCVideoFileInfo tcVideoFileInfo = getIntent().getParcelableExtra("uri");
            tvTitle.setText(tcVideoFileInfo.getFileName());
        }

        seekbar.setProgress(getDuration());
        //使用Handler每500毫秒更新一次进度条
        handler.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
        //设置进度条的最大值
        seekbar.setMax(getDuration());
        //设置进度条的进度
        seekbar.setProgress(getCurrentPosition());
        tvStartTime.setText(DateUtils.minutesdd(getCurrentPosition()));
        tvEndTime.setText(DateUtils.minutesdd(getDuration()));
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

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mediaPlayer.start();
    }
}
