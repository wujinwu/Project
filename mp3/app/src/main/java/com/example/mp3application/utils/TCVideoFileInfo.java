package com.example.mp3application.utils;


import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TCVideoFileInfo implements Parcelable, Comparable<TCVideoFileInfo> {
    public static final int FILE_TYPE_VIDEO = 0;
    public static final int FILE_TYPE_PICTURE = 1;
    private int fileId;
    private String filePath;
    private String fileName;
    private String thumbPath;
    private boolean isSelected = false;
    private long duration;
    private int fileType = FILE_TYPE_VIDEO;
    private Uri fileUri;
    private long fileSize;
    private long fileTime;

    public TCVideoFileInfo() {
    }

    public TCVideoFileInfo(int fileId, String filePath, String fileName, String thumbPath, int duration, int fileSize, int fileTime) {
        this.fileId = fileId;
        this.filePath = filePath;
        this.fileName = fileName;
        this.thumbPath = thumbPath;
        this.duration = duration;
        this.fileSize = fileSize;
        this.fileTime = fileTime;
    }

    public TCVideoFileInfo(int fileId, Uri fileUri, String fileName, String thumbPath, int duration, int fileSize, int fileTime) {
        this.fileId = fileId;
        this.fileUri = fileUri;
        this.fileName = fileName;
        this.thumbPath = thumbPath;
        this.duration = duration;
        this.fileSize = fileSize;
        this.fileTime = fileTime;
    }

    protected TCVideoFileInfo(Parcel in) {
        fileId = in.readInt();
        filePath = in.readString();
        fileName = in.readString();
        thumbPath = in.readString();
        isSelected = in.readByte() != 0;
        duration = in.readLong();
        fileType = in.readInt();
        fileSize = in.readLong();
        fileTime = in.readLong();
        fileUri = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(fileId);
        dest.writeString(filePath);
        dest.writeString(fileName);
        dest.writeString(thumbPath);
        dest.writeByte((byte) (isSelected ? 1 : 0));
        dest.writeLong(duration);
        dest.writeLong(fileSize);
        dest.writeLong(fileTime);
        dest.writeInt(fileType);
        dest.writeParcelable(fileUri, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TCVideoFileInfo> CREATOR = new Creator<TCVideoFileInfo>() {
        @Override
        public TCVideoFileInfo createFromParcel(Parcel in) {
            return new TCVideoFileInfo(in);
        }

        @Override
        public TCVideoFileInfo[] newArray(int size) {
            return new TCVideoFileInfo[size];
        }
    };

    public int getFileId() {
        return this.fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public Uri getFileUri() {
        return fileUri;
    }

    public void setFileUri(Uri fileUri) {
        this.fileUri = fileUri;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public long getFileTime() {
        return fileTime;
    }

    public void setFileTime(long fileTime) {
        this.fileTime = fileTime;
    }

    @NonNull
    @Override
    public String toString() {
        return "TCVideoFileInfo{" +
                "fileId=" + fileId +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", thumbPath='" + thumbPath + '\'' +
                ", isSelected=" + isSelected +
                ", duration=" + duration +
                '}';
    }


    @Override
    public int compareTo(TCVideoFileInfo o) {
        return toString().compareTo(o.toString());
    }
}
