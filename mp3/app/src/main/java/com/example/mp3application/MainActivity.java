package com.example.mp3application;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.mp3application.adapter.Mp3Adapter;
import com.example.mp3application.service.MusicService;
import com.example.mp3application.utils.AudioMgr;
import com.example.mp3application.utils.DateUtils;
import com.example.mp3application.utils.TCVideoFileInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ServiceConnection {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_titles)
    TextView tvTitles;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.iv_start)
    ImageView ivStart;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.rl_rcv)
    RelativeLayout rlRcv;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    String TAG = "MP3";

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicControl = null;
        unbindService(this);
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
    @SuppressLint("HandlerLeak")
    private Handler mMainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            fileInfoArrayList.addAll((ArrayList<TCVideoFileInfo>) msg.obj);
            mp3Adapter.notifyDataSetChanged();
            tvTitle.setText(fileInfoArrayList.get(0).getFileName());
            tvEndTime.setText(DateUtils.minutesdd(fileInfoArrayList.get(0).getDuration()));

        }
    };

    ArrayList<TCVideoFileInfo> fileInfoArrayList = new ArrayList<>();
    Mp3Adapter mp3Adapter;
    int positon = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMusicServer();
        mHandlerThread = new HandlerThread("LoadList");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
        initRcvView();
        loadAudioList();
        ivStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positon == -1) {
                    positon = 0;
                    musicControl.playMusic(fileInfoArrayList.get(0).getFileUri());
                    handler.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
                    return;
                }
                if (musicControl.isPlaying()) {
                    musicControl.playOrPause();
                } else {
                    musicControl.playOrPause();
                }
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlRcv.setVisibility(View.GONE);
            }
        });

        ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlRcv.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initRcvView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mp3Adapter = new Mp3Adapter(fileInfoArrayList);
        recyclerView.setAdapter(mp3Adapter);
        mp3Adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                positon = position;
                musicControl.playMusic(fileInfoArrayList.get(position).getFileUri());
                if (!handler.hasMessages(500)) {
                    handler.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
                }
                tvTitle.setText(fileInfoArrayList.get(position).getFileName());
                tvEndTime.setText(DateUtils.minutesdd(fileInfoArrayList.get(position).getDuration()));
            }
        });
    }


    private void loadAudioList() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    ArrayList<TCVideoFileInfo> fileInfoArrayList = AudioMgr.getAllAudio(MainActivity.this);
                    Message msg = new Message();
                    msg.obj = fileInfoArrayList;
                    mMainHandler.sendMessage(msg);
                }
            });
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }

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
        if (musicControl.isPlaying()) {
            ivStart.setImageResource(R.mipmap.icon_stop);
        } else {
            ivStart.setImageResource(R.mipmap.icon_start);
        }
        seekbar.setProgress(musicControl.getDuration());
        //使用Handler每500毫秒更新一次进度条
        handler.sendEmptyMessageDelayed(UPDATE_PROGRESS, 500);
        //设置进度条的最大值
        seekbar.setMax(musicControl.getDuration());
        //设置进度条的进度
        seekbar.setProgress(musicControl.getCurrentPosition());
        tvStartTime.setText(DateUtils.minutesdd(musicControl.getCurrentPosition()));
        tvEndTime.setText(DateUtils.minutesdd(musicControl.getDuration()));
    }


    public void getMusicServer() {
        Intent intent3 = new Intent(this, MusicService.class);
        //使用混合的方法开启服务，
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent3);
        } else {
            startService(intent3);
        }
        bindService(intent3, this, UPDATE_PROGRESS);
    }


    //退出时的时间
    private long mExitTime;

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    public MusicService.MyBinder musicControl;

    //服务启动完成后会进入到这个方法
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        //获得service中的MyBinder
        musicControl = (MusicService.MyBinder) service;
        musicControl.getMediaPlayer().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                positon++;
                musicControl.playMusic(fileInfoArrayList.get(positon).getFileUri());
                tvTitle.setText(fileInfoArrayList.get(positon).getFileName());
                tvEndTime.setText(DateUtils.minutesdd(fileInfoArrayList.get(positon).getDuration()));
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

}


