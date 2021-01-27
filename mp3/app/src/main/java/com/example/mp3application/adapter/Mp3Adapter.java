package com.example.mp3application.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.mp3application.R;
import com.example.mp3application.utils.DateUtils;
import com.example.mp3application.utils.FileSizeUtil;
import com.example.mp3application.utils.TCVideoFileInfo;


import java.util.ArrayList;

public class Mp3Adapter extends BaseQuickAdapter<TCVideoFileInfo, BaseViewHolder> {

    public Mp3Adapter(ArrayList<TCVideoFileInfo> data) {
        super(R.layout.adapter_mp3, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TCVideoFileInfo item) {

        ((TextView) helper.getView(R.id.tv_name)).setText(item.getFileName());
        ((TextView) helper.getView(R.id.tv_size)).setText(FileSizeUtil.FormetFileSize(item.getFileSize()));
        ((TextView) helper.getView(R.id.tv_time)).setText(DateUtils.timeDYmd(item.getFileTime()));

    }
}