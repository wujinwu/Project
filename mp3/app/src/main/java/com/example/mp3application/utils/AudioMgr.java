package com.example.mp3application.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

public class AudioMgr {

    private static final String TAG = "AudioMgr";

    /**
     * 歌曲ID：MediaStore.Audio.Media._ID
     * Int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
     * 歌曲的名称 ：MediaStore.Audio.Media.TITLE
     * String tilte = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
     * 歌曲的专辑名：MediaStore.Audio.Media.ALBUM
     * String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
     * 歌曲的歌手名： MediaStore.Audio.Media.ARTIST
     * String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
     * 歌曲文件的全路径 ：MediaStore.Audio.Media.DATA
     * String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
     * 歌曲文件的名称：MediaStroe.Audio.Media.DISPLAY_NAME
     * String display_name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
     * 歌曲文件的发行日期：MediaStore.Audio.Media.YEAR
     * String year = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.YEAR));
     * 歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
     * Int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
     * 歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
     * Int size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
     */
    public static ArrayList<TCVideoFileInfo> getAllAudio(Context context) {
        ArrayList<TCVideoFileInfo> audios = new ArrayList<TCVideoFileInfo>();
        String[] mediaColumns = new String[]{
                MediaStore.Audio.AudioColumns._ID,
                //DATA 数据在 Android Q 以前代表了文件的路径，但在 Android Q上该路径无法被访问。
                MediaStore.Audio.AudioColumns.DATA,
                MediaStore.Audio.AudioColumns.DISPLAY_NAME,
                MediaStore.Audio.AudioColumns.YEAR,
                MediaStore.Audio.AudioColumns.DURATION,
                MediaStore.Audio.AudioColumns.SIZE,
        };
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mediaColumns, null, null, null);

        if (cursor == null) return audios;

        if (cursor.moveToFirst()) {
            do {
                TCVideoFileInfo fileItem = new TCVideoFileInfo();
                // 兼容 Android 10以上
                Uri uri = ContentUris.withAppendedId(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, cursor.getLong(cursor.getColumnIndexOrThrow((MediaStore.Audio.Media._ID))));
                fileItem.setFileUri(uri);
                fileItem.setFilePath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                fileItem.setFileName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                fileItem.setFileType(TCVideoFileInfo.FILE_TYPE_VIDEO);
                long duration = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                if (duration < 0)
                    duration = 0;
                fileItem.setDuration(duration);

                long time = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.YEAR));
                if (time < 0)
                    time = 0;
                fileItem.setFileTime(time);

                long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                if (size < 0)
                    size = 0;
                fileItem.setFileSize(size);
                if (fileItem.getFileName() != null && fileItem.getFileName().endsWith(".mp3")) {
                    audios.add(fileItem);
                }
                Log.d(TAG, "fileItem = " + fileItem.toString());
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return audios;
    }
}